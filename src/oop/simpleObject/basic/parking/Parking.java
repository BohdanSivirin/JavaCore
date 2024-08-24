package oop.simpleObject.basic.parking;
import java.util.Arrays;
import java.util.Scanner;

public class Parking {
    private Car[][] parking;
    int cost; // цент в сек.
    Scanner scanner = new Scanner(System.in);

    public Parking(int[] array, int cost) {
        parking = new Car[array.length][];
        for (int i = 0; i < array.length; i++) {
            Car[] floor = new Car[array[i]];
            parking[i] = floor;
        }
        for (int i = 0; i < parking.length; i++) {
            System.out.println(Arrays.toString(parking[i]));
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
        for (int i = 0; i < parking.length; i++) {
            for (int j = 0; j < parking[i].length; j++) {
                if (parking[i][j] == null) {
                    Car car = new Car();
                    parking[i][j] = car;
                    System.out.println(" Машина успешно запаркована. QR code: " + car.getQrCode());
                    return;
                }
            }
        }
        System.out.println(" Parking is full ");
    }

    private void takeCar() {
//        boolean isFind = false;
        System.out.println(" Введите qr code ");
        String qr = scanner.next();
        for (int i = 0; i < parking.length; i++) {
            for (int j = 0; j < parking[i].length; j++) {
                if (parking[i][j] != null && parking[i][j].getQrCode().equals(qr)) {
                    long endParkTime = System.currentTimeMillis();
                    double billForParking = (double) ((endParkTime - parking[i][j].getParkTime()) / 1000 * cost) / 100;
                    System.out.println(" Заберите авто. Счет за парковку: " + billForParking + " $ ");
//                    isFind = true;
                    parking[i][j] = null;
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
        for (int i = 0; i < parking.length; i++) {
            for (int j = 0; j < parking[i].length; j++) {
                if (parking[i][j] != null) {
                    if (parking[i][j].getBrand().startsWith(text)) {
                        printFoundCar(i, j);
                        isFind = true;
                    } else if (parking[i][j].getModel().startsWith(text)) {
                        printFoundCar(i, j);
                        isFind = true;
                    } else if (parking[i][j].getColour().startsWith(text)) {
                        printFoundCar(i, j);
                        isFind = true;
                    } else if (parking[i][j].getCarPlate().startsWith(text)) {
                        printFoundCar(i, j);
                        isFind = true;
                    }
                }
            }
        }
        if (!isFind) {
            System.out.println(" Машина не найдена :( ");
        }
    }

    private void printFoundCar(int floor, int place) {
        System.out.println(" Машина найдена ");
        parking[floor][place].info();
        System.out.println(" Машина находится на " + floor + " этаже");
        System.out.println(" Место: " + place);
    }

}
