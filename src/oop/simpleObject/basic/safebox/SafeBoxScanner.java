package oop.simpleObject.basic.safebox;

import java.util.Scanner;

public class SafeBoxScanner {
    private String password; //создается при закрытии, используется при открытии // 4 символа
    private String pin = "1111"; // используется если сейф заблокирован
    private int maxAttempts = 3; // кол-во попыток до блока
    private boolean isOpen = true; // открыт / закрыт
    private boolean isSafeLocked; // заблокирован / не заблокирован
    Scanner scanner = new Scanner(System.in);

    public SafeBoxScanner() {
        menu();
    }

    private void setPin() {
        System.out.println("Введите старый ПИН");
        String oldPin = scanner.nextLine();
        if (oldPin.length() != 4) {
            System.out.println("Смена ПИН невозможна, некорректная длинна ПИН");
            return;
        }

        if (!this.pin.equals(oldPin)) {
            System.out.println("Смена ПИН невозможна,невалидный старый ПИН");
            return;
        }

        System.out.println("Введите новый ПИН");
        String newPin = scanner.nextLine();
        if (!isOpen) {
            System.out.println("Смена ПИН невозможна, откройте сейф");
            return;
        }

        if (newPin.length() != 4) {
            System.out.println("Смена ПИН невозможна, некорректная длинна  ПИН");
            return;
        }
        if (this.pin.equals(oldPin)) {
            this.pin = newPin;
            System.out.println("Новый ПИН = " + newPin);
        } else System.out.println("Смена ПИН невозможна, невалидный старый ПИН");
    }

    private void close() {
        System.out.println(" Чтобы закрыть -> Введите пароль");
        String enteredPassword = scanner.nextLine();

        if (!isOpen) {
            System.out.println("Сейф уже закрыт");
            return;
        }

        if (enteredPassword.length() != 4) {
            System.out.println("Некорретный пароль. Введите 4 символа");
            return;
        }
        isOpen = false;
        System.out.println("Сейф закрыт. Пароль = " + enteredPassword);
        this.password = enteredPassword;
    }

    private void open() {
        System.out.println(" Чтобы открыть  -> Введите пароль");
        String password = scanner.nextLine();

        if (isOpen) {
            System.out.println("Сейф уже открыт");
            return;
        }

        if (password.length() != 4) {
            System.out.println("Некорретный пароль. Введите 4 символа");
            return;
        }
        if (isSafeLocked && !pin.equals(password)) {
            System.out.println("Неверный ПИН");
            return;
        }
        if (isSafeLocked && pin.equals(password)) {
            System.out.println("Сейф открыт");
            isSafeLocked = false;
            maxAttempts = 3;
            isOpen = true;
            return;
        }
        if ((this.password.equals(password)) || (this.pin.equals(password))) {
            System.out.println("Сейф открыт");
            isOpen = true;
            maxAttempts = 3;
            return;
        }

        maxAttempts = maxAttempts - 1;
        System.out.println("Неверный пароль. Осталось " + maxAttempts + " попытки");
        if (maxAttempts == 0) {
            isSafeLocked = true;
            System.out.println("Сейф заблокирован, позвоните администратору или введите ПИН");
        }
    }

    private void menu() {
        while (true) {
            if (!isOpen) {
                open();
            } else {
                System.out.println("Хочешь сменить пин - 1 или закрыть - 2");
                int a = Integer.parseInt(scanner.nextLine());
                if (a != 1) {
                    close();
                } else setPin();
            }
        }
    }

//    private void menu() {
//        for (; ; ) {
//            System.out.println("1 - открыть сейф");
//            System.out.println("2 - закрыть сейф");
//            System.out.println("3 - сет новый пин");
//            System.out.println("5 - выйти ");
//            int a = Integer.parseInt(scanner.nextLine());
//            switch (a) {
//
//                case 1 -> open();
//                case 2 -> close();
//                case 3 -> setPin();
//                case 4 -> {
//                    return;
//                }
//            }
//        }
//    }
}

