package oop.inheritance.shop;

public final class Nut extends Food{

    public Nut(double price, double protein, double fat, double calories) {
        super("nut",price, protein, fat, calories, Unit.PACKAGE);
    }
}
