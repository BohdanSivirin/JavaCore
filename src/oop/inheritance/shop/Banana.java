package oop.inheritance.shop;

public final class Banana extends Food {

    public Banana(double price, double protein, double fat, double calories) {
        super("banana",price, protein, fat, calories, Unit.UNIT);

    }
}
