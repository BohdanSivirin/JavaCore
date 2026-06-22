package oop.inheritance.basic;

public abstract class Insect extends Animal {
    private boolean isHarm;
    private boolean isPoison;

    public Insect(double weight, int age, int sleepingTime, boolean isHarm, boolean isPoison) {
        super(weight, age, sleepingTime);
        this.isPoison = isPoison;
        this.isHarm = isHarm;
    }

    public boolean isHarm() {
        return isHarm;
    }

    public boolean isPoison() {
        return isPoison;
    }

    public void info() {
        super.info();
        System.out.println(" Insect is harm : " + isHarm);
        System.out.println(" Insect is poison : " + isPoison);
    }

}
