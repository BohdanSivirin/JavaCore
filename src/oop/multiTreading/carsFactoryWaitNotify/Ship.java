package oop.multiTreading.carsFactoryWaitNotify;

import oop.multiTreading.carsFactory.Car;
import oop.multiTreading.carsFactory.SimilarSerialNumberException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ship {
    private final int size = 10;
    private final ArrayList<Car> carsOnShip = new ArrayList<>();
    private final BufferedWriter writer;

    public Ship(BufferedWriter writer) {
        this.writer = writer;
    }

    public synchronized void add(Car car) throws SimilarSerialNumberException {
        try {
            if (carsOnShip.size() == size) {
                wait();
            }
            if (!carsOnShip.contains(car)) {
                System.out.println("Ship load a car: " + car + "\n");
                writer.append("Ship load a car: " + car + "\n");
                carsOnShip.add(car);
                notifyAll();
            } else {
                throw new SimilarSerialNumberException("Error: Same carSN already on the Ship", car);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void remove() {
        try {
            if (carsOnShip.size() < size) {
                wait();
            }
            System.out.println("Ship remove all the cars\n");
            writer.append("Ship remove all the cars\n");
            carsOnShip.clear();
            notifyAll();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
