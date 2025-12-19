package oop.multiTreading.carsFactory;

public class SimilarSerialNumberException extends Exception {
    private Car car;


    public SimilarSerialNumberException(String message, Car car) {
        super(message);
        this.car = car;
//        System.out.println("Car with SN goes to Truck: " + car.getCarSn()+"\n");
    }

    public Car getCar() {
        return car;
    }
}
