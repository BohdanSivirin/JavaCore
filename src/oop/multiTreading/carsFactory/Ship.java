package oop.multiTreading.carsFactory;

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

    public boolean isFull() {
        return carsOnShip.size() == size;
    }

//    public boolean isEmpty() {
//        return carsOnShip.isEmpty();
//    }

    public void add(Car car) throws SimilarSerialNumberException {
        try {
            if (!carsOnShip.contains(car)) {
                System.out.println("Ship load a car: " + car + "\n");
                writer.append("Ship load a car: " + car + "\n");
                carsOnShip.add(car);
            } else {
                throw new SimilarSerialNumberException("Error: Same carSN already on the Ship", car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove() {
        carsOnShip.clear();
    }
}
