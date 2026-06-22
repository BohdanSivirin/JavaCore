package oop.inheritance.basic;

public abstract class Wolf extends Mamal {
    private boolean isPredator;
    private boolean isFluffy;

    public Wolf(double weight, int age, int sleepingTime, boolean isPredator, boolean isFluffy) {
        super(weight, age, sleepingTime);
        this.isFluffy = isFluffy;
        this.isPredator = isPredator;
    }

    public void info() {
        super.info();
        System.out.println(" Wolf is predator : " + isPredator);
        System.out.println(" Wolf is Fluffy : " + isFluffy);
    }
}
