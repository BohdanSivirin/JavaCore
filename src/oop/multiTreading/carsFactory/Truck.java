package oop.multiTreading.carsFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Truck extends Thread {
    private final int size = 8;
    private final ArrayList<Car> cars = new ArrayList<>();
    private final BufferedWriter writer;
    private final ArrayList<Parking> parkings = new ArrayList<>();
    private final Ship ship;
    private final Tresher tresher;


    public Truck(BufferedWriter writer, Ship ship, Tresher tresher) {
        this.writer = writer;
        this.ship = ship;
        this.tresher = tresher;
    }

    public void addParking(Parking parking) {
        if (parking != null) {
            parkings.add(parking);
        }
    }

    public void run() {
        while (true) {
            try {
                while (cars.size() < size) {
                    for (Parking parking : parkings) {
                        synchronized (parking) {
                            System.out.println("Truck drive into parking: " + parking.getName() + "\n");
                            writer.append("Truck drive into parking: " + parking.getName() + "\n");
                            cars.addAll(parking.getCarsFromParking(size - cars.size()));
                            sleep(1000);
                        }
                    }
                }
                for (Car car : cars) {
                    System.out.println("Truck load a Car: " + car + "\n");
                    writer.append("Truck load a Car: " + car + "\n");
                }
                sleep(1000);
                System.out.println("Truck is full and goes to Ship\n");
                writer.append("Truck is full and goes to Ship\n");
                while (!cars.isEmpty()) {
                    synchronized (ship) {
                        try {
                            Car car;
                            if (!ship.isFull()) {
                                car = cars.remove(0);
                                System.out.println("Truck send Car to Ship: " + car + "\n");
                                writer.append("Truck send Car to Ship: " + car + "\n");
                                ship.add(car);
                            }
                        } catch (SimilarSerialNumberException e) {
                            System.out.println("Truck send car to Tresher: " + e.getCar() + "\n");
                            writer.append("Truck send car to Tresher: " + e.getCar() + "\n");
                            tresher.add(e.getCar());
                        }
                    }
                    sleep(500);
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
