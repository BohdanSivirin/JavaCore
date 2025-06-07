package oop.interfaces.gamePerson2;

import java.util.ArrayList;
import java.util.Random;

public class Hero2 implements Cloneable {
    private final String name;
    private final String race;
    private final int lives;
    private int currentlives;
    private ArrayList<Weapon2> weapons2;
    private Weapon2 mainWeapon;
    private final String armor;
    private ArrayList<String> things2;

    public Hero2(String name, String race, int lives, ArrayList<Weapon2> weapons2, String armor, ArrayList<String> things2) {
        this.name = name;
        this.race = race;
        this.lives = lives;
        this.currentlives = lives;
        this.weapons2 = weapons2;
        this.armor = armor;
        this.things2 = things2;
    }

    @Override
    public Hero2 clone() {
        ArrayList<Weapon2> weaponsClone = new ArrayList<>();
        for (int i = 0; i < weapons2.size(); i++) {
            weaponsClone.add(weapons2.get(i).clone());
        }
        ArrayList<String> thingsClone = new ArrayList<>();
        for (int i = 0; i < things2.size(); i++) {
            thingsClone.add(things2.get(i));
        }
        return new Hero2(this.name, this.race, this.lives, weaponsClone, this.armor, thingsClone);
    }

    //    public Hero2(oop.interfaces.gamePerson.Hero hero) {
//        weapons = new ArrayList<>();
//        for (int i = 0; i < hero.weapons.size(); i++) {
//            weapons.add(new oop.interfaces.gamePerson.Weapon(hero.weapons.get(i)));
//        }
//        things = new ArrayList<>();
//        for (int i = 0; i < hero.things.size(); i++) {
//            things.add(hero.things.get(i));
//        }
//        this.name = hero.name;
//        this.race = hero.race;
//        this.lives = hero.lives;
//        this.currentlives = lives;
//        this.armor = hero.armor;
//        this.mainWeapon = hero.mainWeapon;
//    }
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

    public void addWeapon(Weapon2 weapon2) {
        weapons2.add(weapon2);
    }

    public void addThing(String thing) {
        things2.add(thing);
    }

    public void setMainWeapon() {
        int r = new Random().nextInt(weapons2.size());
        mainWeapon = weapons2.get(r);
        System.out.println("Main weapon: " + weapons2.get(r).getTitle());
    }

    @Override
    public String toString() {
        return "\nname = " + name
               + ",\nrace = " + race
               + ",\nlives = " + lives
               + ",\nweapons = " + weapons2
               + ",\nmainHandWeapon = " + mainWeapon
               + ",\narmor = " + armor
               + ",\nthings=" + things2;
//               + super.toString();
    }
}
