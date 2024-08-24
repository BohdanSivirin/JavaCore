package oop.simpleObject.basic.parking;

import java.util.Random;
import java.util.Scanner;

public class Car {
    private String brand;
    private String model;
    private String colour;
    private String carPlate;
    private Long parkTime;
    private String qrCode;

    public Car() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Марка: ");
        this.brand = scanner.next();
        System.out.println(" Модель: ");
        this.model = scanner.next();
        System.out.println(" Цвет: ");
        this.colour = scanner.next();
        System.out.println(" Номер: ");
        this.carPlate = scanner.next();
        parkTime = System.currentTimeMillis();
        qrCode = generateQr();
    }

    private String generateQr() {
        Random random = new Random();
        int a;
        char b;
        String qr = "";
        while (qr.length() < 10) {
            a = random.nextInt(0, 10);
            qr = qr + a;
        }
        while (qr.length() < 14) {
            b = (char) (random.nextInt(25) + 'a');
            qr = (qr + b).toUpperCase();
        }
        return qr;
    }

    public void info() {
        System.out.println("**************");
        System.out.println(" Марка: " + brand);
        System.out.println(" Модель: " + model);
        System.out.println(" Цвет: " + colour);
        System.out.println(" Номер: " + carPlate);
    }

    public String getQrCode() {
        return qrCode;
    }

    public Long getParkTime() {
        return parkTime;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public String getCarPlate() {
        return carPlate;
    }
}
