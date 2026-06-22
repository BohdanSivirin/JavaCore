package oop.interfaces.computer;

public class Monitor implements Display {
    private String name;
    private int diagonal;
    private String visualQuality;

    public Monitor(String name, int diagonal, String visualQuality) {
        this.diagonal = diagonal;
        this.visualQuality = visualQuality;
        this.name = name;
    }

    @Override
    public void print(String t) {
        System.out.println("\n Monitor print: " + t + " with a " + visualQuality + " quality ");
    }
}
