package oop.multiTreading.store;


public class Product {
    private final String brand;
    private final String type;
    private final double price;
    private final long serial;

    public Product(String brand, String type, double price, long serialNumber) {
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.serial = serialNumber;
    }

    public String toString() {
        return " [ Title: " + brand + ", Brand: " + type + ", Serial: ] " + serial;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
