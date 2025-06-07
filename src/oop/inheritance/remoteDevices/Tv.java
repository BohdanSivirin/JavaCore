package oop.inheritance.remoteDevices;

import java.util.ArrayList;
import java.util.Collections;

public final class Tv extends Device {
    private final int volumeStep;
    private int currentVolume;
    private final ArrayList<String> channels;
    private int currentChanel;
    private final int maxVolume = 100;
    private final int minVolume = 1;


    public Tv() {
        this.volumeStep = 1;
        this.currentVolume = 10;
        this.currentChanel = 0;
        this.channels = new ArrayList<>();
        Collections.addAll(channels, "1+1", "Inter", "ICTV", "Discovery", "NBC", "Fox news", "CBS");
    }


    @Override
    public void clickUp() {
        if (!isOn) {
            System.out.println(" TV is off ");
            return;
        }
        if (currentVolume < maxVolume) {
            currentVolume = currentVolume + volumeStep;
            System.out.println(" TV increased volume. Current volume : " + currentVolume);
        } else System.out.println(" max volume -> " + maxVolume);
    }

    @Override
    public void clickDown() {
        if (!isOn) {
            System.out.println(" TV is off ");
            return;
        }
        if (currentVolume > minVolume) {
            currentVolume = currentVolume - volumeStep;
            System.out.println(" TV decreased volume. Current volume : " + currentVolume);
        } else System.out.println(" min volume -> " + minVolume);
    }


    @Override
    public void clickLeft() {
        if (!isOn) {
            System.out.println(" TV is off ");
            return;
        }
        if (currentChanel != 0) {
            System.out.println(" TV shows previous chanel : " + channels.get(--currentChanel));
        } else {
            currentChanel = channels.size() - 1;
            System.out.println(" TV shows previous chanel : " + channels.get(currentChanel));
        }
    }

    @Override
    public void clickRight() {
        if (!isOn) {
            System.out.println(" TV is off ");
            return;
        }
        if (currentChanel != channels.size() - 1) {
            System.out.println(" TV shows next chanel : " + channels.get(++currentChanel));
        } else {
            currentChanel = 0;
            System.out.println(" TV shows next chanel : " + channels.get(currentChanel));
        }
    }
}
