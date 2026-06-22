package oop.multiTreading.storeWait_Notify;

import oop.multiTreading.store.Product;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Supplier extends Thread {
    private final String brand;
    private final BufferedWriter writer;
    private final Shop shop;
    private static final HashMap<String, HashMap<String, Double>> devices;

    public Supplier(BufferedWriter writer, Shop shop, String brand) {
        this.writer = writer;
        this.shop = shop;
        this.brand = brand;
    }

    static {
        devices = new HashMap<>();
        HashMap<String, Double> appleModelAndPrice = new HashMap<>();
        appleModelAndPrice.put("phone", 42502.25);
        appleModelAndPrice.put("laptop", 66505.12);
        appleModelAndPrice.put("tv", 24359.25);
        devices.put("Apple", appleModelAndPrice);

        HashMap<String, Double> samsungModelAndPrice = new HashMap<>();
        samsungModelAndPrice.put("phone", 38789.25);
        samsungModelAndPrice.put("laptop", 29129.69);
        samsungModelAndPrice.put("tv", 34289.33);
        devices.put("Samsung", samsungModelAndPrice);

        HashMap<String, Double> xiaomiModelAndPrice = new HashMap<>();
        xiaomiModelAndPrice.put("phone", 11189.15);
        xiaomiModelAndPrice.put("laptop", 13529.19);
        xiaomiModelAndPrice.put("tv", 14289.43);
        devices.put("Xiaomi", xiaomiModelAndPrice);
    }

    @Override
    public void run() {
        while (true) {
            Product p;
            try {
                HashMap<String, Double> map = devices.get(brand);
                ArrayList<String> types = new ArrayList<>(map.keySet());
                int random = new Random().nextInt(types.size());
                String model = types.get(random);
                Double price = map.get(model);
                long serial = Math.abs(new Random().nextLong(Long.MIN_VALUE, Long.MAX_VALUE));
                p = new Product(brand, model, price, serial);
                shop.addProduct(p, brand);
                System.out.println("Supplier: " + brand + " [send product:] " + p + "\n");
                writer.append("Supplier: " + brand + " [send product:] " + p + "\n");
                sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
