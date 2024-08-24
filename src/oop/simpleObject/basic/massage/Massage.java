package oop.simpleObject.basic.massage;

public class Massage {
    private boolean on;
    private boolean rotateRight = true;
    private int speedMax = 3;
    private boolean heat = true;

    public void switchOn() {
        if (on) {
            System.out.println("Массаж уже включен, разве вы не заметили)");
            return;
        }

        on = true;
        System.out.println("Массажер = включился");
        System.out.println("Вращение = вправо");
        System.out.println("Скорость = " + speedMax);
        System.out.println("Подогрев = включен");
    }

    public void switchOff() {
        on = false;
        System.out.println("Массажер - вылючился");
    }

    public void clickButtonRotate() {
        if (!on) {
            System.out.println("Без электричества ничего не выйдет дружочек");
            return;
        }
        if (rotateRight) {
            rotateRight = false;
            System.out.println("Вращение - влево");
            return;
        }
        if (!rotateRight) {
            rotateRight = true;
            System.out.println("Вращение - вправо");
        }
    }

    public void clickButtonHeat() {
        if (!on) {
            System.out.println("Без электричества ничего не выйдет дружочек");
            return;
        }
        if (heat) {
            heat = false;
            System.out.println("Подогрев - выклюячен");
            return;
        }
        if (!heat) {
            heat = true;
            System.out.println("Подогрев - включен");
        }
    }

    public void clickButtonSpeed(int speed) {
        if (!on) {
            System.out.println("Без электричества ничего не выйдет дружочек");
            return;
        }
        if (speed > 0 && speed <= speedMax) {
            System.out.println("Новая скорость включена - " + speed);

        } else System.out.println("Это массажер, а не болид, нежнее");
    }
}
