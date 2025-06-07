package oop.interfaces.computer;

public class Main {
    public static void main(String[] args) {
        Projector projector = new Projector(9, 68, "ok");
        Monitor monitor = new Monitor("Samsung", 27, "perfect");
        vrEyepieces vrEyepieces = new vrEyepieces("Apple", 2500, "good");
        Computer computer = new Computer();
        computer.addDisplayDevice(projector);
        computer.addDisplayDevice(monitor);
        computer.addDisplayDevice(vrEyepieces);
        computer.setState(State.STATE_1);
        computer.setCurrentDisplayDevice(1);
        computer.showInfo(" some text 1 ");
        computer.setState(State.STATE_2);
        computer.showInfo(" some text 1 ");
        System.out.println(" * * * * * * * * * * ");
        Cow cow = new Cow("Burenka", 2023, 200, 20, 6);
        Car car = new Car("bmw", 2021, "diesel", 123456789);
        Phone phone = new Phone("iPhone", 78946666);
        computer.addUsbDevice(car);
        computer.addUsbDevice(cow);
        computer.addUsbDevice(phone);
        computer.getInfoUsbDevice(2);
        computer.setState(State.STATE_1);
        computer.getInfoUsbDevice(0);
    }
}
