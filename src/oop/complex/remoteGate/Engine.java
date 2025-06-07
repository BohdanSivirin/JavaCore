package oop.complex.remoteGate;

public class Engine {
    private int rotateState; // 0 = right; 1= left
    private Gate gate;

    public Engine(Gate gate) {
        this.gate = gate;
    }

    public void changeDirection() {
        if (rotateState == 0) {
            rotateClockwise();
            gate.openGate();
            rotateState = 1;
        } else {
            rotateBackwise();
            gate.closeGate();
            rotateState = 0;
        }

    }

    public void rotateClockwise() {
        System.out.println(" a clockwise direction ");
    }

    public void rotateBackwise() {
        System.out.println(" a backwise direction ");
    }

    public int getRotateState() {
        return rotateState;
    }
}


