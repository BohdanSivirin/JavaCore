package oop.inheritance.сoffeeMachine;

public abstract class Ingredient {
    private final String title;
    private final int weight;
    private final double price;

    public Ingredient(String title, int weight, double price) {
        this.price = price;
        this.weight = weight;
        this.title = title;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " =  weight: " + weight + " gr. | " + " price: " + price + " $. | ";
    }


    @Override
    public int hashCode() {
        int hashCode = 7;
        hashCode = 7 * hashCode + getClass().getSimpleName().hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        return object.getClass() != this.getClass();
    }


    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int getWeight() {
        return weight;
    }
}
