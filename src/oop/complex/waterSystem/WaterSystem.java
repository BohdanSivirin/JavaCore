package oop.complex.waterSystem;

import java.util.ArrayList;
import java.util.Scanner;


public class WaterSystem {
    private WaterTank waterTank = new WaterTank();
    private Pump pump = new Pump(waterTank);
    private ArrayList<WaterDevice> waterDevice = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public WaterSystem() {
        // waterTank.getController().connectPump(pump);
        waterTank.connectPomp(pump);
        menu();
    }

    private void menu() {
        System.out.println(" \" Input a numb \" ");
        System.out.println(" 1 -> connect device ");
        System.out.println(" 2 -> disconnect device ");
        System.out.println(" 3 -> select device ");
        System.out.println(" 4 -> exit ");
        int a = scanner.nextInt();
        switch (a) {
            case 1 -> connectDevice();
            case 2 -> disconnectDevice();
            case 3 -> selectDevice();
            case 4 -> {
                System.exit(0);
            }
        }
        menu();
    }

    private void selectDevice() {
        if (waterDevice.isEmpty()) {
            System.out.println(" Don't have connected devices ");
            return;
        }
        System.out.println(" \" Input a numb of device to pick \" ");
        for (int i = 0; i < waterDevice.size(); i++) {
            System.out.println(" № " + i + " device " + waterDevice.get(i).getName());
        }
        int a = scanner.nextInt();
        if (a < 0 || a > waterDevice.size()) {
            System.out.println(" Incorrect value ");
            return;
        }
        System.out.println(" device " + waterDevice.get(a).getName() + " is selected ");
        waterDevice.get(a).runOutWater();
    }

    private void connectDevice() {
        System.out.println(" Create a name of device ");
        String name = scanner.next();
        waterDevice.add(new WaterDevice(name, waterTank));
        System.out.println(" Device with name " + name + " is created ");
    }

    private void disconnectDevice() {
        if (waterDevice.isEmpty()) {
            System.out.println(" Don't have devices to delete ");
            return;
        }
        System.out.println(" List of devices : ");
        for (int i = 0; i < waterDevice.size(); i++) {
            System.out.println(" № " + i + " " + waterDevice.get(i).getName());
        }
        System.out.println(" Input a name of device to delete ");
        String name = scanner.next();
        for (int i = 0; i < waterDevice.size(); i++) {
            if (waterDevice.get(i).getName().equals(name)) {
                waterDevice.remove(i);
                System.out.println(" Device : " + name + " is deleted ");
                return;
            }
        }
        System.out.println(" Device : " + name + " doesn't match. Try again ");
    }

}




