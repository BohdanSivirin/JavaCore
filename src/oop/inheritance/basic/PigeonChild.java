package oop.inheritance.basic;

public final class PigeonChild extends Pigeon {
    private String name;

    public PigeonChild(double weight, int age, int sleepingTime, boolean isCanFly, boolean isCanSwim, boolean isPredator, String name) {
        super(weight, age, sleepingTime, isCanFly, isCanSwim, isPredator);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void shout() {
        System.out.println(" Pigeon child is shouting ");
    }

    public void info() {
        super.info();
        System.out.println(" Pigeon child name : " + name);
    }

    public void voice(){
        System.out.println(" Pigeon child make some sound ");
    }
}
