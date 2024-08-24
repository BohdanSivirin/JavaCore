package oop.simpleObject.basic.massage;

public class Main {
    public static void main(String[] args) {
        Massage massage = new Massage();
        massage.switchOn();
        massage.clickButtonRotate();
        massage.clickButtonHeat();
        massage.clickButtonSpeed(1);
        massage.clickButtonSpeed(600);
        massage.clickButtonSpeed(4);
        massage.clickButtonRotate();
        massage.clickButtonHeat();
        massage.switchOn();
        massage.switchOff();
        massage.clickButtonHeat();
        massage.clickButtonRotate();
    }
}
