package oop.interfaces.gamePerson2;

public class Weapon2 {
    private final String title;
    private double damage;
    private boolean isWork;


    public Weapon2(String title, double damage, boolean isWork) {
        this.title = title;
        this.damage = damage;
        this.isWork = isWork;
    }

    @Override
    public Weapon2 clone() {
        return new Weapon2(this.title, this.damage, this.isWork);
    }
//    public Weapon2(oop.interfaces.gamePerson.Weapon weapon) {
//        this.title = weapon.title;
//        this.damage = weapon.damage;
//        this.isWork = weapon.isWork;
//    }

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
