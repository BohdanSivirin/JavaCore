package oop.interfaces.parking;

public abstract class Car {
    private final String companyName;
    private final String model;
    private final String engineType;
    private final int speed;
    private final int ph;

    public Car(String companyName, String model, String engineType, int speed, int ph) {
        this.companyName = companyName;
        this.model = model;
        this.engineType = engineType;
        this.speed = speed;
        this.ph = ph;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "\n"
               + engineType + " " + ph + "\n"
               + speed + " speed ";
    }

}
