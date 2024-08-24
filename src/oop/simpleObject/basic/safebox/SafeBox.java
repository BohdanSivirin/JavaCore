package oop.simpleObject.basic.safebox;

public class SafeBox {
    private String password; //создается при закрытии, используется при открытии // 4 символа
    private String pin = "1111"; // используется если сейф заблокирован
    private int maxAttempts = 3; // кол-во попыток до блока
    private boolean isOpen = true; // открыт / закрыт
    private boolean isSafeLocked; // заблокирован / не заблокирован

    public void setPin(String oldPin, String newPin) {
        if (!isOpen) {
            System.out.println("Смена ПИН невозможна, откройте сейф");
            return;
        }
        if (oldPin.length() != 4) {
            System.out.println("Смена ПИН невозможна, ведите корректный ПИН");
            return;
        }
        if (newPin.length() != 4) {
            System.out.println("Смена ПИН невозможна, ведите корректный ПИН");
            return;
        }
        if (this.pin.equals(oldPin)) {
            this.pin = newPin;
            System.out.println("Новый ПИН = " + newPin);
        } else System.out.println("Смена ПИН невозможна, ведите корректный ПИН");
    }

    public void close(String password) {
        if (!isOpen) {
            System.out.println("Сейф уже закрыт");
            return;
        }
        if (password.length() != 4) {
            System.out.println("Некорретный пароль. Введите 4 символа");
            return;
        }
        isOpen = false;
        System.out.println("Сейф закрыт. Пароль = " + password);
        this.password = password;
    }

    public void open(String password) {
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
}


