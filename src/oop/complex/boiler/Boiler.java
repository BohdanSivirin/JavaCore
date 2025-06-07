package oop.complex.boiler;


public class Boiler {
    private Detector detector;
    private Heater heater;
    private Water water;
    private Display display;
    private double requiredTemp;
    private Controller controller;

    public Boiler(double requiredTemp) {
        this.display = new Display();
        this.controller = new Controller();
        this.requiredTemp = requiredTemp;
        this.detector = new Detector(controller);
        this.water = new Water(detector);
        this.heater = new Heater(water);
    }

    public void start() {
        decreaseWaterTemp();
    }

    private void decreaseWaterTemp() {

        for (int i = 30; i > 0; i--) {
            double temp = water.getTemp();
            water.setTemp(temp - 0.005);

        }
    }


    public class Controller {

        public void analyseTemp(double temp) {
            temp = (Math.round(temp * 100)) / 100.0;
            display.print(" Current temperature = " + temp);
            display.print(" Reqiured temperature = " + requiredTemp);

            if (temp < (requiredTemp - 3.0)) {
                heater.heat(requiredTemp + 3.0);
            }
        }
    }
}
