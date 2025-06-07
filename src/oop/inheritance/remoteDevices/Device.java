package oop.inheritance.remoteDevices;

public abstract class Device {
    protected boolean isOn;

    public abstract void clickUp();

    public abstract void clickDown();

    public abstract void clickLeft();

    public abstract void clickRight();

    public void onOff() {
        System.out.println((isOn = !isOn) ? " Device is turned on " : " Device is turned off ");
    }
}
