package oop.statics.basic;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println(Human.getPopulation());

        Human human1 = new Human("Vasya", 45.5, 54, EyeColour.BLUE);
        Human human2 = new Human("Kolya", 78.2, Human.EVROPEOID_RACE, EyeColour.BROWN);
        Human human3 = new Human("Petya", 125.55, Human.ASIAN_RACE, EyeColour.GREEN);
        human1.info();
        human2.info();
        human3.info();

        int currentValue = human3.getPopulation();
        currentValue = Human.getPopulation();
        currentValue = human2.getPopulation();
        System.out.println(currentValue);
        Math.pow(3.45, 1.25);
        ArrayList<Human> people = new ArrayList<>();
        Collections.addAll(people, human1, human2, human3);
        Human haviest = Human.getHaviest(people);
        System.out.println(haviest.getName());
        //Human.NEGROID_RACE = 6;
        System.out.println(Math.PI);
        human1.takeSun();
        Human.sun.shine();
//        Human.sun=new Sun();
        Human.sun.changeColour("Red");
        Human.sun.shine();
    }
}
