package oop.collections.hashMap.parking;

import oop.simpleObject.basic.parking.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Parking {
    //    private Car[][] parking;
    private final HashMap<Integer, ArrayList<Car>> parking = new HashMap<>();
    private final int cost; // цент в сек.
    private final Scanner scanner = new Scanner(System.in);

    public Parking(int[] array, int cost) {
        for (int i = 0; i < array.length; i++) {
            ArrayList<Car> floor = new ArrayList<>();
            for (int j = 0; j < array[i]; j++) {
                floor.add(null);
            }
            parking.put(i + 1, floor);
        }
        for (Integer key : parking.keySet()) {
            System.out.println(" floor " + parking.get(key));
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
        for (Integer key : parking.keySet()) {
            ArrayList<Car> floor = parking.get(key);
            for (int i = 0; i < floor.size(); i++) {
                if (floor.get(i) == null) {
                    floor.set(i, new Car());
                    System.out.println(" Машина успешно запаркована. QR code: " + floor.get(i).getQrCode());
                    return;
                }
            }
        }
        System.out.println(" Parking is full ");
    }

    private void takeCar() {
        System.out.println(" Введите qr code ");
        String qr = scanner.next();
        for (Integer key : parking.keySet()) {
            ArrayList<Car> floor = parking.get(key);
            for (int i = 0; i < floor.size(); i++) {
                Car car = floor.get(i);
                if (car != null && car.getQrCode().equals(qr)) {
                    long endParkTime = System.currentTimeMillis();
                    double billForParking = (double) ((endParkTime - car.getParkTime()) / 1000 * cost) / 100;
                    System.out.println(" Заберите авто. Счет за парковку: " + billForParking + " $ ");
                    floor.set(i, null);
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
        for (Integer key : parking.keySet()) {
            ArrayList<Car> floor = parking.get(key);
            for (Car car : floor) {
                int place = floor.indexOf(car);
                if (car != null) {
                    if (car.getBrand().startsWith(text)) {
                        printFoundCar(car, key, place);
                        isFind = true;
                    } else if (car.getModel().startsWith(text)) {
                        printFoundCar(car, key, place);
                        isFind = true;
                    } else if (car.getColour().startsWith(text)) {
                        printFoundCar(car, key, place);
                        isFind = true;
                    } else if (car.getCarPlate().startsWith(text)) {
                        printFoundCar(car, key, place);
                        isFind = true;
                    }
                }
            }
        }
        if (!isFind) {
            System.out.println(" Машина не найдена :( ");
        }
    }

    private void printFoundCar(Car car, Integer key, int place) {
        System.out.println(" Машина найдена ");
        car.info();
        System.out.println(" Машина находится на " + key + " этаже");
        System.out.println(" Место: " + place);
    }

}
