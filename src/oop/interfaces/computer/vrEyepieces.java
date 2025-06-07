package oop.interfaces.computer;

public class vrEyepieces implements Display {
    private String brand;
    private int cost;
    private String visualQuality;

    public vrEyepieces(String brand, int cost, String visualQuality) {
        this.brand = brand;
        this.cost = cost;
        this.visualQuality = visualQuality;
    }
    @Override
    public void print(String t) {
        System.out.println("\n vrEyepieces print: " + t + " with a " + visualQuality + " quality ");
    }
}
