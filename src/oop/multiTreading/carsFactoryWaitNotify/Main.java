package oop.multiTreading.carsFactoryWaitNotify;

import oop.multiTreading.carsFactory.Factory;
import oop.multiTreading.carsFactory.Parking;
import oop.multiTreading.carsFactory.Ship;
import oop.multiTreading.carsFactory.Tresher;
import oop.multiTreading.carsFactory.Truck;
import oop.multiTreading.carsFactory.Tugboat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("factoryWaitNotify.txt"))) {
            Parking bmwMercedesParking = new Parking("BMW_Mercedes", writer);
            Parking skodaParking = new Parking("Skoda", writer);

            Factory bmw = new Factory("BMW", writer, bmwMercedesParking);
            Factory mercedes = new Factory("Mercedes", writer, bmwMercedesParking);
            Factory skoda = new Factory("Skoda", writer, skodaParking);

            Tresher tresher = new Tresher();
            Ship ship = new Ship(writer);

            Truck truck = new Truck(writer, ship, tresher);
            truck.addParking(bmwMercedesParking);
            truck.addParking(skodaParking);

            Tugboat tugboat = new Tugboat(ship, writer);

            bmw.setDaemon(true);
            mercedes.setDaemon(true);
            skoda.setDaemon(true);
            truck.setDaemon(true);
            tugboat.setDaemon(true);

            bmw.start();
            mercedes.start();
            skoda.start();
            truck.start();
            tugboat.start();

            Thread.sleep(40000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
