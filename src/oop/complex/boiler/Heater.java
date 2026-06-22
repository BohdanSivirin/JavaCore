package oop.complex.boiler;


public class Heater {
    private Water water;

    public Heater(Water water) {
        this.water = water;
    }

    public void heat(double value) {
        water.increaseTemp(value);
    }
}
