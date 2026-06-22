package oop.interfaces.gamePerson;

public class Weapon {
    private final String title;
    private double damage;
    private boolean isWork;


    public Weapon(String title, double damage, boolean isWork) {
        this.title = title;
        this.damage = damage;
        this.isWork = isWork;
    }
    public Weapon(Weapon weapon) {
        this.title = weapon.title;
        this.damage = weapon.damage;
        this.isWork = weapon.isWork;
    }

    public void destroyWeapon() {
        isWork = false;
        System.out.println("Weapon is destroyed");
    }

    public void fixWeapon() {
        isWork = true;
        System.out.println("Weapon is fixed");
    }

    public void amplifyDamage() {
        damage = damage + 9999;
        System.out.println("Your damage improved dramatically: " + damage);
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "\ntitle: " + title + ", damage: " + damage + ", isWork: " + isWork;
    }
}
