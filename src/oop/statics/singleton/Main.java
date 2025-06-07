package oop.statics.singleton;

import java.util.AbstractCollection;

public class Main {
    public static void main(String[] args) {
        Sun sun = Sun.getInstance();
        System.out.println(sun);
        Sun sun1 = Sun.getInstance();
        System.out.println(sun1);
        // Sun sun2 = new Sun();
        Earth earth = Earth.EARTH;
        int value2 = earth.changeSize(745);
        System.out.println(value2);

        Accounter accounter = Accounter.createAccounter("Vasya");
        System.out.println(accounter);
        Accounter accounter1 = Accounter.createAccounter("Vasya");
        System.out.println(accounter1);
        Accounter accounter2 = Accounter.createAccounter("Viktor");
        Accounter accounter3 = Accounter.createAccounter("Petya");
        System.out.println(accounter3);
    }
}
