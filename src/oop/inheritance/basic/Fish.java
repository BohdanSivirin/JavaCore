package oop.inheritance.basic;

public abstract class Fish extends Animal {
    private boolean isCanSeeColour;
    private boolean isHasTeeth;

    public Fish(double weight, int age, int sleepingTime, boolean isCanSeeColour, boolean isHasTeeth) {
        super(weight, age, sleepingTime);
        this.isCanSeeColour = isCanSeeColour;
        this.isHasTeeth = isHasTeeth;
    }

    public boolean isCanSeeColour() {
        return isCanSeeColour;
    }

    public boolean isHasTeeth() {
        return isHasTeeth;
    }

    public void info() {
        super.info();
        System.out.println(" Fish has Teeth : " + isHasTeeth);
        System.out.println(" Fish can See Colour : " + isCanSeeColour);
    }

    public String toString() {
        return super.toString() + " teeth " + isHasTeeth + " colour " + isCanSeeColour;
    }

    @Override
    public void voice(){
        System.out.println(" Fish doesn't make sound ");
    }
}
