package oop.multiTreading.carsFactoryWaitNotify;

import oop.multiTreading.carsFactory.Car;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parking {
    private final String name;
    private final int size = 11;
    private List<Car> cars = Collections.synchronizedList(new ArrayList<>());
    private final BufferedWriter writer;

    public Parking(String name, BufferedWriter writer) {
        this.name = name;
        this.writer = writer;
    }

    public synchronized void add(Car car) {
        try {
            if (cars.size() == size) {
                wait();
            }
            System.out.println("Parking: [" + name + "] park a car: " + car + "\n");
            writer.append("Parking: [" + name + "] park a car: " + car + "\n");
            cars.add(car);
            notifyAll();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Car> getCars(int amountOfCars) {
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

    public String getName() {
        return name;
    }

}
