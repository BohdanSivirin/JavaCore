package oop.interfaces.gamePerson;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Weapon axe = new Weapon("Axe", 2235.45, true);
        Weapon heavySword = new Weapon("HeavySword", 1800.50, true);
        Weapon claw = new Weapon("Claw", 1912.33, false);
        Weapon javelin = new Weapon("HyperionJavelin", 2732.25, true);
        ArrayList<Weapon> weapons = new ArrayList<>();
        ArrayList<String> staff = new ArrayList<>();
        Collections.addAll(staff, "Charm", "Jewel", "Orb", "Wand", "Amulet", "Ring");
        Collections.addAll(weapons, axe, heavySword, claw, javelin);

        Hero hero = new Hero("Rob", "barbarian", 3000, weapons, "MagePlate", staff);
        hero.setMainWeapon();
        hero.wounding(780);
        hero.wounding(200);
        hero.healing(9);
        hero.healing(13);

        hero.addWeapon(new Weapon("Malice", 2589.25, false));
        hero.addThing("Shoes");
        System.out.println(hero);
        Hero hero1 = new Hero(hero);
        System.out.println("* * * * * ");
        System.out.println(hero1);
        System.out.println("/////////////");

        hero1.addWeapon(new Weapon("OrbTal", 788.45,true));
        hero1.addThing("Shako");
        javelin.destroyWeapon();
        System.out.println(hero);
        System.out.println("* * * * * ");
        System.out.println(hero1);


    }
}
