package oop.interfaces.sort.gameClans;

import java.util.Random;

public class Goblin extends Personage implements Attacker {


    public Goblin(String name, int health) {
        super(name, health);
    }

    @Override
    public boolean isHero() {
        return false;
    }

    @Override
    public void attack(Personage p) {
        int random = new Random().nextInt(71);
        p.receiveDamage(random);
        System.out.println(getClass().getSimpleName()
                           + " Weapon: physical "
                           + " Damage: " + random);
    }
    @Override
    public Personage clone() {
        return new Goblin(this.name, this.health);
    }
}
