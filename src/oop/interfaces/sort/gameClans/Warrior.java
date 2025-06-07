package oop.interfaces.sort.gameClans;


import java.util.ArrayList;
import java.util.Random;

public class Warrior extends Personage implements Attacker {
    private final ArrayList<Weapon> weapons;

    public Warrior(String name, int health, ArrayList<Weapon> weapons) {
        super(name, health);
        this.weapons = weapons;
    }


    @Override
    public boolean isHero() {
        return true;
    }

    @Override
    public void attack(Personage p) {
        if (weapons.isEmpty()) {
            p.receiveDamage(5);
            System.out.println(getClass().getSimpleName() + " Weapon: hand, Damage: 5");
            return;
        }
        Weapon randomWeapon = weapons.get(new Random().nextInt(weapons.size()));
        p.receiveDamage(randomWeapon.getDamage());
        System.out.println(getClass().getSimpleName()
                           + " Weapon: " + randomWeapon.getTitle()
                           + " Damage: " + randomWeapon.getDamage());
    }

    @Override
    public Personage clone() {
        return new Warrior(this.name, this.health, this.weapons);
    }
}
