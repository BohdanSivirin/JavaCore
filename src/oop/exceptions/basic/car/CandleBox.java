package oop.exceptions.basic.car;

import java.util.ArrayList;

public class CandleBox {
    private final ArrayList<Candle> candles;
    private final int candlesAmount;

    public CandleBox(int candlesAmount) {
        candles = new ArrayList<>();
        for (int i = 0; i < candlesAmount; i++) {
            candles.add(new Candle());
        }
        this.candlesAmount = candlesAmount;
    }


    public void checkAllCandlesInBox() throws CandleBoxException {
        int counter = 0;
        for (Candle candle : candles) {
            try {
                candle.giveSpark();
            } catch (CandleException e) {
                counter++;
            }
        }
        if (counter > candles.size() / 2) {
            throw new CandleBoxException("More than half of candles: " + counter + " -> not in good condition");
        }
    }

}
