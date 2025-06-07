package oop.inheritance.equalsHashcode;

public class Car {
    private String brand;
    private String model;
    private int year;
    private double weight;
    private Engine engine;
    private Gearbox gearbox;

    public Car(String brand, String model, int year, double weight, Engine engine, Gearbox gearbox) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.weight = weight;
        this.engine = engine;
        this.gearbox = gearbox;
    }

    public String toString() {
        return "Brand: " + brand + "\nModel: " + model + "\nYear: " + year + "\nWeight: " + weight + "\nEngine: " + engine + "\nGearbox: " + gearbox;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Car car)) {
            return false;
        }
        return car.gearbox.equals(gearbox) &&
                car.brand.equals(brand) &&
                car.model.equals(model) &&
                car.year == year &&
                car.weight == weight &&
                car.engine.equals(engine);
    }

    @Override
    public int hashCode() {
        int hashCode = 7;
        hashCode = 7 * hashCode + gearbox.hashCode();
        hashCode = 7 * hashCode + brand.hashCode();
        hashCode = 7 * hashCode + model.hashCode();
        hashCode = 7 * hashCode + engine.hashCode();
        hashCode = 7 * hashCode + Double.hashCode(weight);
        hashCode = 7 * hashCode + Integer.hashCode(year);
        return hashCode;
    }
}
