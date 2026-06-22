package oop.inheritance.remoteDevices;

public final class Heater extends Device {
    private int currentTemp;
    private final int tempStep;


    public Heater(int currentTemp, int tempStep) {
        this.currentTemp = currentTemp;
        this.tempStep = tempStep;
    }

    @Override
    public void clickUp() {
        if (!isOn) {
            System.out.println(" Heater is off ");
        } else {
            currentTemp = currentTemp + tempStep;
            System.out.println(" Heater increased temperature : " + tempStep+ "\nCurrent temperature = " + currentTemp);
        }
    }

    @Override
    public void clickDown() {
        if (!isOn) {
            System.out.println(" Heater is off ");
        } else {
            currentTemp = currentTemp - tempStep;
            System.out.println(" Heater decreased temperature : " + tempStep+ "\nCurrent temperature = " + currentTemp);
        }
    }

    @Override
    public void clickLeft() {
        System.out.println(" Heater do nothing ");
    }

    @Override
    public void clickRight() {
        System.out.println(" Heater do nothing ");

    }
}
