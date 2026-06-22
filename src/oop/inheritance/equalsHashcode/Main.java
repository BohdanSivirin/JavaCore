package oop.inheritance.equalsHashcode;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Gearbox gearbox = new Gearbox("auto", 6);
        Engine engine = new Engine(200, 2.5, "hybrid");

        Gearbox gearbox2 = new Gearbox("auto", 6);
        Engine engine2 = new Engine(200, 2.5, "hybrid");

        Gearbox gearbox1 = new Gearbox("manual", 8);
        Engine engine1 = new Engine(350, 4.7, "Diesel");

        Car car = new Car("Audi", "Q8", 2025, 3500.50, engine, gearbox);
        Car car1 = new Car("Audi", "Q8", 2025, 3500.50, engine2, gearbox2);
        Car car3 = new Car("BMW", "X5", 2022, 2500.50, engine1, gearbox1);

        ArrayList<Car> cars = new ArrayList<>();
        Collections.addAll(cars, car1, car3);
        //cars.contains(car);
        System.out.println("isExist car " + cars.contains(car));
        cars.indexOf(car);
        System.out.println("indexOf car " + cars.indexOf(car));
        boolean carDelete = cars.remove(car);
        System.out.println("carDelete " + carDelete);
//        System.out.println(car);
//        System.out.println("***");
//        System.out.println(car1);
        ArrayList<Date> dates = new ArrayList<>();
        Date date = new Date(2025, 2, 7);
        dates.add(date);
        Date date1 = new Date(2025, 2, 7);
        System.out.println(" isContains date1 " + dates.contains(date1));
        HashMap<Car, Double> priceCar = new HashMap<>();
        priceCar.put(car, 12550.12);
        priceCar.put(car1, 10900.50);
        priceCar.put(car3, 8000.01);
        int size = priceCar.size();
        System.out.println("size map " + size);
        HashMap<Date, Integer> datesMap = new HashMap<Date, Integer>();
        datesMap.put(date, 1);
        datesMap.put(date1, 2);
        size = datesMap.size();
        System.out.println("dates size " + size);
        int dataCode = date.hashCode();
        int data1Code = date1.hashCode();
        int carCode = car.hashCode();
        int car1Code = car1.hashCode();
        System.out.println("dataCode " + dataCode);
        System.out.println("data1Code " + data1Code);
        System.out.println("carCode " + carCode);
        System.out.println("car1Code " + car1Code);
    }


}
