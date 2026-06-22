package oop.complex.tonometr;

public class Arm {
    private int upPressure;
    private int downPressure;
    private int pulse;

    public Arm(int upPressure, int downPressure, int pulse) {
        this.upPressure = upPressure;
        this.downPressure = downPressure;
        this.pulse = pulse;
    }

    public int getUpPressure() {
        return upPressure;
    }

    public int getDownPressure() {
        return downPressure;
    }

    public int getPulse() {
        return pulse;
    }
}
