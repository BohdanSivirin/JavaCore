package oop.simpleObject.basic.storage2;

import java.util.Arrays;
import java.util.Scanner;

public class Storage {
    private Product[][][] storage;
    //private int amountPutToStore; // общее кол-во товара которое нужно разложить по ячейкам
    private int outOfStockAmount = 2; // кол-во товара при котором заказ делать
    private int freeRoom;
    private int freeShelving;
    private int freeCell;
    Scanner scanner = new Scanner(System.in);

    public Storage(int[][] array) {
        storage = new Product[array.length][][];
        for (int i = 0; i < array.length; i++) {
            storage[i] = new Product[array[i].length][];
            for (int j = 0; j < array[i].length; j++) {
                storage[i][j] = new Product[array[i][j]];
            }
        }
        for (int i = 0; i < storage.length; i++) {
            System.out.println(" Room " + i + " ");
            for (int j = 0; j < storage[i].length; j++) {
                System.out.println(" Shelving " + j + " ");
                System.out.println(Arrays.toString(storage[i][j]));
                System.out.println();
            }
            System.out.println();
        }
        menu();
    }

    private void putProduct() {

        System.out.println(" Input a title ");
        String title = scanner.next();
        System.out.println(" Input an amount to Store ");
        int amountPutToStore = scanner.nextInt();
        System.out.println(" Input a max to store ");
        int maxToStore = scanner.nextInt();
        System.out.println(" Input a price ");
        double price = scanner.nextDouble();
        int freeRoom = -1;
        int freeShel = -1;
        int freeCell = -1;
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                for (int k = 0; k < storage[i][j].length; k++) {
                    if (storage[i][j][k] != null && storage[i][j][k].getTitle().equals(title)) {
                        int difference = maxToStore - storage[i][j][k].getCurrentAmount(); // проверяем наличие пустого места в ячейке найденого товара
//                        if (difference == 0) continue;
                        if (amountPutToStore <= difference) {
                            storage[i][j][k].setCurrentAmount(amountPutToStore + storage[i][j][k].getCurrentAmount());
                            System.out.println(" Product with " + title + " successfully added to Store " + " i " + i + " j " + j + " k " + k + "amountPutToStore" + amountPutToStore);
                            // координаты куда ложить и сколько
                            return;
                        }
                        storage[i][j][k].setCurrentAmount(maxToStore);
                        amountPutToStore = amountPutToStore - difference;
                        System.out.println(" Product with " + title + " successfully added to Store " + " i " + i + " j " + j + " k " + k);

                    } else if (storage[i][j][k] == null && freeRoom == -1) {
                        //если фри рум == -1 тогда запоминаем первую свободную ячейку
                        freeRoom = i;
                        freeShel = j;
                        freeCell = k;
                    }
                    if (i == storage.length - 1 && j == storage[i].length - 1 && k == storage[i][j].length - 1) {
                        if (freeRoom == -1) {
                            System.out.println(" Storage is full. Amount of products left " + amountPutToStore);
                            return;
                        }
                        if (amountPutToStore <= maxToStore) {
                            storage[freeRoom][freeShel][freeCell] = new Product(title, price, amountPutToStore);
                            System.out.println(" Added Amount " + storage[freeRoom][freeShel][freeCell].getCurrentAmount() + " Room " + freeRoom + " Shell " + freeShel + " Cell " + freeCell);
                            return;
                        }
                        storage[freeRoom][freeShel][freeCell] = new Product(title, price, maxToStore);
                        amountPutToStore = amountPutToStore - maxToStore;
                        System.out.println(" Added Amount " + storage[freeRoom][freeShel][freeCell].getCurrentAmount() + " Room " + i + " Shell " + j + " Cell " + k);

                        i = freeRoom;
                        j = freeShel;
                        k = freeCell;

                    }

//                        if (!isExist) {
//                            System.out.println(" Input a price ");
//                            price = scanner.nextDouble();
//                            System.out.println(" Input a max to store ");
//                            maxToStore = scanner.nextInt();
//                            isExist = true;
//                        }
//                    if (amountPutToStore == 0) {
//                        freeRoom = i;
//                        freeShelving = j;
//                        freeCell = k;
//                        System.out.println(" All products were successfully put to store ");
//                        System.out.println(" NEW: Free Room " + freeRoom + " freeShelving " + freeShelving + " freeCell " + freeCell);
//                        return;
//                    }
//                    Product product = new Product(title, price, maxToStore);
//                    if (amountPutToStore >= maxToStore) {
//                        product.setCurrentAmount(maxToStore);
//                        amountPutToStore = amountPutToStore - maxToStore;
//                    } else {
//                        product.setCurrentAmount(amountPutToStore);
//                        amountPutToStore = 0;
//                    }
//                    storage[i][j][k] = product;
//                    System.out.println(" Product = " + product.getTitle() + " is successfully put to store ");
                }
            }
        }
    }
    //  System.out.println(" The Storage is overloaded. Take your amount put to store "+amountPutToStore);


    private void menu() {
        System.out.println(" \" Menu \" ");
        System.out.println(" 1 -> findProductByTitle ");
        System.out.println(" 2 -> findProductByPrice ");
        System.out.println(" 3 -> findProductByOutOfStock ");
        System.out.println(" 4 -> putProduct ");
        System.out.println(" 5 -> takeProduct ");
        System.out.println(" \" Выбери номер программы \" ");
        switch (scanner.nextInt()) {
//                case 1 -> findProductByTitle();
//                case 2 -> findProductByPrice();
//                case 3 -> findProductByOutOfStock();
            case 4 -> putProduct();
//                case 5 -> takeProduct();
            case 6 -> System.exit(0);
        }
        menu();
    }

}
