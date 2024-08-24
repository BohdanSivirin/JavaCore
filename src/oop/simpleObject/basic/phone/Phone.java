package oop.simpleObject.basic.phone;

public class Phone {

    private int tarifForCall = 2;// 1 min = 2 dollars
    private double simCard = 10.40; // amount of money on the phone
    private int battery = 29;// 29 % charge in

    private void checkIsOn() {
        if (battery < 3) {
            System.out.println(" Телефон выключен");
            return;
        }
        System.out.println(" Телефон включен ");
    }

    private void makeCall() {
        if (battery < 3) {
            System.out.println(" Позвонить нельзя, маленький заряд баттареи = " + battery);
            return;
        }
        if (simCard < tarifForCall) {
            System.out.println(" Недостаточно средств на счету = " + simCard);
            return;
        }

    }


    private void putMoney() {

    }

    private void chargePhone() {

    }


}
