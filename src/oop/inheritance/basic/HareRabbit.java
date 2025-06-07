package oop.inheritance.basic;

public final class HareRabbit extends Mamal {
    private int earSize;

    public HareRabbit(double weight, int age, int sleepingTime, int earSize) {
        super(weight, age, sleepingTime);
        this.earSize = earSize;
    }

    public void jump() {
        System.out.println(" Hare rabbit is jumping ");
    }

    public void info() {
        super.info();
        System.out.println(" Hare rabbit ear Size : " + earSize);
    }
    public void voice(){
        System.out.println(" Hare rabbit chiving ");
    }
}
