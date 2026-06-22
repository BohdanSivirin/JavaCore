package oop.complex.radioLighter;

public class FlashLighter {
    private boolean isOn;
    private Lamp[] lamps;

    public FlashLighter(int amountLamp, int power) {
        lamps = new Lamp[amountLamp];
        for (int i = 0; i < lamps.length; i++) {
            lamps[i] = new Lamp(power);
        }
    }

    public void onOff() {
        isOn = !isOn;
        for (Lamp lamp : lamps) {
            lamp.onOff();
        }
    }

    public void increasePower() {
        if (!isOn) {
            System.out.println(" Firstly turn on the FlashLighter ");
        } else {
            for (Lamp lamp : lamps) {
                lamp.increasePower();
            }
        }
    }

    public void decreasePower() {
        if (!isOn) {
            System.out.println(" Firstly turn on the FlashLighter ");
        } else {
            for (Lamp lamp : lamps) {
                lamp.dicreasePower();
            }
        }
    }

}
