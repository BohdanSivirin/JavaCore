package oop.exceptions.basic.building;

import oop.exceptions.basic.building.Building.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Domophone {
    private final Display display = new Display();
    private Controller controller;
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        try {
            sendInfo();
        } catch (InputMismatchException exception) {
            display.print("Incorrect flat number");
            scanner=new Scanner(System.in);
        } catch (BuildingException exception) {
            display.print(exception.getMessage());

        }
        menu();
    }

    private void sendInfo() throws BuildingException {
        display.print("Input a flat numb: ");
        controller.search(scanner.nextInt());
        display.print("Domophone send info to Controller");

    }

    public void connectController(Controller controller) {
        this.controller = controller;
    }

    private static class Display {
        private void print(String t) {
            System.out.println(t);
        }
    }
}
