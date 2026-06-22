package oop.inheritance.basic;

public abstract class Animal {
    private double weight;
    private int age;
    private int sleepingTime;

    public Animal(double weight, int age, int sleepingTime) {
        this.weight = weight;
        this.age = age;
        this.sleepingTime = sleepingTime;
    }

    void info() {
//        System.out.println(" animal weight : " + weight);
//        System.out.println(" animal age : " + age);
//        System.out.println(" animal sleepingTime : " + sleepingTime);
        System.out.println(this);
    }

    public abstract void voice();

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public int getSleepingTime() {
        return sleepingTime;
    }

    public void setWeight(int value) {
        weight = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " weight " + weight + " age " + age + " sleepingTime " + sleepingTime;
    }

    public void eat() {
        System.out.println(" animal " + getClass().getSimpleName() + " is eating ");
    }
}

