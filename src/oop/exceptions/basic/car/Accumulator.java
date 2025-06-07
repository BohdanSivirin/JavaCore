package oop.exceptions.basic.car;

import java.util.Random;

public class Accumulator {
    private final int currentCharge;

    public Accumulator() {
        currentCharge = new Random().nextInt(40);
    }

    public void discharge(int chargeAmount) throws AccumulatorException {
        if (chargeAmount > currentCharge) {
            throw new AccumulatorException("Error: Not enough power");
        }
    }
}
