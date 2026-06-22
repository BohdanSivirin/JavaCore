package oop.interfaces.basic;

import java.util.ArrayList;

public class Gym {

    private final ArrayList<Sportsman> gymTeam = new ArrayList<>();

    public void addSportsman(Sportsman sportsman) {
        gymTeam.add(sportsman);
        System.out.println(" Sportsman added to band ");
    }

    public void doSport() {
        for (int i = 0; i < gymTeam.size(); i++) {
            gymTeam.get(i).train();
        }
    }

}
