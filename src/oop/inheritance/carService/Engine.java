package oop.inheritance.carService;

public abstract class Engine {
    private final double volume;
    private final int power;
    private final int maxTurnovers;
    private int currentTurnovers = 0;


    public Engine(double volume, int power, int maxTurnovers) {
        this.power = power;
        this.volume = volume;
        this.maxTurnovers = maxTurnovers;
    }

    public void info() {
        System.out.println(this);
    }

    public String toString() {
        return "\n" + getClass().getSimpleName() + "\nvolume = " + volume + "\npower = " + power + "\nmax turnovers = " + maxTurnovers;
    }

    public void start() {
        System.out.println("Engine : " + getClass().getSimpleName() + " is starting ");
        currentTurnovers = 1700;
    }

    public void stop() {
        System.out.println("Engine : " + getClass().getSimpleName() + " is stopped ");
        currentTurnovers = 0;
    }

    public void addTurnovers(int value) {
        if (currentTurnovers == 0) {
            System.out.println(" Engine must work ");
            return;
        }
        if (currentTurnovers + value <= maxTurnovers) {
            currentTurnovers = currentTurnovers + value;
        } else currentTurnovers = maxTurnovers;
    }

    public int getCurrentTurnovers() {
        return currentTurnovers;
    }


}
