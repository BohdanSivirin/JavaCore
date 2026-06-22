package oop.inheritance.remoteDevices;

public class Main {
    public static void main(String[] args) {
        Remote remote = new Remote();
        Conditioner conditioner = new Conditioner(18);
        Tv tv = new Tv();
        Heater heater = new Heater(18, 2);
        Radio radio = new Radio();

        remote.connectDevice(conditioner);
        remote.connectDevice(tv);
        remote.connectDevice(heater);
        remote.connectDevice(radio);

//        remote.info();
//        remote.selectDevice(4);
        remote.clickLeft();
        remote.onOff();
        remote.clickUp();
        remote.clickDown();
        remote.clickLeft();
        remote.clickRight();
        remote.onOff();
    }
}
