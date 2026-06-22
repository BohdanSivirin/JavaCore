package oop.inheritance.basic;

public abstract class Grasshopper extends Insect {
    private boolean isHasEars;
    private int legs;


    public Grasshopper(boolean isHasEars, int legs) {
        super(0.7, 1, 0, false, false);
        this.legs = legs;
        this.isHasEars = isHasEars;
    }

    public boolean isHasEars() {
        return isHasEars;
    }

    public int getLegs() {
        return legs;
    }

    public void info() {
        super.info();
        System.out.println(" Grasshopper has ears : " + isHasEars);
        System.out.println(" Grasshopper amount legs : " + legs);

    }

    public final void jump(int distance) {
        System.out.println(" Grasshopper jump on distance : " + distance);
    }
}
