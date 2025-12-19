package oop.multiTreading.carsFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class Factory extends Thread {
    private final String brand;
    private final BufferedWriter writer;
    private final Parking parking;

    public Factory(String brand, BufferedWriter writer, Parking parking) {
        this.brand = brand;
        this.writer = writer;
        this.parking = parking;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (parking) {
                    if (!parking.isFull()) {
                        System.out.println("Factory: " + brand + " send car to parking space\n");
                        writer.append("Factory: " + brand + " send car to parking space\n");
                        parking.add(new Car(brand));
                    }
                }
                sleep(new Random().nextInt(1000, 2000));
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
