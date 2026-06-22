package oop.multiTreading.carsFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Parking {
    private final String name;
    private final int size = 11;
    private ArrayList<Car> cars = new ArrayList<>();
    private final BufferedWriter writer;

    public Parking(String name, BufferedWriter writer) {
        this.name = name;
        this.writer = writer;
    }

    public void add(Car car) {
        try {
            System.out.println("Parking: [" + name + "] park a car: " + car + "\n");
            writer.append("Parking: [" + name + "] park a car: " + car + "\n");
            cars.add(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Car> getCarsFromParking(int amountOfCars) {
        ArrayList<Car> toTruck = new ArrayList<>();
        try {
            if (amountOfCars >= cars.size()) {
                toTruck.addAll(cars);
                cars = new ArrayList<>();
            } else {
                for (int i = 0; i < amountOfCars; i++) {
                    toTruck.add(cars.get(i));
                }
                cars.subList(0, amountOfCars).clear();
            }
            for (Car car : toTruck) {
                System.out.println("Parking: [" + name + "] send car to Truck: " + car + "\n");
                writer.append("Parking: [" + name + "] send car to Truck: " + car + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toTruck;
    }

    public boolean isFull() {
        return cars.size() == size;
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    public String getName() {
        return name;
    }
}
