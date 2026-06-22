package oop.statics.enums;

enum Brand {
    BMW, MINI, LAND_ROVER
}

enum Colour {
    WHITE, BLACK, GREY, RED
}

public class Car {
    private final Brand brand;
    private final Colour colour;
    private Transmition transmition;
    private Engine engine;


    public Car(Brand brand, Colour colour, Transmition transmition, Engine engine) {
        this.brand = brand;
        this.colour = colour;
        this.transmition = transmition;
        this.engine = engine;
    }

    void info() {
        engine.info();
        transmition.info();
        System.out.println(" colour: " + colour);
    }


}
