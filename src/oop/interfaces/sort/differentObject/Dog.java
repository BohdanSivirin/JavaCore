package oop.interfaces.sort.differentObject;

public class Dog implements Things {
    private String name;
    private String breed;
    private int weight;
    private int height;
    private boolean isDomestic;

    public Dog(String name, String breed, int weight, int height, boolean isDomestic) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.height = height;
        this.isDomestic = isDomestic;
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
