package oop.inheritance.basic;

public class BlueWhale extends Whale {
    private final String type = " Blue Whale ";
    private String name;

    public BlueWhale(double weight, int age, int sleepingTime, boolean isSmart, boolean isCanDividedIntoGroup, String name) {
        super(weight, age, sleepingTime, isSmart, isCanDividedIntoGroup);
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void hitFish() {
        System.out.println(" blue whale hit fish ");
    }

    public void info() {
        super.info();
        System.out.println(" blue whale type : " + type);
        System.out.println(" blue whale name : " + name);
    }

    public void voice() {
        System.out.println(" Blue whale is signing ");
    }
}
