package oop.generics.newGenerics;

public class Cat extends Animal {
    private boolean isTebby;

    public Cat(boolean isTebby) {
        super(6);
        this.isTebby = isTebby;

    }

    @Override
    public void voice() {
        System.out.println("Cats voice");
    }

    public boolean getIsTebby() {
        return isTebby;
    }
}
