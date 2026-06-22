package oop.inheritance.remoteDevices;

import java.util.ArrayList;
import java.util.Collections;

public final class Conditioner extends Device {
    private final int stepTemp;
    private final ArrayList<String> modes;
    private int currentMode;
    private int currentTemp;
    private final int minTemp = 5;
    private final int maxTemp = 28;


    public Conditioner(int currentTemp) {
        this.currentTemp = currentTemp;
        this.stepTemp = 1;
        this.currentMode = 0;
        this.modes = new ArrayList<>();
        Collections.addAll(modes, "Heat", "Dry", "Cold", "Wave");
    }

    @Override
    public void clickUp() {
        if (!isOn) {
            System.out.println(" Conditioner is off ");
            return;
        }
        if (currentTemp < maxTemp) {
            currentTemp = currentTemp + stepTemp;
            System.out.println(" Conditioner increase temperature on : " + stepTemp + "\nCurrent temperature = " + currentTemp);
        } else System.out.println(" max temperature -> " + maxTemp);
    }

    @Override
    public void clickDown() {
        if (!isOn) {
            System.out.println(" Conditioner is off ");
            return;
        }
        if (currentTemp > minTemp) {
            currentTemp = currentTemp - stepTemp;
            System.out.println(" Conditioner decrease temperature on : " + stepTemp + "\nCurrent temperature = " + currentTemp);
        } else System.out.println(" min temperature -> " + minTemp);
    }

    @Override
    public void clickLeft() {
        if (!isOn) {
            System.out.println(" Conditioner is off ");
            return;
        }
        if (currentMode != 0) {
            System.out.println(" Conditioner change the mode. Current mode is : " + modes.get(--currentMode));

        } else {
            currentMode = modes.size() - 1;
            System.out.println(" Conditioner change the mode. Current mode is : " + modes.get(currentMode));
        }
    }

    @Override
    public void clickRight() {
        if (!isOn) {
            System.out.println(" Conditioner is off ");
            return;
        }
        if (currentMode != modes.size() - 1) {
            System.out.println(" Conditioner change the mode. Current mode is : " + modes.get(currentMode++));

        } else {
            currentMode = 0;
            System.out.println(" Conditioner change the mode. Current mode is : " + modes.get(currentMode));
        }
    }
}
