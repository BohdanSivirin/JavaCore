package oop.inheritance.basic;

public abstract class Mamal extends Animal {
    private boolean isWarmBlooded;

    public Mamal(double weight, int age, int sleepingTime) {
        super(weight, age, sleepingTime);
        this.isWarmBlooded = true;
    }

    public void info() {
        super.info();
        System.out.println(" Mamal is Warm-Blooded : " + isWarmBlooded);
    }
}
