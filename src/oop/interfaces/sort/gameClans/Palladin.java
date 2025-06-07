package oop.interfaces.sort.gameClans;

import java.util.Random;

public class Palladin extends Personage implements BattleMagician {


    public Palladin(String name, int health) {
        super(name, health);
    }

    @Override
    public boolean isHero() {
        return true;
    }

    @Override
    public void castSpell(Personage p) {
//        int randomAttack = new Random().nextInt(100);
//        if (randomAttack % 2 == 0) {
        int random = new Random().nextInt(131);
        p.receiveDamage(random);
        System.out.println(getClass().getSimpleName()
                           + " Weapon: magic "
                           + " Damage: " + random);
//        else attack(p);
    }

    @Override
    public void attack(Personage p) {
        int randomAttack = new Random().nextInt(100);
        if (randomAttack % 2 != 0) {
            int random = new Random().nextInt(71);
            p.receiveDamage(random);
            System.out.println(getClass().getSimpleName()
                               + " Weapon: physical "
                               + " Damage: " + random);
        } else castSpell(p);
    }

    @Override
    public void heal(Personage p) {
        int random = new Random().nextInt(51);
        p.receiveHeal(random);
        System.out.println(getClass().getSimpleName() + " life is replenished -> " + p.name + " Amount: " + random);
    }

    @Override
    public Personage clone() {
        return new Palladin(this.name, this.health);
    }
}
