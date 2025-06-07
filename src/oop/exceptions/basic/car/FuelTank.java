package oop.exceptions.basic.car;

import java.util.Random;

public class FuelTank {
    private double currentVolume;
    private final double minVolume;
    private final Pump pump;

    public FuelTank() {
        minVolume = new Random().nextInt(5);
        currentVolume = new Random().nextInt(50);
        pump = new Pump();
    }

    public void pumpFuel(double volume) throws FuelException {
        pump.pump(volume);
    }

    private class Pump {

        private void pump(double volume) throws FuelException {
            if (currentVolume - volume >= minVolume) {
                currentVolume = currentVolume - volume;
            } else throw new FuelException("Error: Not enough fuel");
        }
    }
}
