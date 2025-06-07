package oop.complex.boiler;


public class Water {
    private double temp = 25.45;
    private Detector detector;

    public Water(Detector detector) {
        this.detector = detector;
    }
//
//    public void decreaseTemp(double value) {
//        temp = temp - value;
//        detector.checkTemp(temp);
//    }

    public void increaseTemp(double value) {
        temp = value;
        detector.checkTemp(temp);
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
        detector.checkTemp(temp);
    }
}
