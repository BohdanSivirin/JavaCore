package oop.collections.hashMap.library;

import java.util.HashMap;
import java.util.Scanner;

public class Library {
    private final HashMap<Integer, HashMap<Integer, HashMap<Integer, Book>>> library = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public Library(int[][] config) {
        for (int i = 0; i < config.length; i++) {
            HashMap<Integer, HashMap<Integer, Book>> room = new HashMap<>();
            for (int j = 0; j < config[i].length; j++) {
                HashMap<Integer, Book> shelf = new HashMap<>();
                for (int k = 0; k < config[i][j]; k++) {
                    shelf.put(k + 1, null);
                }
                room.put(j, shelf);
            }
            library.put(i, room);
        }

        for (Integer roomNumber : library.keySet()) {
            System.out.println(" Room " + roomNumber);
            for (Integer shelfNumber : library.get(roomNumber).keySet()) {
                System.out.println(" Shelf " + shelfNumber);
                for (Integer bookNumber : library.get(roomNumber).get(shelfNumber).keySet()) {
                    System.out.print(" " + bookNumber + " " + library.get(roomNumber).get(shelfNumber).get(bookNumber) + " ; ");
                }
                System.out.println(" ");
            }
        }
        menu();
    }

    private void menu() {
        System.out.println(" \" Выбери номер программы \" ");
        System.out.println(" 1 -> Put ");
        System.out.println(" 2 -> Take ");
        System.out.println(" 3 -> Find ");
        System.out.println(" 4 -> Quit ");

        switch (scanner.nextInt()) {
            case 1 -> put();
            case 2 -> findAndTake(true);
            case 3 -> findAndTake(false);
            case 4 -> System.exit(0);
        }
        menu();
    }

    private void put() {
        for (Integer room : library.keySet()) {
            for (Integer shelf : library.get(room).keySet()) {
                for (Integer cell : library.get(room).get(shelf).keySet()) {
                    Book bookValue = library.get(room).get(shelf).get(cell);
                    if (bookValue == null) {
                        library.get(room).get(shelf).put(cell, new Book());
                        System.out.printf(" Книга расположена : \n комната - %d, стелаж - %d, место - %d%n", room, shelf, cell);
                        return;
                    }
                }
            }
        }
        System.out.println(" Нет свободных мест ");
    }

    private void findAndTake(Boolean take) {
        boolean isFind = false;
        System.out.println(" Введите данные для поиска Книги -> Автор , Название , Жанр , Год ");
        String text = scanner.next();
        for (Integer room : library.keySet()) {
            for (Integer shelf : library.get(room).keySet()) {
                for (Integer cell : library.get(room).get(shelf).keySet()) {
                    Book bookValue = library.get(room).get(shelf).get(cell);
                    if (bookValue != null) {
                        if (bookValue.getAuthor().startsWith(text) ||
                                bookValue.getTitle().startsWith(text) ||
                                bookValue.getGenre().startsWith(text) ||
                                bookValue.getYear().startsWith(text)) {
                            System.out.println(" Книга найдена -> ");
                            bookValue.info();
                            System.out.printf(" Книга расположена : \n комната - %d, стелаж - %d, место - %d%n", room, shelf, cell);
                            System.out.println(" * * * * * * * * * * * * * * ");
                            isFind = true;
                            if (take) {
                                int answer;
                                do {
                                    System.out.println(" Хотите взять эту книгу? 1-Да // 2-Нет ");
                                    answer = scanner.nextInt();
                                } while (answer < 1 || answer > 2);
                                if (answer == 1) {
                                    library.get(room).get(shelf).put(cell, null);
                                    System.out.println(" Возьмите книгу. До встречи! ");
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!isFind) System.out.println(" Книга с такими параметрами не найдена ");
    }

//    public void explanation(){
//        HashMap<Integer, HashMap<Integer, HashMap<Integer, Book>>> bigLibrary = new HashMap<>();
//        for (int i = 0; i < 10; i++){
//            HashMap<Integer, HashMap<Integer, Book>> room = new HashMap<>();
//            for (int i = 0; i < 10; i++){
//                HashMap<Integer, Book> shelf = new HashMap<>();
//                for (int i = 0; i < 10; i++){
//                    Book book = new Book();
//                    shelf.put(i, book);
//                }
//                room.put(i, shelf);
//            }
//            bigLibrary.put(i, room);
//        }
//
//        HashMap<Integer, HashMap<Integer, Book>> room = new HashMap<>();
//        for (int i = 0; i < 10; i++){
//            HashMap<Integer, Book> shelf = new HashMap<>();
//            for (int i = 0; i < 10; i++){
//                Book book = new Book();
//                shelf.put(i, book);
//            }
//            room.put(i, shelf);
//        }
//
//        HashMap<Integer, Book> shelf = new HashMap<>();
//        for (int i = 0; i < 10; i++){
//            Book book = new Book();
//            shelf.put(i, book);
//        }
//    }

}
