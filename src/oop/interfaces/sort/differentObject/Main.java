package oop.interfaces.sort.differentObject;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("sharik", "dvor-terier", 7, 36, true);
        Table table = new Table("OLX", 25, 178, 355, "wood");
        Laptop laptop = new Laptop("HP", "IQ7", 5, 3, 17589, 6, 17);
        ArrayList<Things> someThings = new ArrayList<>();
        Collections.addAll(someThings, dog, table, laptop);
        Collections.sort(someThings);
        System.out.println(someThings);
        Collections.reverse(someThings);
        System.out.println("someThings reverse");
        System.out.println(someThings);

    }
}
