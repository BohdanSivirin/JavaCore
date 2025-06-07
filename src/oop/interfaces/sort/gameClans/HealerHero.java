package oop.interfaces.sort.gameClans;

import java.util.Random;

public class HealerHero extends Personage implements Healer {

    public HealerHero(String name, int health) {
        super(name, health);
    }

    @Override
    public boolean isHero() {
        return true;
    }

    @Override
    public void heal(Personage p) {
        int random = new Random().nextInt(131);
        p.receiveHeal(random);
        System.out.println(getClass().getSimpleName() + " life is replenished. Amount: " + random);
    }

    @Override
    public Personage clone() {
        return new HealerHero(this.name, this.health);
    }
}
