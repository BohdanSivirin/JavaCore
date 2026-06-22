package oop.interfaces.parking;

import java.util.ArrayList;

public class Parking {
    private final Dispatcher dispatcher;
    private final ArrayList<Ram> ramCars;
    private final ArrayList<Passenger> passengerCars;

    public Parking() {
        dispatcher = new Dispatcher();
        ramCars = new ArrayList<>();
        passengerCars = new ArrayList<>();
    }

    public void addCar(Car car) {
        dispatcher.addCar(car);
    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        t = t.append("[ Passengers ]\n");
        int i = 1;
        for (Passenger passenger : passengerCars) {
            t = t.append(i).append(") ").append(passenger).append(";\n");
            i++;
        }
        t = t.append("[ Rams ]\n");
        i = 1;
        for (Ram ram : ramCars) {
            t = t.append(i).append(") ").append(ram).append(";\n");
            i++;
        }
        return t.toString();
    }

    public class Dispatcher {
        private void addCar(Car car) {
            if (car instanceof Passenger) passengerCars.add((Passenger) car);
            if (car instanceof Ram) ramCars.add((Ram) car);
        }
    }

}
