package oop.multiTreading.store;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("history.txt"))) {
            Shop shop = new Shop(writer);
            Supplier apple = new Supplier(writer, shop, "Apple");
            Supplier samsung = new Supplier(writer, shop, "Samsung");
            Supplier xiaomi = new Supplier(writer, shop, "Xiaomi");
            Client mark = new Client(writer, "Mark", shop);
            Client ivan = new Client(writer, "Ivan", shop);
            Client orest = new Client(writer, "Orest", shop);

            apple.setDaemon(true);
            samsung.setDaemon(true);
            xiaomi.setDaemon(true);
            mark.setDaemon(true);
            ivan.setDaemon(true);
            orest.setDaemon(true);

            apple.start();
            samsung.start();
            xiaomi.start();
            mark.start();
            ivan.start();
            orest.start();

            Thread.sleep(25000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
