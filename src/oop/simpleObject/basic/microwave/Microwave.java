package oop.simpleObject.basic.microwave;

import java.util.Scanner;

public class Microwave {
    private boolean isOn; // включена в розетку
    private boolean isOpen = true; // дверь в микроволновке
    private int timer; // таймер времени в секундах
    private int maxPower; // макс мощность
    private int minPower; // мин мощность
    private int currentPower; // текущая мощность
    private int currentMode = -1;
    private String[] modeNames = {"Cup", "Plate", "Manual"};
    Scanner scanner = new Scanner(System.in);

    // -1 - дефолтный режим (таймер==0,мощность == мин, нельзя включить если режим дефолт)
    // 0 - режим чашка ---
    // 1 - режим тарелка
    // 2 - режим ручной.

    public Microwave(int maxPower, int minPower) {
        this.maxPower = maxPower;
        this.minPower = minPower;
        menu();
    }

    private void menu() {
        System.out.println(" Choose the options: ");
        System.out.println(" 1 -> turnOnOff ");
        System.out.println(" 2 -> switchOpenClose ");
        System.out.println(" 3 -> start ");
        int a = scanner.nextInt();
        switch (a) {
            case 1:
                turnOnOff();
            case 2:
                switchOpenClose();
            case 3:
                start();
        }
    }

    private void turnOnOff() {
        System.out.println((isOn = !isOn) ? " Microwave is turn on. Current mode is: " + modeNames[currentMode]
                + " Timer is: 00:00 " + "Current Power is: " + minPower : " Microwave is turn Off");
        currentMode = 0;
    }

    private void switchOpenClose() {
        System.out.println((isOpen = !isOpen) ? " The door is open " : " The door is close ");
    }

    private void selectMode() {
        int mode;
        do {
            System.out.println(" Choose the Mode from 0 to 2 ");
            mode = scanner.nextInt();
        } while (mode < 0 || mode > 2);
        if (mode == 0) {
            currentMode = mode;
            currentPower = (maxPower * 75) / 100;
            timer = 70;
        }
        if (mode == 1) {
            currentMode = mode;
            currentPower = maxPower;
            timer = 220;
        }
        if (mode == 2) {
            currentMode = mode;
        }
    }

    private void start() {
        if (!isOn) {
            System.out.println(" Cannot do it, the microwave should be: On ");
            return;
        }
        if (currentMode == -1) {
            System.out.println(" Cannot do it, pre-select the mode from 0 to 2 ");
            return;
        }
        if (isOpen) {
            System.out.println(" Cannot do it, the door should be: Close ");
            return;
        }

        System.out.println(" Microwave starts with: " + modeNames[currentMode] + " mode ");
        System.out.println(" Power: " + currentPower);
        System.out.println(" Timer: " + timer);
        for (; timer >= 0; timer--) {
            System.out.println(((timer / 60 <= 9) ? "0" + timer / 60 : timer / 60) + " : "
                    + ((timer % 60 <= 9) ? "0" + timer % 60 : timer % 60));
        }
    }

    private void setTimer() {
        if (!isOn) {
            System.out.println(" Cannot do it, the microwave should be: On ");
            return;
        }

        if (currentMode != 2) {
            System.out.println(" Cannot do it, the mode should be: 2 ");
            return;
        }
        int min = 0;
        do {
            System.out.println(" Set up the minutes within the range from 0 to 30 ");
            min = scanner.nextInt();
        } while (min < 0 || min >= 30);
        int sec = 0;
        do {
            System.out.println(" Set up the seconds: ");
            sec = scanner.nextInt();
        } while (sec < 0 || sec >= 60);
        timer = (min * 60) + sec;
        System.out.println(" The timer is set: " + timer);
    }

    private void setPower() {
        if (!isOn) {
            System.out.println(" Cannot do it, the microwave should be: On ");
            return;
        }
        if (currentMode != 2) {
            System.out.println(" Cannot do it, the mode should be: 2 ");
            return;
        }
        int power;
        do {
            System.out.println(" Set up the power: ");
            power = scanner.nextInt();
        } while (power < minPower || power > maxPower);
        currentPower = power;
        System.out.println(" The Power is set: " + currentPower);
    }


}
