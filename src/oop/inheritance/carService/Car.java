package oop.inheritance.carService;

public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }


    public void engineInfo() {
        engine.info();
    }

    public void info() {
        System.out.println("Current turnovers are : " + engine.getCurrentTurnovers());
    }

    public void start() {
        System.out.println("Car is going to start ");
        engine.start();
        info();
    }

    public void stop() {
        System.out.println("Car is going to stop ");
        engine.stop();
        info();
    }

    public void accelerate(int value) {
        engine.addTurnovers(value);
        info();
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }
}
