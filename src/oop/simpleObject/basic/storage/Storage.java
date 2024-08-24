package oop.simpleObject.basic.storage;

import java.util.Arrays;
import java.util.Scanner;

public class Storage {
    private Product[][][] storage;
    private String[] productNames = new String[1]; //названия товаров для поиска тех что были в сторе и закончились == 0
    private int freeIndex = 0;
    private int amountPutToStore; // желаемое кол-во товара положить в ячейку
    private int[] freeCell = new int[0]; // координаты пустой ячейки
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
//                for (int k = 0; k < storage[i][j].length; k++) {
//                    System.out.println(storage[i][j][k] + " ");
//                }
                System.out.println();
            }
            System.out.println();
        }
        menu();
    }

    private void menu() {
        System.out.println(" \" Menu \" ");
        System.out.println(" 1 -> findProductByTitle ");
        System.out.println(" 2 -> findProductByPrice ");
        System.out.println(" 3 -> findProductByOutOfStock ");
        System.out.println(" 4 -> putProduct ");
        System.out.println(" 5 -> takeProduct ");
        System.out.println(" \" Выбери номер программы \" ");
        switch (scanner.nextInt()) {
            case 1 -> findProductByTitle();
            case 2 -> findProductByPrice();
            case 3 -> findProductByOutOfStock();
            case 4 -> putProduct();
            case 5 -> takeProduct();
            case 6 -> System.exit(0);
        }
        menu();
    }

    private int[][] findProductByTitle() {
        int[][] foundProducts = new int[0][0];
        boolean isFind = false;
        int foundIndex = -1;
        System.out.println(" Enter data to search the product: title ");
        String text = scanner.next();
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                for (int k = 0; k < storage[i][j].length; k++) {
                    if (storage[i][j][k] != null && storage[i][j][k].getTitle().equals(text)) {
                        printFoundProduct(i, j, k);
                        isFind = true;
                        foundIndex = 1;
                    }
                    if (foundIndex != -1) {
                        int[][] foundProducts2 = new int[foundProducts.length + 1][3];
                        System.arraycopy(foundProducts, 0, foundProducts2, 0, foundProducts.length);
                        foundProducts2[foundProducts.length] = new int[]{i, j, k};
                        foundProducts = foundProducts2;
                        foundIndex = -1;
                    }
                }
            }
        }
        if (!isFind) {
            System.out.println(" Product is not found ");
        }
        return foundProducts;
    }

    private void findProductByPrice() {
        boolean isFind = false;
        System.out.println(" Enter data to search the product: price ");
        double text = scanner.nextDouble();
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                for (int k = 0; k < storage[i][j].length; k++) {
                    if (storage[i][j][k] != null) {
                        if (storage[i][j][k].getPrice() == text) {
                            printFoundProduct(i, j, k);
                            isFind = true;
                        }
                    }
                }
            }
        }
        if (!isFind) {
            System.out.println(" Product is not found ");
        }
    }

    private void findProductByOutOfStock() {
        boolean isFind = false;
        go:
        for (String name : productNames) {
            for (int i = 0; i < storage.length; i++) {
                for (int j = 0; j < storage[i].length; j++) {
                    for (int k = 0; k < storage[i][j].length; k++) {
                        if (storage[i][j][k] != null && storage[i][j][k].getTitle().equals(name)) {
                            continue go;
                        }
                    }
                }
            }
            if (name != null) System.out.println(" Product " + name + " is out of stock ");
            isFind = true;
        }
        if (!isFind) System.out.println(" Every products is in stock ");
    }

    private int[] findFreeCell() {
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                for (int k = 0; k < storage[i][j].length; k++) {
                    if (storage[i][j][k] == null) {
                        return new int[]{i, j, k};
                    }
                }
            }
        }
        return null;
    }

    private void putProduct() {
        System.out.println(" Input a title ");
        String title = scanner.next();
        System.out.println(" Input a price ");
        double price = scanner.nextDouble();
        System.out.println(" Input a max to store ");
        int maxToStore = scanner.nextInt();
        System.out.println(" Input an amount to Store ");
        amountPutToStore = scanner.nextInt();
        int freeRoom;
        int freeShelf;
        int freeCell;
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i].length; j++) {
                for (int k = 0; k < storage[i][j].length; k++) {

                }
            }
        }
    }


    private void putProduct2() {
        System.out.println(" Input a title ");
        String title = scanner.next();
//        for (String name : productNames) {
//            if (name != null && name.equals(title)) {
//                System.out.println(" This title already exist ");
//                return;
//            }
//        }
        System.out.println(" Input a price ");
        double price = scanner.nextDouble();
        System.out.println(" Input a max to store ");
        int maxToStore = scanner.nextInt();
        System.out.println(" Input an amount to Store ");
        amountPutToStore = scanner.nextInt();
        do {
            freeCell = findFreeCell();
            if (freeCell == null) {
                System.out.println(" Cannot find free cell... Buy ");
                return;
            }
            Product product = new Product(title, price, maxToStore);
            if (amountPutToStore >= maxToStore) {
                product.setCurrentAmount(maxToStore);
                amountPutToStore = amountPutToStore - maxToStore;
            } else {
                product.setCurrentAmount(amountPutToStore);
                amountPutToStore = 0;
            }
            storage[freeCell[0]][freeCell[1]][freeCell[2]] = product;
            printFoundProduct(freeCell[0], freeCell[1], freeCell[2]);
        } while (amountPutToStore > 0);
        System.out.println(title + " successfully added to Store ");
        productNames[freeIndex++] = title;
        if (freeIndex == productNames.length) {
            String[] newProductNames = new String[productNames.length + 2];
            System.arraycopy(productNames, 0, newProductNames, 0, productNames.length);
            productNames = newProductNames;
        }
    }

    private void takeProduct() {
        int[][] foundProducts = findProductByTitle();
        if (foundProducts.length == 0) return;
        System.out.println(" Input how many product you want to take ");
        int amountToTake = scanner.nextInt();
        for (int[] foundProduct : foundProducts) {
            if (storage[foundProduct[0]][foundProduct[1]][foundProduct[2]].getCurrentAmount() <= amountToTake) {
                System.out.println(" Take " + storage[foundProduct[0]][foundProduct[1]][foundProduct[2]].getCurrentAmount() + " amount of product ");
                amountToTake = amountToTake - storage[foundProduct[0]][foundProduct[1]][foundProduct[2]].getCurrentAmount();
                storage[foundProduct[0]][foundProduct[1]][foundProduct[2]] = null;
                if (amountToTake == 0) return;
            } else {
                System.out.println(" Take " + amountToTake + " amount of product ");
                int difference = storage[foundProduct[0]][foundProduct[1]][foundProduct[2]].getCurrentAmount() - amountToTake;
                storage[foundProduct[0]][foundProduct[1]][foundProduct[2]].setCurrentAmount(difference);
                return;
            }
        }
        if (amountToTake > 0) {
            System.out.println(" sorry, we don't have enough, please find " + amountToTake + " somewhere else.");
        }
    }

    private void printFoundProduct(int room, int cell, int stillage) {
        System.out.println(" * * * * * * * * * * * * ");
        System.out.println(" Product has been found ");
        storage[room][cell][stillage].info();
        System.out.println(" Room: " + room);
        System.out.println(" Cell: " + cell);
        System.out.println(" Stillage: " + stillage);
        System.out.println(" * * * * * * * * * * * * ");
    }


}
