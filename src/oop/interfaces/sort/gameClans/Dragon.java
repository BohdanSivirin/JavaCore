package oop.interfaces.sort.gameClans;

import java.util.Random;

public class Dragon extends Personage implements Attacker {


    public Dragon(String name, int health) {
        super(name, health);
    }

    @Override
    public boolean isHero() {
        return false;
    }

    @Override
    public void attack(Personage p) {
        int random = new Random().nextInt(301);
        p.receiveDamage(random);
        System.out.println(getClass().getSimpleName()
                           + " Weapon: fire, Damage: 301");
    }
    @Override
    public Personage clone() {
        return new Dragon(this.name, this.health);
    }
}
