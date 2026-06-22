package oop.multiTreading.carsFactory;

import java.util.ArrayList;

public class Tresher {
    ArrayList<Car> destroy = new ArrayList<>();

    public void add(Car car) {
        destroy.add(car);
    }
}
