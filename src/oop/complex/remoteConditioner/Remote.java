package oop.complex.remoteConditioner;

public class Remote {
    //    private boolean turnOnAirConditioner;
//    private int upTemperature;
//    private int downTemperature;
//    private int changeMode; // after each tap mode changed to the next
//    private int changeSpeed; // after each tap speed changed to the next
    private Conditioner conditioner;

    public Remote(Conditioner conditioner) {
        this.conditioner = conditioner;
    }

    public void onOff() {
        conditioner.onOff();
        printCurrentState();
    }

    private void printCurrentState() {
        if (!conditioner.isOn()) {
            System.out.println(" OFF ");
            return;
        }
        System.out.printf(" Temperature is : %d%n " +
                        " Mode is : %s%n " +
                        " Speed is : %s%n ",
                conditioner.getCurrentTemperature(),
                conditioner.getModes()[conditioner.getCurrentMode()],
                conditioner.getFanSpeed()[conditioner.getCurrentSpeed()]);
    }

    public void upTemperature() {
        if (!conditioner.isOn()) {
            printCurrentState();
            return;
        }
        conditioner.increaseTemperature();
        printCurrentState();
    }

    public void downTemperature() {
        if (!conditioner.isOn()) {
            printCurrentState();
            return;
        }
        conditioner.decreaseTemperature();
        printCurrentState();
    }

    public void changeMode() {
        if (!conditioner.isOn()) {
            printCurrentState();
            return;
        }
        conditioner.nextMode();
        printCurrentState();
    }

    public void changeSpeed() {
        if (!conditioner.isOn()) {
            printCurrentState();
            return;
        }
        conditioner.nextSpeed();
        printCurrentState();
    }

}

