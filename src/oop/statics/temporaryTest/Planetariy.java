package oop.statics.temporaryTest;

import java.util.ArrayList;
import java.util.Collections;


public class Planetariy {
    private static final ArrayList<String> planets = getPlanets();

//    static {
//        Collections.addAll(planets, "Mercury", "Venera", "Earth", "Mars", "Jupiter", "Saturn", "Neptun", "Pluton");
//    }

    static ArrayList<String> getPlanets() {
        ArrayList<String> planets = new ArrayList<>();
        Collections.addAll(planets, "Mercury", "Venera", "Earth", "Mars", "Jupiter", "Saturn", "Neptun", "Pluton");
        return planets;
    }

    void info() {
        System.out.println(" List planet : " + planets);
    }

}
