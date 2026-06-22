package oop.multiTreading.carsFactory;


import java.util.Random;

public class Car {
    private final String brand;
    private final int carSn;

    public Car(String brand) {
        this.brand = brand;
        this.carSn = new Random().nextInt(0, 30);
    }

    public String getBrand() {
        return brand;
    }

    public int getCarSn() {
        return carSn;
    }

    public String toString() {
        return "[ Brand: " + brand + " SN: " + carSn + " ] ";
    }
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
        return car.carSn == carSn;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 17 * hashCode + Long.hashCode(carSn);
        return hashCode;
    }


}
