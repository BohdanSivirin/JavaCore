package oop.interfaces.sort.gameClans;

public class Weapon implements Cloneable {
    private final String title;
    private final int damage;


    public Weapon(String title, int damage) {
        this.title = title;
        this.damage = damage;
    }

    @Override
    public Weapon clone() {
        return new Weapon(this.title, this.damage);
    }

    public String getTitle() {
        return title;
    }

    public int getDamage() {
        return damage;
    }

    public String toString() {
        return "\ntitle: " + title + ", damage: " + damage;
    }
}
