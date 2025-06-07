package oop.inheritance.basic;

public final class CaterpillarChild extends Caterpillar {
    private int legsAmount;

    public CaterpillarChild(boolean isPoison, int durationTransform, int deadTemperatura, int legsAmount) {
        super(isPoison, durationTransform, deadTemperatura);
        this.legsAmount = legsAmount;
    }

    public void run() {
        System.out.println(" Caterpillar child is running ");
    }

    public void info() {
        super.info();
        System.out.println(" Caterpillar child legs amount : " + legsAmount);
    }

    @Override
    public void voice() {
        System.out.println(" Caterpillar child is shhhhhh ");
    }

    public void eat(String food) {
        System.out.println(" Caterpillar is eating " + food);
    }
}
