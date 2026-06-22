package oop.multiTreading.store;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Shop {
    private final ArrayList<Product> products = new ArrayList<>();
    private final int shopSize = 19;
    private final BufferedWriter writer;

    public Shop(BufferedWriter writer) {
        this.writer = writer;
    }

    public void addProduct(Product product, String supplierName) {
        try {
            products.add(product);
            System.out.println(supplierName + " [add product to shop] -> " + product + "\n");
            writer.append(supplierName + " [add product to shop] -> " + product + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product requestProduct(String brand, String type, String clientName) {
        Product buffer = null;
        try {
            for (Product p : products) {
                if (p != null) {
                    if (p.getType().equals(type) && p.getBrand().equals(brand) && p.getType() != null && p.getBrand() != null) {
                        System.out.println(clientName + " [request product from shop] -> " + p + "\n");
                        writer.append(clientName + " [request product from shop] -> " + p + "\n");
                        buffer = p;
                        products.remove(p);
                    }
                }
            }
            System.out.println(clientName + " [request product] -> " + brand + " || but, it's not available\n");
            writer.append(clientName + " [request product] -> " + brand + " || but, it's not available\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public boolean isFull() {
        return products.size() == shopSize;
    }
}
