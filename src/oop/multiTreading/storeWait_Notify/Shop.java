package oop.multiTreading.storeWait_Notify;

import oop.multiTreading.store.Product;

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

    public synchronized void addProduct(Product product, String supplierName) {
        try {
            if (products.size() == shopSize) {
                wait();
            }
            products.add(product);
            System.out.println(supplierName + " [add product to shop] -> " + product + "\n");
            writer.append(supplierName + " [add product to shop] -> " + product + "\n");
            notifyAll();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Product requestProduct(String brand, String type, String clientName) {
        try {
            if (products.isEmpty()) {
                wait();
            }
            Product toFind = null;
            for (Product p : products) {
                if (p.getType().equals(type) && p.getBrand().equals(brand)) {
                    System.out.println(clientName + " [requested product from shop] -> " + p + "\n");
                    writer.append(clientName + " [requested product from shop] -> " + p + "\n");
                    toFind = p;
                    products.remove(p);
                    return toFind;
                }
            }
            System.out.println(clientName + " [requested product] -> " + brand + " " + type + " || but, it's not available\n");
            writer.append(clientName + " [requested product] -> " + brand + type + " || but, it's not available\n");
            notifyAll();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
