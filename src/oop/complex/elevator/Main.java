package oop.complex.elevator;

public class Main {
    public static void main(String[] args) {
        Remote remote = new Remote();
        Elevator elevator = new Elevator(9);
        elevator.connectRemote(remote);
        remote.floorNumber();
        remote.floorNumber();
        remote.floorNumber();



    }
}
