package oop.complex.elevator;

public class Cabine {
    private int currentFloor;

    public void open() {
        System.out.println(" Door is open on floor : " + currentFloor);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int step) {
        currentFloor = step;
    }

}
