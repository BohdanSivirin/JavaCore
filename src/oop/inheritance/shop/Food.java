package oop.inheritance.shop;

enum Unit {
    PACKAGE, KILOGRAM, UNIT
}

public abstract class Food extends Product {
    public Unit unitName;
    private final double protein;
    private final double fat;
    private final double calories;

    public Food(String name, double price, double protein, double fat, double calories, Unit unitName) {
        super(name, price);
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.unitName = unitName;
    }

    public void info() {
        System.out.println(this);
    }

    public String toString() {
        return " <- " + getClass().getSimpleName()+ " ->\n " +
                super.toString() +
                "\nunit name: " + unitName +
                "\nprotein: " + protein +
                "\nfat: " + fat +
                "\ncalories: " + calories;
    }

}
