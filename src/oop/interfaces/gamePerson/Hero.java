package oop.interfaces.gamePerson;

import java.util.ArrayList;
import java.util.Random;

public class Hero {
    private final String name;
    private final String race;
    private final int lives;
    private int currentlives;
    private ArrayList<Weapon> weapons;
    private Weapon mainWeapon;
    private final String armor;
    private ArrayList<String> things;

    public Hero(String name, String race, int lives, ArrayList<Weapon> weapons, String armor, ArrayList<String> things) {
        this.name = name;
        this.race = race;
        this.lives = lives;
        this.currentlives = lives;
        this.weapons = weapons;
        this.armor = armor;
        this.things = things;
    }

    public Hero(Hero hero) {
        weapons = new ArrayList<>();
        for (int i = 0; i < hero.weapons.size(); i++) {
            weapons.add(new Weapon(hero.weapons.get(i)));
        }
        things = new ArrayList<>();
        for (int i = 0; i < hero.things.size(); i++) {
            things.add(hero.things.get(i));
        }
        this.name = hero.name;
        this.race = hero.race;
        this.lives = hero.lives;
        this.currentlives = lives;
        this.armor = hero.armor;
        this.mainWeapon = hero.mainWeapon;
    }
    public void healing(int value) {
        if (currentlives + value <= lives) {
            currentlives = currentlives + value;
            System.out.println("lives is increasing. Total: " + currentlives);
        } else System.out.println("Incorrect value");
    }
    public void wounding(int value) {
        if (currentlives - value > 0) {
            currentlives = currentlives - value;
            System.out.println("lives is decreasing. Total: " + currentlives);
        } else System.out.println("Incorrect value");
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public void addThing(String thing) {
        things.add(thing);
    }

    public void setMainWeapon() {
        int r = new Random().nextInt(weapons.size());
        mainWeapon = weapons.get(r);
        System.out.println("Main weapon: " + weapons.get(r).getTitle());
    }

    @Override
    public String toString() {
        return "\nname = " + name
               + ",\nrace = " + race
               + ",\nlives = " + lives
               + ",\nweapons = " + weapons
               + ",\nmainHandWeapon = " + mainWeapon
               + ",\narmor = " + armor
               + ",\nthings=" + things
               + super.toString();
    }
}
