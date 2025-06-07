package oop.inheritance.basic;

public final class GrasshopperChild extends Grasshopper {

    public GrasshopperChild(boolean isHasEars, int legs) {
        super(isHasEars, legs);
    }

    public void eatGrass() {
        System.out.println(" Grasshopper eating grass ");
    }

    @Override
    public void voice() {
        System.out.println(" Grasshopper is chewing ");
    }

//    public void jump(int distance) {
//
//    }
}
