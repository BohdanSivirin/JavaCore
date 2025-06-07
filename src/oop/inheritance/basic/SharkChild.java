package oop.inheritance.basic;


public final class SharkChild extends Shark {
    private String name;

    public SharkChild(double weight, int age, int sleepingTime, boolean isHasElectroreceptorOrgans, String name) {
        super(weight, age, sleepingTime, isHasElectroreceptorOrgans);
        this.name = name;
    }

    public void swim() {
        System.out.println(" Shark child is swimming ");
    }

    public String getName() {
        return name;
    }

    public void info() {
        super.info();
        System.out.println(" Shark child name : " + name);
    }

    public String toString() {
        return super.toString() + " Shark child name : " + name;
    }

}
