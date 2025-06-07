package oop.complex.remoteConditioner;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Conditioner conditioner = new Conditioner(18, 31, 1, 1);
        Remote remote = new Remote(conditioner);
//        remote.upTemperature();
//        remote.changeMode();
//        remote.changeSpeed();
        remote.onOff();
        remote.upTemperature();
        remote.changeMode();
        remote.changeSpeed();
        remote.downTemperature();
        remote.downTemperature();
        remote.downTemperature();
        remote.downTemperature();
        remote.downTemperature();
        remote.downTemperature();
        remote.downTemperature();
        remote.downTemperature();
        remote.changeMode();
        remote.changeMode();
        remote.changeMode();
        remote.changeMode();
        remote.changeSpeed();
        remote.changeSpeed();
        remote.changeSpeed();
        remote.changeSpeed();
        remote.changeSpeed();
        remote.changeSpeed();
        remote.changeSpeed();
        remote.changeSpeed();
        remote.changeSpeed();
        remote.changeSpeed();
        remote.changeSpeed();
    }
}
