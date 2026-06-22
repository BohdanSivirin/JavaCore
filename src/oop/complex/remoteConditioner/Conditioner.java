package oop.complex.remoteConditioner;

public class Conditioner {
    private boolean isOn; // button turnOn
    private int minTemperature;
    private int maxTemperature;
    private int currentTemperature;
    private String[] modes = {" Dry ", " Cool ", " Heat ", " Auto "};
    private int currentMode;
    private String[] fanSpeed = {" > ", " >> ", " >>> ", " Auto "};
    private int currentSpeed;

    public Conditioner(int minTemperature, int maxTemperature, int currentMode, int currentSpeed) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.currentTemperature = (minTemperature + maxTemperature) / 2;
        this.currentMode = currentMode;
        this.currentSpeed = currentSpeed;

    }

    public void onOff() {
        isOn = !isOn;
    }

    public void increaseTemperature() {
        if ((currentTemperature < maxTemperature) && isOn) {
            currentTemperature = currentTemperature + 1;
        }
        //  System.out.println(" Current temperature is " + currentTemperature);
    }

    public void decreaseTemperature() {
        if ((currentTemperature > minTemperature) && isOn) {
            currentTemperature = currentTemperature - 1;
        }
        // System.out.println(" Current temperature is " + currentTemperature);
    }

    public void nextMode() {
        if (!isOn) {
            return;
        }
        if (currentMode < modes.length - 1) {
            currentMode = currentMode + 1;
        } else {
            currentMode = 0;
        }

        // System.out.println(" Current mode is : " + modes[currentMode]);
    }

//    public void previousMode() {
//        if (!isOn) {
//            return;
//        }
//        for (int i = 0; i < modes.length; i++) {
//            if (i == currentMode && i != 0) {
//                currentMode = i - 1;
//            } else currentMode = modes.length - 1;
//        }
//        // System.out.println(" Current mode is : " + modes[currentMode]);
//
//    }

    public void nextSpeed() {
        if (!isOn) {
            return;
        }
        if (currentSpeed < fanSpeed.length - 1) {
            currentSpeed = currentSpeed + 1;
        } else {
            currentSpeed = 0;
        }
        // System.out.println(" Current speed is : " + fanSpeed[currentSpeed]);
    }

//    public void previousSpeed() {
//        if (!isOn) {
//            return;
//        }
//        for (int i = 0; i < fanSpeed.length; i++) {
//            if (i == currentSpeed && i != 0) {
//                currentSpeed = i + 1;
//            } else currentSpeed = fanSpeed.length - 1;
//        }
//        // System.out.println(" Current speed is : " + fanSpeed[currentSpeed]);
//    }


    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public int getCurrentMode() {
        return currentMode;
    }

    public String[] getModes() {
        return modes;
    }

    public String[] getFanSpeed() {
        return fanSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public boolean isOn() {
        return isOn;
    }
}
