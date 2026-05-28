package oop.generics.newGenerics;

public abstract class Animal {
    private int age;

    public Animal(int age) {
        this.age = age;
    }

    abstract void voice();

    public String toString() {
        return getClass().getSimpleName() + ", age: " + age + "\n";
    }

    public int getAge() {
        return age;
    }
}
