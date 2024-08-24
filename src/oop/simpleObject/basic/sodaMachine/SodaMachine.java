package oop.simpleObject.basic.sodaMachine;

public class SodaMachine {
    private int maxVolumeWater = 10000; // ml объем бочки с водой
    private int currentVolumeWater = 10000;
    private int maxVolumeSyrup = 3000; // ml объем бочки с сиропом
    private int currentVolumeSyrup = 3000;
    private int maxWeightMoneyReceiver = 34; // макс монет
    private int currentWeightMoneyReceiver;
    private int coinNominal1 = 1; // вес и номинал = 1
    private int coinNominal3 = 3; // вес и номинал = 3

    public void getCurrentStateSodaMachine() {
        System.out.println("Текущий уровень воды = " + currentVolumeWater + " из " + maxVolumeWater);
        System.out.println("Текущий уровень сиропа = " + currentVolumeSyrup + " из " + maxVolumeSyrup);
        System.out.println("Текущий кол-во монет = " + currentWeightMoneyReceiver + " из " + maxWeightMoneyReceiver);
    }

    public void payForDrink(int coin) {
        if (coin != coinNominal1 && coin != coinNominal3) {
            System.out.println("Номинал монеты не подходит. Внесите монеты = " + coinNominal1 + " или " + coinNominal3);
            return;
        }
        if (currentWeightMoneyReceiver == maxWeightMoneyReceiver) {
            System.out.println("Нет места для монет. Снимите деньги");
            return;
        }
        if (coin == coinNominal3 && currentWeightMoneyReceiver > maxWeightMoneyReceiver - coinNominal3) {
            System.out.println("Номинал монеты " + coinNominal3 + "не подходит. " + "Внесите монету = " + coinNominal1);
            return;
        }
        if (coin == coinNominal1 && currentVolumeWater > 200) {
            System.out.println("Оплата успешна. Ваш напиток -> Вода ");
            currentWeightMoneyReceiver = currentWeightMoneyReceiver + coinNominal1;
            currentVolumeWater = currentVolumeWater - 200;
            return;
        }
        if (coin == coinNominal3 && currentVolumeSyrup > 50 && currentVolumeWater > 150) {
            System.out.println("Оплата успешна. Ваш напиток -> Содовая ");
            currentWeightMoneyReceiver = currentWeightMoneyReceiver + coinNominal3;
            currentVolumeWater = currentVolumeWater - 150;
            currentVolumeSyrup = currentVolumeSyrup - 50;
        }
    }

    public void receiveMoneySodaMashine() {
        System.out.println("Снято кол-во монет = " + currentWeightMoneyReceiver);
        currentWeightMoneyReceiver = 0;
    }

}
