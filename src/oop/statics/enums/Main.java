package oop.statics.enums;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(Brand.BMW, Colour.BLACK, Transmition.SPORT, Engine.BMW_B_5_652);
        car.info();
        Car car1 = new Car(Brand.LAND_ROVER, Colour.WHITE, Transmition.OPTIMAL, Engine.LAND_ROVER_D_2_185);
        car1.info();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Введи название двигателя ");
        String value = scanner.next();
        Engine engine = Engine.valueOf(value.toUpperCase());
        engine.info();


//        int a = random.nextInt(0, Engine.values().length);
//        Engine[] engine2 = Engine.values();
//        Engine engine3 = engine2[a];
        Engine engine1 = Engine.values()[new Random().nextInt(Engine.values().length)];
        System.out.println(engine1);
    }
}
