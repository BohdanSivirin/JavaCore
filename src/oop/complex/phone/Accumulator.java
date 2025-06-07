package oop.complex.phone;

public class Accumulator {
    private double currentBatteryLevel;

    public Accumulator(double currentBatteryLevel) {
        this.currentBatteryLevel = currentBatteryLevel;

    }

    public void chargeAccumulator() {
        if (currentBatteryLevel < 100) {
            currentBatteryLevel = currentBatteryLevel + 1;
        }
    }

    public void dischargeAccumulator(double discharge) {
        if (currentBatteryLevel > 0) {
            currentBatteryLevel = currentBatteryLevel - discharge;
        }
    }

    public double getCurrentBatteryLevel() {
        currentBatteryLevel = Math.round(currentBatteryLevel);
        return currentBatteryLevel;
    }
}
