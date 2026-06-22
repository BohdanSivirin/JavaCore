package oop.complex.radioLighter;

public class RadioLighter {
    private FlashLighter flashLighter;
    private Radio radio;

    public RadioLighter() {
        flashLighter = new FlashLighter(12, 78);
        radio = new Radio();
    }

    public void onOffFlashLigther() {
        flashLighter.onOff();
    }

    public void increaseLigthPower() {
        flashLighter.increasePower();
    }

    public void decreaseLigthPower() {
        flashLighter.decreasePower();
    }

    public void onOffRadio() {
        radio.onOff();
    }

    public void increaseVolumePower() {
        radio.increaseVolume();
    }

    public void decreaseVolumePower() {
        radio.decreaseVolume();
    }

    public void nextRadioStation() {
        radio.nextStation();
    }

    public void previousRadioStation() {
        radio.previousStation();
    }
}
