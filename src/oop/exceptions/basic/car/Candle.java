package oop.exceptions.basic.car;

import java.util.Random;

public class Candle {
    private final boolean isGood;

    public Candle() {
        int error = new Random().nextInt(101);
        isGood = error > 59;
    }

    public void giveSpark() throws CandleException {
        if (!isGood) {
            throw new CandleException("Error: Candle isn't give a spark");
        }
    }

}
