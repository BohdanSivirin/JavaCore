package oop.simpleObject.basic.blander;

public class Blander {
    private boolean isOn;
    private int maxSpeed;
    private int currentSpeed;
    private boolean isCupOn = true;

    public Blander(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Blander(int maxSpeed, boolean isCupOn) {
        this.maxSpeed = maxSpeed;
        this.isCupOn = isCupOn;
    }

//    public void info() {
//        System.out.println("isOn = " + isOn);
//        System.out.println("maxSpeed = " + maxSpeed);
//        System.out.println("currentSpeed = " + currentSpeed);
//        System.out.println("isCupOn = " + isCupOn);
//    }

    public void switchOn() {
        if (isOn) {
            System.out.println("Блендер уже включен");
        } else if (isCupOn) {
            isOn = true;
            System.out.println("Блендер включился!");
        } else System.out.println("Нельзя включить Блендер без чаши, наденьте чашу");
    }

    public void switchOff() {
        if (currentSpeed != 0) {
            System.out.println("Нельзя выключить блендер во время работы, снизьте скорость");
        } else {
            isOn = false;
            System.out.println("Блендер выключился!");
        }
    }
//
//    public boolean isCupOn() {
//        return isCupOn;
//    }

    public void putCupOn() {
        if (isCupOn) {
            System.out.println("Чаша уже надета");
        } else {
            isCupOn = true;
            System.out.println("Чаша надета");
        }
    }

    public void putCupOff() {
        if (isOn) {
            System.out.println("Нельзя снять чашу пока блендер включен, выключите блендер");
        } else if (!isCupOn) {
            System.out.println("Чаша уже снята");
        } else {
            isCupOn = false;
            System.out.println("Чаша снята");
        }
    }

//    public int getCurrentSpeed() {
//        System.out.println("Текущая скорость = " + currentSpeed);
//        return currentSpeed;
//    }

    public void setCurrentSpeed(int initCurrentSpeed) {
        if (!isCupOn) {
            System.out.println("Нельзя изменить скорость пока чаша не надета, сначала наденьте чашу");
        } else if (!isOn) {
            System.out.println("Нельзя изменить скорость пока, блендер не включен");
        } else if (initCurrentSpeed >= 0 && initCurrentSpeed <= maxSpeed) {
            currentSpeed = initCurrentSpeed;
            System.out.println("Новая скорость = " + currentSpeed);
        } else System.out.println("Некорректная скорость, введите другое число");
    }

}
