package oop.inheritance.shop;

public final class Meat extends Food {

    public Meat(double price, double protein, double fat, double calories) {
        super("beef", price, protein, fat, calories, Unit.KILOGRAM);
    }


}
