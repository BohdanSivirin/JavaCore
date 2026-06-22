package oop.complex.remoteGate;

public class Remote {
    private Detector detector;

    public Remote(Detector detector) {
        this.detector = detector;
    }

    public void pressButton() {
        System.out.println(" Remote button is pressed ");
        detector.light();
    }

}
