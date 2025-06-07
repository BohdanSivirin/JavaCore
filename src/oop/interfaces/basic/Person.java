package oop.interfaces.basic;

import java.util.Random;

public class Person extends Human {
    private final int id;

    public Person(int age, String name) {
        super(age, name);
        this.id = new Random().nextInt(10000);
    }

    public void vote() {
        System.out.println("Person: " + name + " is vote");
    }


}
