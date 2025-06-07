package oop.collections.arrayList.parking;

import oop.simpleObject.basic.parking.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class Parking {
    private final ArrayList<ArrayList<Car>> parking;
    int cost; // цент в сек.
    Scanner scanner = new Scanner(System.in);

    public Parking(int[] array, int cost) {
        parking = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            ArrayList<Car> floor = new ArrayList<>();
            for (int j = 0; j < array[i]; j++) {
                floor.add(null);
            }
            parking.add(floor);
        }
        for (int i = 0; i < parking.size(); i++) {
            System.out.println(parking.get(i));
        }
        this.cost = cost;
        menu();
    }

    private void menu() {
        System.out.println(" \" Menu \" ");
        System.out.println(" 1 -> Park ");
        System.out.println(" 2 -> Take ");
        System.out.println(" 3 -> Find ");
        System.out.println(" 4 -> Quit ");
        System.out.println(" \" Выбери номер программы \" ");
        switch (scanner.nextInt()) {
            case 1 -> parkCar();
            case 2 -> takeCar();
            case 3 -> findCar();
            case 4 -> System.exit(0);
        }
        menu();
    }

    private void parkCar() {
        for (ArrayList<Car> floor : parking) {
            for (int j = 0; j < floor.size(); j++) {
                if (floor.get(j) == null) {
                    floor.set(j, new Car());
                    System.out.println(" Машина успешно запаркована. QR code: " + floor.get(j).getQrCode());
                    return;
                }
            }
        }
        System.out.println(" Parking is full ");
    }

    private void takeCar() {
        System.out.println(" Введите qr code ");
        String qr = scanner.next();
        for (ArrayList<Car> floor : parking) {
            for (int j = 0; j < floor.size(); j++) {
                if (floor.get(j) != null && floor.get(j).getQrCode().equals(qr)) {
                    long endParkTime = System.currentTimeMillis();
                    double billForParking = (double) ((endParkTime - floor.get(j).getParkTime()) / 1000 * cost) / 100;
                    System.out.println(" Заберите авто. Счет за парковку: " + billForParking + " $ ");
                    floor.set(j, null);
                    return;
                }
            }
        }
        System.out.println(" Авто не найдено ");
    }

    private void findCar() {
        boolean isFind = false;
        System.out.println(" Введите данные для поиска авто: Марка, Модель, Цвет, Номер ");
        String text = scanner.next();
        for (int i = 0; i < parking.size(); i++) {
            ArrayList<Car> floor = parking.get(i);
            for (int j = 0; j < floor.size(); j++) {
                Car car = floor.get(j);
                if (car != null) {
                    if (car.getBrand().startsWith(text)) {
                        printFoundCar(car, i, j);
                        isFind = true;
                    } else if (car.getModel().startsWith(text)) {
                        printFoundCar(car, i, j);
                        isFind = true;
                    } else if (car.getColour().startsWith(text)) {
                        printFoundCar(car, i, j);
                        isFind = true;
                    } else if (car.getCarPlate().startsWith(text)) {
                        printFoundCar(car, i, j);
                        isFind = true;
                    }
                }
            }
        }
        if (!isFind) {
            System.out.println(" Машина не найдена :( ");
        }
    }

    private void printFoundCar(Car car, int floor, int place) {
        System.out.println(" Машина найдена ");
        car.info();
        System.out.println(" Машина находится на " + floor + " этаже");
        System.out.println(" Место: " + place);
    }


}
