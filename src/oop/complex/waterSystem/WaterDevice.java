package oop.complex.waterSystem;

import java.util.Scanner;

public class WaterDevice {
    private String name;
    private Scanner scanner = new Scanner(System.in);
    private WaterTank waterTank;

    public WaterDevice(String name, WaterTank waterTank) {
        this.name = name;
        this.waterTank=waterTank;
    }

    public void runOutWater() {
        System.out.println(" Input an amount of water to drop ");
        int value = scanner.nextInt();
        System.out.println(" Device : " + name + " has droped " + value + " amount of water ");
        while (value > 0) {
            waterTank.setLeftCurrentVolume(1);
            value--;
        }
    }

    public String getName() {
        return name;
    }


}
