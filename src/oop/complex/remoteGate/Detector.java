package oop.complex.remoteGate;

public class Detector {
    private Engine engine;

    public Detector(Engine engine) {
        this.engine = engine;
    }

    public void light() {
        System.out.println(" detector is lightning ");
        engine.changeDirection();
    }
}
