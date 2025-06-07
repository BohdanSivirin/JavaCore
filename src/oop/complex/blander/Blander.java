package oop.complex.blander;

public class Blander {
    private boolean pluggedIn; // turnOn blander
    private Cup cup;
    private int maxSpeed = 3;
    private int currentSpeed;
    private String[] speeds = {"zero", "first", "second", "third"};
    private int blanderSize;

    public Blander(int blanderSize) {
        this.blanderSize = blanderSize;
        cup = new Cup(blanderSize);
    }

    public void plugInOut() {
        System.out.println((pluggedIn = !pluggedIn) ? " Blander is on " : " Blander is off ");
    }

    public void installCup(Cup cup) {
        if (this.cup != null) {
            System.out.println(" Blander already has cup ");
            return;
        }
        if (cup.getSize() == blanderSize) {
            System.out.println(" Cup is successfully installed ");
            this.cup = cup;
        } else System.out.println(" Cup size doesn't match ");
    }

    public Cup takeOffCup() {

        if (cup == null) {
            System.out.println(" Blander doesn't have any cup ");
            return null;
        }
        System.out.println(" Cup is successfully taken off ");
        Cup takeOffCup = cup;
        cup = null;
        return takeOffCup;
    }

    public void changeSpeed(int value) {
        if (!pluggedIn) {
            System.out.println(" Can't change a speed. Plug in blander ");
            return;
        }
        if (cup == null) {
            System.out.println(" Can't change a speed. Cup == null ");
            return;
        }
        if (value <= maxSpeed && value >= 0) {
            currentSpeed = value;
            System.out.println(" Current speed is : " + speeds[currentSpeed]);
        } else System.out.println(" Incorrect value ");
    }

}
