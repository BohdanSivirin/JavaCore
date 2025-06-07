package oop.complex.elevator;

public class Motor {
    private Cabine cabine;

    public Motor(Cabine cabine) {
        this.cabine = cabine;
    }

    public void rotateDown(int floorTarget) {
        for (int i = 0; i < floorTarget; i++) {
            System.out.println(" Motor moved cabine on the floor : " + cabine.getCurrentFloor());
            cabine.setCurrentFloor(cabine.getCurrentFloor() - 1);
        }

    }

    public void rotateUp(int floorTarget) {
        for (int i = 0; i < floorTarget; i++) {
            System.out.println(" Motor moved cabine on the floor : " + cabine.getCurrentFloor());
            cabine.setCurrentFloor(cabine.getCurrentFloor() + 1);
        }
    }

}
