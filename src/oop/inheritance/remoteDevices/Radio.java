package oop.inheritance.remoteDevices;

public final class Radio extends Device {
    private final String[] stationsName;
    private int currentStation;
    private final int volumeStep;
    private int currentVolume;
    private final int maxVolume = 30;
    private final int minVolume = 0;

    public Radio() {
        stationsName = new String[]{"rock", "pop", "hit", "rap", "jazz"};
        this.currentStation = 0;
        this.currentVolume = 5;
        this.volumeStep = 2;
    }


    @Override
    public void clickUp() {
        if (!isOn) {
            System.out.println(" Radio is off ");
            return;
        }
        if (currentVolume < maxVolume) {
            currentVolume = currentVolume + volumeStep;
            System.out.println(" Radio increased volume. Current volume : " + currentVolume);
        } else System.out.println(" max volume -> " + maxVolume);
    }

    @Override
    public void clickDown() {
        if (!isOn) {
            System.out.println(" Radio is off ");
            return;
        }
        if (currentVolume > minVolume) {
            currentVolume = currentVolume - volumeStep;
            System.out.println(" Radio decreased volume. Current volume : " + currentVolume);
        } else System.out.println(" min volume -> " + minVolume);
    }


    @Override
    public void clickLeft() {
        if (!isOn) {
            System.out.println(" Radio is off ");
            return;
        }
        if (currentStation != 0) {
            System.out.println(" Radio is playing on station : " + stationsName[--currentStation]);
        } else {
            currentStation = stationsName.length - 1;
            System.out.println(" Radio is playing on station : " + stationsName[currentStation]);
        }
    }

    @Override
    public void clickRight() {
        if (!isOn) {
            System.out.println(" Radio is off ");
            return;
        }
        if (currentStation != stationsName.length - 1) {
            System.out.println(" Radio is playing on station : " + stationsName[++currentStation]);
        } else {
            currentStation = 0;
            System.out.println(" Radio is playing on station : " + stationsName[currentStation]);
        }
    }
}
