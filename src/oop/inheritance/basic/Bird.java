package oop.inheritance.basic;

public abstract class Bird extends Animal {
    private boolean isCanFly;
    private boolean isCanSwim;


    public Bird(double weight, int age, int sleepingTime, boolean isCanFly, boolean isCanSwim) {
        super(weight, age, sleepingTime);
        this.isCanFly = isCanFly;
        this.isCanSwim = isCanSwim;

    }

    public boolean isCanFly() {
        return isCanFly;
    }

    public boolean isCanSwim() {
        return isCanSwim;
    }

    public void info() {
        super.info();
        System.out.println(" Bird can fly " + isCanFly);
        System.out.println(" Bird can swim " + isCanSwim);
    }
}
