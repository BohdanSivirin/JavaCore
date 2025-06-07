package oop.complex.elevator;

public class Elevator {
    private int floors;
    private Controller controller;
    private Motor motor;
    private Cabine cabine;

    public Elevator(int floors) {
        this.floors = floors;
        this.controller = new Controller();
        this.cabine = new Cabine();
        this.motor = new Motor(cabine);
    }

    public void connectRemote(Remote remote) {
        remote.connectController(controller);
    }


    public class Controller {

        public void work(int floorRemote) {
            int targetFloor;
            if (floorRemote > floors || floorRemote < 0) {
                System.out.println(" Incorrect value ");
                return;
            }
            if (cabine.getCurrentFloor() < floorRemote) {
                targetFloor = floorRemote - cabine.getCurrentFloor();
                motor.rotateUp(targetFloor);
                cabine.open();
            } else if (cabine.getCurrentFloor() > floorRemote) {
                targetFloor = cabine.getCurrentFloor() - floorRemote;
                motor.rotateDown(targetFloor);
                cabine.open();
            } else cabine.open();
        }


    }


}
