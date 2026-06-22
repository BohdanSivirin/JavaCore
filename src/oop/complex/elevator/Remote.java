package oop.complex.elevator;

import java.util.Scanner;

import oop.complex.elevator.Elevator.Controller;

public class Remote {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller;

    public void connectController(Controller controller) {
        this.controller = controller;
    }

    public void floorNumber() {
        System.out.println(" Input floor number : ");
        controller.work(scanner.nextInt());
    }

}
