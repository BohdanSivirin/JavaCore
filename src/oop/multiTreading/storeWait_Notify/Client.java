package oop.multiTreading.storeWait_Notify;

import oop.multiTreading.store.Product;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Client extends Thread {
    private final BufferedWriter writer;
    private final String name;
    private final Shop shop;
    private static final ArrayList<String> brands = new ArrayList<>();
    private static final ArrayList<String> types = new ArrayList<>();

    static {
        Collections.addAll(brands, "Apple", "Samsung", "Xiaomi");
        Collections.addAll(types, "Phone", "Laptop", "TV");
    }

    public Client(BufferedWriter writer, String name, Shop shop) {
        this.writer = writer;
        this.shop = shop;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String brand = brands.get(new Random().nextInt(brands.size()));
                String type = types.get(new Random().nextInt(types.size()));
                Product p = shop.requestProduct(brand, type, name);
                System.out.println("Client: " + name + " [requested product:] " + p + "\n");
                writer.append("Client: " + name + " [requested product:] " + p + "\n");
                sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
