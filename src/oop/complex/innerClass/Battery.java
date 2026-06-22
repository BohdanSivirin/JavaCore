package oop.complex.innerClass;

public class Battery {
    private int maxVolume;
    private int currentVolume;

    public Battery(int maxVolume) {
        this.maxVolume = maxVolume;
        this.currentVolume = 7;
    }

    public void decreaseBatteryLvl() {
        currentVolume = currentVolume - 1;
        System.out.println(" Current battery state = " + currentVolume + " % ");
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

}
