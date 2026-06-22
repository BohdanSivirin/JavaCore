package oop.interfaces.sort.differentObject;

public class Table implements Things{
    private String brand;
    private int weight;
    private int height;
    private int price;
    private String material;

    public Table(String brand, int weight, int height, int price, String material) {
        this.brand = brand;
        this.weight = weight;
        this.height = height;
        this.price = price;
        this.material = material;
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
