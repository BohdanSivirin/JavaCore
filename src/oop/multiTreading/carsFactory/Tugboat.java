package oop.multiTreading.carsFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class Tugboat extends Thread {
    private final Ship ship;
    private final BufferedWriter writer;

    public Tugboat(Ship ship, BufferedWriter writer) {
        this.ship = ship;
        this.writer = writer;
    }

    public void run() {
        while (true) {
            try {
                synchronized (ship) {
                    if (ship.isFull()) {
                        System.out.println("Tugboat lifted Ship away\n");
                        writer.append("Tugboat lifted Ship away\n");
                        ship.remove();
                    }
                }
                sleep(new Random().nextInt(1000, 2000));
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
