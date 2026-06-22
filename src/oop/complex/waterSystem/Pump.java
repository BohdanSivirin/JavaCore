package oop.complex.waterSystem;

public class Pump {
    private WaterTank waterTank;

    public Pump(WaterTank waterTank) {
        this.waterTank = waterTank;
    }

    public void fillWaterTank(int value) {
        System.out.println(" Pump is filling the water tank");
        waterTank.setAddedCurrentVolume(value);
    }
}
