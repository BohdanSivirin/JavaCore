package oop.functionalProgramming;

public class Car {
    private String brand;
    private double volume;
    private int power;
    private String model;
    private int year;

    public Car(String brand, double volume, int power, String model, int year) {
        this.brand = brand;
        this.volume = volume;
        this.power = power;
        this.model = model;
        this.year = year;
    }

    public String toString() {
        return "brand: " + brand + " volume: " + volume + " model: " + model + " year: " + year;

    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public double getVolume() {
        return volume;
    }
}
