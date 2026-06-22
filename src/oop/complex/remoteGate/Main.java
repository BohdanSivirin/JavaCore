package oop.complex.remoteGate;

public class Main {
    public static void main(String[] args) {
        Gate gate = new Gate();
        Engine engine = new Engine(gate);
        Detector detector = new Detector(engine);
        Remote remote = new Remote(detector);
        remote.pressButton();
        remote.pressButton();
        remote.pressButton();
    }
}
