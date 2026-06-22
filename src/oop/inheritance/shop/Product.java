package oop.inheritance.shop;

public abstract class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "\nname: " + name + "\nprice: " + price + " $ ";
    }
}
