package oop.complex.tonometr;

import oop.complex.tonometr.Tonometr.Controller;

public class Mangetta {
    private Arm arm;
    private Controller controller;

    public void connectController(Controller controller) {
        this.controller = controller;
    }

    public void connectArm(Arm arm) {
        this.arm = arm;
    }

    public void scanPressure() {
        int upPressure;
        int downPressure;
        int pulse;

        if (arm == null) {
            upPressure = 0;
            downPressure = 0;
            pulse = 0;
            controller.analysePressure(upPressure, downPressure, pulse);

        } else {
            upPressure = arm.getUpPressure();
            downPressure = arm.getDownPressure();
            pulse = arm.getPulse();
            controller.analysePressure(upPressure, downPressure, pulse);
        }
    }


}
