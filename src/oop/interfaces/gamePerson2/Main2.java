package oop.interfaces.gamePerson2;


import java.util.ArrayList;
import java.util.Collections;

public class Main2 {
    public static void main(String[] args) {
        Weapon2 axe = new Weapon2("Axe", 2235.45, true);
        Weapon2 heavySword = new Weapon2("HeavySword", 1800.50, true);
        Weapon2 claw = new Weapon2("Claw", 1912.33, false);
        Weapon2 javelin = new Weapon2("HyperionJavelin", 2732.25, true);
        ArrayList<Weapon2> weapons = new ArrayList<>();
        ArrayList<String> staff = new ArrayList<>();
        Collections.addAll(staff, "Charm", "Jewel", "Orb", "Wand", "Amulet", "Ring");
        Collections.addAll(weapons, axe, heavySword, claw, javelin);

        Hero2 hero = new Hero2("Rob", "barbarian", 3000, weapons, "MagePlate", staff);
        hero.setMainWeapon();
        hero.wounding(780);
        hero.wounding(200);
        hero.healing(9);
        hero.healing(13);
        hero.addWeapon(new Weapon2("Malice", 2589.25, false));
        hero.addThing("Shoes");
//        System.out.println(hero);

        Hero2 hero2 = hero.clone();
        System.out.println("* * * * * ");
//        System.out.println(hero2);


        hero2.addWeapon(new Weapon2("OrbTal", 788.45,true));
        hero2.addThing("Shako");
        javelin.destroyWeapon();
        System.out.println("/////////////");
        System.out.println(hero);
        System.out.println("* * * * * ");
        System.out.println(hero2);


    }
}
