package oop.inheritance.remoteDevices;

import java.util.ArrayList;

public final class Remote extends Device {
    private final ArrayList<Device> devices;
    private Device currentDevice;

    public Remote() {
        this.devices = new ArrayList<>();
    }

    void info() {
        for (int i = 0; i < devices.size(); i++) {
            System.out.println(i + 1 + ") " + devices.get(i).getClass().getSimpleName());
        }
    }

    public void connectDevice(Device device) {
        devices.add(device);
        System.out.println(device.getClass().getSimpleName() + " added to devices ");
    }

    void selectDevice(int index) {
        index = index - 1;
        if (devices.isEmpty()) {
            System.out.println(" There are no created devices ");
        }
        if (index < 0 || index > devices.size() - 1) {
            System.out.println(" Incorrect value ");
        } else {
            currentDevice = devices.get(index);
            System.out.println(currentDevice.getClass().getSimpleName() + " selected ");
        }
    }

    @Override
    public void onOff() {
        if (currentDevice == null) {
            System.out.println(" Device is not selected ");
            return;
        }
        currentDevice.onOff();
    }

    @Override
    public void clickUp() {
        if (currentDevice == null) {
            System.out.println(" Device is not selected ");
            return;
        }
        currentDevice.clickUp();
    }

    @Override
    public void clickDown() {
        if (currentDevice == null) {
            System.out.println(" Device is not selected ");
            return;
        }
        currentDevice.clickDown();
    }

    @Override
    public void clickLeft() {
        if (currentDevice == null) {
            System.out.println(" Device is not selected ");
            return;
        }
        currentDevice.clickLeft();
    }

    @Override
    public void clickRight() {
        if (currentDevice == null) {
            System.out.println(" Device is not selected ");
            return;
        }
        currentDevice.clickRight();
    }


}
