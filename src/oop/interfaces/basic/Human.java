package oop.interfaces.basic;

public abstract class Human {
    protected final int age;
    protected final String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void eat() {
        System.out.println("Human eats");
    }

    public String toString(){
        return getClass().getSimpleName() + "name: " + name;
    }
}
