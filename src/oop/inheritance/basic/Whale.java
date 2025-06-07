package oop.inheritance.basic;

public abstract class Whale extends Mamal {
    private boolean isCanDividedIntoGroup;
    private boolean isSmart;

    public Whale(double weight, int age, int sleepingTime, boolean isSmart, boolean isCanDividedIntoGroup) {
        super(weight, age, sleepingTime);
        this.isCanDividedIntoGroup = isCanDividedIntoGroup;
        this.isSmart = isSmart;

    }

    public boolean isCanDividedIntoGroup() {
        return isCanDividedIntoGroup;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void info() {
        super.info();
        System.out.println(" Whale isSmart : " + isSmart);
        System.out.println(" Whale isCanDividedIntoGroup : " + isCanDividedIntoGroup);
    }
}
