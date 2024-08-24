package oop.simpleObject.basic.radio;

import java.util.Scanner;

public class Radio {
    private int volume;
    private boolean isOn;
    private String[] stations = {"99.1", "100.6", "102.4", "104.7", "107.7"};
    private String[] stationsName = {"rock", "pop", "hit", "rap", "jazz"};
    private int currentIndex;
    Scanner scanner = new Scanner(System.in);

    public Radio() {
        menu();
    }

    private void turnOn() {
        if (isOn) {
            System.out.println(" Сначала выключи радио ");
        } else {
            isOn = true;
            System.out.println(
                    " Радио включено, текущая станция = "
                            + stationsName[currentIndex]
                            + " частота " + stations[currentIndex]
                            + " громкость звука " + volume);
        }
    }

    private void turnOff() {
        if (!isOn) {
            System.out.println(" Сначала включи радио ");
        }
        if (isOn) {
            isOn = false;
            System.out.println(" Радио выключено");
        }
    }

    private void turnOnOff() {
        //isOn = !isOn ? true : false;
        System.out.println((isOn = !isOn) ? " Радиостанция = " + stationsName[currentIndex] + " частота " + stations[currentIndex] +
                " громкость звука " + volume : "Радио выключено");

//        if (!isOn) {
//            isOn = true;
//            System.out.println(
//                    " Радио включено, текущая станция = "
//                            + stationsName[currentIndex]
//                            + " частота " + stations[currentIndex]
//                            + " громкость звука " + volume);
//        } else {
//            isOn = false;
//            System.out.println(" Радио выключено ");
//        }
    }

    private void nextStation() {
        if (!isOn) {
            System.out.println(" Радио выключено, чтобы переключить станцию - включите радио");
            return;
        }
//        if (currentIndex != stations.length - 1) {
//            currentIndex++;
//            System.out.println(" Станция изменена, текущая станция = "
//                    + stationsName[currentIndex]
//                    + " частота " + stations[currentIndex]
//                    + " громкость звука " + volume);
//            return;
//        }
//        currentIndex = 0;
//        System.out.println(" Станция изменена, текущая станция = "
//                + stationsName[currentIndex]
//                + " частота " + stations[currentIndex]
//                + " громкость звука " + volume);

        System.out.println((currentIndex < stations.length - 1) ? " Радиостанция = " + stationsName[++currentIndex] + " частота " + stations[currentIndex] +
                " громкость звука " + volume : " Радиостанция = " + stationsName[currentIndex = 0] + " частота " + stations[currentIndex] +
                " громкость звука " + volume);

    }


    private void previousStation() {
        if (!isOn) {
            System.out.println(" Радио выключено, чтобы переключить станцию - включите радио");
            return;
        }
//        if (currentIndex != 0) {
//            currentIndex--;
//            System.out.println(" Станция изменена, текущая станция = "
//                    + stationsName[currentIndex]
//                    + " частота " + stations[currentIndex]
//                    + " громкость звука " + volume);
//            return;
//        }
//        currentIndex = stations.length - 1;
//        System.out.println(" Станция изменена, текущая станция = "
//                + stationsName[currentIndex]
//                + " частота " + stations[currentIndex]
//                + " громкость звука " + volume);
//
        System.out.println((currentIndex > 0) ? " Радиостанция = " + stationsName[--currentIndex] + " частота " + stations[currentIndex] +
                " громкость звука " + volume : " Радиостанция = " + stationsName[currentIndex = stations.length-1] + " частота " + stations[currentIndex] +
                " громкость звука " + volume);

    }

    private void changeVolume() {
        if (!isOn) {
            System.out.println(" Радио выключено, чтобы изменить громкость - включите радио");
            return;
        }
        System.out.println(" Введите значение громкости");
        int a = scanner.nextInt();
        if (a < 0 || a > 100) {
            System.out.println(" Некорректное значение громкости");
            return;
        }

            volume = a;
            System.out.println(" Новая громкость - " + volume);

    }

    private void menu() {
        System.out.println(" * * * * * * * * * * ");
        System.out.println(" Включить - 1 ");
        System.out.println(" Следующая станция - 2 ");
        System.out.println(" Предыдущая станция - 3 ");
        System.out.println(" Сменить громкость - 4 ");
        System.out.println(" Выключить радио - 5 ");
        System.out.println(" Выйти из программы - 6 ");
        System.out.println(" * * * * * * * * * * ");
        System.out.println(" Введите цифру ");
        int a = scanner.nextInt();
        switch (a) {
            case 1 -> turnOn();
            case 2 -> nextStation();
            case 3 -> previousStation();
            case 4 -> changeVolume();
            case 5 -> turnOff();
            case 6 -> {
                return;
            }
        }

        menu();
    }
}

