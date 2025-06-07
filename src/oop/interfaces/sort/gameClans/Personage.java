package oop.interfaces.sort.gameClans;

public abstract class Personage implements Cloneable {
    protected final String name;
    protected int health;

    public Personage(String name, int health) {
        this.name = name;
        this.health = health;
    }

    @Override
    public String toString() {
        return "\nname = " + name + ", maxLives = " + health;
    }

    public void receiveDamage(int damage) {
        if (health - damage > 0) {
            health = health - damage;
        } else {
            health = 0;
            System.out.println("Personage is died");
        }
    }

    public void receiveHeal(int health) {
        this.health = this.health + health;
    }

    public abstract boolean isHero();

    @Override
    public abstract Personage clone();

    public boolean isAlive() {
        return health > 0;
    }
}
