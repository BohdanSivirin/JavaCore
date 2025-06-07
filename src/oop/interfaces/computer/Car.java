package oop.interfaces.computer;

public class Car implements Usb {
    private String name;
    private int year;
    private String engine;
    private int vinCode;

    public Car(String name, int year, String engine, int vinCode) {
        this.name = name;
        this.year = year;
        this.engine = engine;
        this.vinCode = vinCode;
    }

    @Override
    public String getData() {
        return getClass().getSimpleName() + " name: " + name + " year: " + year + " engine type: " + engine + " vin code: " + vinCode;
    }
}
