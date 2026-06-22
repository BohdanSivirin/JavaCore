package oop.interfaces.computer;

public class Projector implements Display {
    private int glassSize;
    private int screenSize;
    private String visualQuality;

    public Projector(int glassSize, int screenSize, String visualQuality) {
        this.glassSize = glassSize;
        this.screenSize = screenSize;
        this.visualQuality = visualQuality;
    }

    @Override
    public void print(String t) {
        System.out.println("\n Projector print: " + t + " with a " + visualQuality + " quality ");
    }
}
