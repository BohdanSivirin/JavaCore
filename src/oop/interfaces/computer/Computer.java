package oop.interfaces.computer;

import java.util.ArrayList;

enum State {
    STATE_1, // транслировать на 1 устройство
    STATE_2, // транслировать на все устройства
}

public class Computer {
    private ArrayList<Display> devices;
    private ArrayList<Usb> connectedDevices;
    private int currentDisplayDevice;
    private String currentUsbData;
    private State state;

    public Computer() {
        devices = new ArrayList<>();
        state = State.STATE_2;
        connectedDevices = new ArrayList<>();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCurrentDisplayDevice(int currentDisplayDevice) {
        if (currentDisplayDevice < 0 || currentDisplayDevice > devices.size()) {
            System.out.println(" Index out of bounds ");
            return;
        }
        this.currentDisplayDevice = currentDisplayDevice;
    }

    public void showInfo(String t) {
        if (state != State.STATE_1) {
            for (int i = 0; i < devices.size(); i++) {
                devices.get(i).print(t);
            }
        } else devices.get(currentDisplayDevice).print(t);
    }

    public void addDisplayDevice(Display device) {
        devices.add(device);
    }

    public void addUsbDevice(Usb device) {
        connectedDevices.add(device);
    }

    public void getInfoUsbDevice(int currentUsbDevice) {
        this.currentUsbData = connectedDevices.get(currentUsbDevice).getData();
        showInfo(currentUsbData);
    }


}
