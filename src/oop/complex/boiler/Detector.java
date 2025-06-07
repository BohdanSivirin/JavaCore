package oop.complex.boiler;

import oop.complex.boiler.Boiler.Controller;

public class Detector {
    private Controller controller;


    public Detector(Controller controller) {
        this.controller = controller;

    }

    public void checkTemp(double currentTemp) {
        controller.analyseTemp(currentTemp);
    }
}
