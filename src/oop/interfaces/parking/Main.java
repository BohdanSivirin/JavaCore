package oop.interfaces.parking;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        Car audiQ8 = new AudiQ8();
        Car bmwX6 = new BmwX6();
        Car mercedesGl = new MercedesGl();
        Car tractor = new Tractor();
        Car ferrari = new Ferrari();
        Car jaguar = new Jaguar();
        Car lamdorgini = new Lamborgini();
        parking.addCar( audiQ8);
        parking.addCar(bmwX6);
        parking.addCar(mercedesGl);
        parking.addCar(tractor);
        parking.addCar(lamdorgini);
        parking.addCar( ferrari);
        parking.addCar(jaguar);
        System.out.println(parking);



    }
}
