package oop.inheritance.basic;

public abstract class Caterpillar extends Insect {
    private int durationTransform;
    private int deadTemperatura;

    public Caterpillar(boolean isPoison, int durationTransform, int deadTemperatura) {
        super(0.5, 1, 0, true, isPoison);
        this.deadTemperatura = deadTemperatura;
        this.durationTransform = durationTransform;
    }

    public int getDurationTransform() {
        return durationTransform;
    }

    public int getDeadTemperatura() {
        return deadTemperatura;
    }

    public void info() {
        super.info();
        System.out.println(" Caterpillar duration Transform : " + durationTransform);
        System.out.println(" Caterpillar dead Temperatura : " + deadTemperatura);
    }
}
