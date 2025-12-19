package oop.multiTreading.barberShop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("barberShopLogs.txt"))) {
            BarberShop shop = new BarberShop(2, writer);
            ClientGenerator generator1 = new ClientGenerator(writer, shop,"Soft_Serve");
            ClientGenerator generator2 = new ClientGenerator(writer, shop,"Epam");
            ClientGenerator generator3 = new ClientGenerator(writer, shop,"Privat");
            ClientGenerator generator4 = new ClientGenerator(writer, shop,"Ralf");
            ClientGenerator generator5 = new ClientGenerator(writer, shop,"Hotline");
            generator1.setDaemon(true);
            generator2.setDaemon(true);
            generator3.setDaemon(true);
            generator4.setDaemon(true);
            generator5.setDaemon(true);
            generator1.start();
            generator2.start();
            generator3.start();
            generator4.start();
            generator5.start();

            shop.work();

            Thread.sleep(40000);
            System.out.println("* * * * * * ");
            generator3.getStatistics();
            shop.getStatistics();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
