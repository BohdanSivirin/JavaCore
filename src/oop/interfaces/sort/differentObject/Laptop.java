package oop.interfaces.sort.differentObject;

public class Laptop implements Things {
    private String brand;
    private String model;
    private int weight;
    private int height;
    private int price;
    private int width;
    private int screenSize;

    public Laptop(String brand, String model, int weight, int height, int price, int width, int screenSize) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.height = height;
        this.price = price;
        this.width = width;
        this.screenSize = screenSize;
    }

    @Override
    public int compareTo(Things t) {
        return weight - t.getWeight();
    }

    @Override
    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "\ntype: " + getClass().getSimpleName() + ", weight: " + weight;
    }
}
