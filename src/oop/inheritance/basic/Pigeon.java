package oop.inheritance.basic;

public abstract class Pigeon extends Bird {
    private boolean isDomestic;

    public Pigeon(double weight, int age, int sleepingTime, boolean isCanFly, boolean isCanSwim, boolean isPredator) {
        super(weight, age, sleepingTime, isCanFly, isCanSwim);
        this.isDomestic = isPredator;
    }

    public boolean isDomestic() {
        return isDomestic;
    }

    public void info() {
        super.info();
        System.out.println(" Pigeon is domestic : " + isDomestic);
    }
}
