package oop.simpleObject.basic.bomb;

import java.util.Scanner;

public class Bomb {
    private int sec;
    private boolean isOn;
    Scanner scanner = new Scanner(System.in);

    public Bomb() {
        menu();
    }

    private void menu() {
        System.out.println(" \"Выберите действие\" ");
        System.out.println(" 1 -> Вкл ");
        System.out.println(" 2 -> Выкл ");
        System.out.println(" 3 -> Настройка ");
        System.out.println(" 4 -> Выйти ");
        System.out.println(" 55 -> Тайм ");

        int a = scanner.nextInt();
        switch (a) {
            case 1 -> isOn();
            case 2 -> isOff();
            case 3 -> setBomb();
            case 4 -> {
                return;
            }
            //case 55 -> printTime(2, 55, 20, 66);

        }
        menu();
    }

    private void isOn() {
        if (sec == 0) {
            System.out.println(" Для активации - настройте бомбу ");
            return;
        }
        if (!isOn) {
            isOn = true;
            System.out.println(" Бомба активирована !!! ");
            printTimer();
            isOn = false;
        }
    }

    private void isOff() {
        if (!isOn) {
            System.out.println(" Сначала активировать попробуй ");
            return;
        }
        if (sec <= 20) {
            System.out.println(" Поздно деактивировать бомбу ");
            return;
        }
        if (isOn) {
            isOn = false;
            System.out.println(" Бомба обезврежена ");
            sec = 0;
        }
    }

    private void setBomb() {
        int min = 0;
        do {
            System.out.println(" Введите минуты ");
            min = scanner.nextInt();
        } while (min < 0 || min >= 60);

        int sec = 0;
        do {
            System.out.println(" Введите секунды ");
            sec = scanner.nextInt();
        } while (sec < 0 || sec >= 60);

        this.sec = (min * 60) + sec;
        System.out.println(" sec = " + this.sec);
    }

    private void printTimer() {
        if (sec < 20) {
            System.out.println(" Слишком маленький таймер");
            return;
        }
        for (sec = sec; sec >= 0; sec--) {
            System.out.println(((sec / 60) <= 9 ? "0" + (sec / 60) : (sec / 60)) + ":"
                    + ((sec % 60) <= 9 ? "0" + (sec % 60) : (sec % 60)));
        }
        System.out.println(" BOOOOOOOM !!!!!!!!!!!!!!!!!!!!!! ");
        System.out.println(9%3);

        System.exit(0);
    }

//    public static void printTime(int hours, int minute, int seconds, int charge) {
//        for (int recharge = 0; charge > recharge; seconds++) {
//            if (seconds == 60) {
//                minute++;
//                seconds = 0;
//                if (minute == 60) {
//                    minute = 0;
//                    hours++;
//                    if (hours == 4) {
//                        recharge++;
//                    }
//                    if (hours == 24) {
//                        hours = 0;
//                    }
//                }
//            }
//        }
//        System.out.println((hours <= 9 ? "0" + hours : hours) + ":"
//                + (minute <= 9 ? "0" + minute : minute) + ":" + (seconds <= 9 ? "0" + seconds : seconds));
//
//    }
}