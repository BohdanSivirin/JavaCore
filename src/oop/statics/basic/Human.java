package oop.statics.basic;

import java.util.ArrayList;

//enum EyeColour {
//    BLUE, GREEN, BROWN, KARRY, BLACK
//}

public class Human {
    private String name;
    private EyeColour humanEye;
    private static int population;
    private double weight;
    public static final int NEGROID_RACE = 1;
    public static final int EVROPEOID_RACE = 2;
    public static final int ASIAN_RACE = 3;
    private int humanRace;
    public static final Sun sun = new Sun();

    public Human(String name, double weight, int humanRace, EyeColour humanEye) {
        this.name = name;
        this.population++;
        this.weight = weight;
        this.humanRace = humanRace;
        this.humanEye = humanEye;
    }

    void takeSun() {
        sun.shine();
        System.out.println(name + " take a sun ");
    }


    public void info() {
        System.out.println(" name " + name + " weight " + weight + " race " + humanRace + " human eye colour " + humanEye);

    }

    public String getName() {
        return name;
    }

    public static int getPopulation() {
        return population;
    }

    static void staticMethod() {
        //System.out.println( " name " + name);
        //getName();
        System.out.println(population);
    }

    static Human getHaviest(ArrayList<Human> people) {
        Human haviest = people.get(0);
        for (int i = 1; i < people.size(); i++) {
            if (people.get(i).weight > haviest.weight) {
                haviest = people.get(i);
            }
        }
        return haviest;
    }
}
