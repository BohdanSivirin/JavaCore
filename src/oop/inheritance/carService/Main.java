package oop.inheritance.carService;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();
        Car car = new Car(new DieselEngine(1.7, 125, 5500));
        Car car1 = new Car(new BenzinEngine(4.4, 330, 8000));
        Car car2 = new Car(new HybridEngine(1.2, 190, 6300));
        Car car3 = new Car(new DieselEngine(3.0, 210, 5800));
        Car car4 = new Car(new BenzinEngine(1.8, 150, 6800));
        Engine engine = car.getEngine();
        Engine engine1 = car1.getEngine();
        Engine engine2 = car2.getEngine();
        Engine engine3 = car3.getEngine();
        Engine engine4 = car4.getEngine();
        carService.addEngineToList(engine);
        carService.addEngineToList(engine1);
        carService.addEngineToList(engine2);
        carService.addEngineToList(engine3);
        carService.addEngineToList(engine4);
        car4.start();
        car4.stop();
        car4.accelerate(40000);



        car1.engineInfo();
              carService.changeEngine(car1);
        car1.engineInfo();
        System.out.println("* * * * * *");
        car3.engineInfo();
        carService.changeEngine(car3);
        car3.engineInfo();


    }
}
