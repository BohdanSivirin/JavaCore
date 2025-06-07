package oop.complex.radioLighter;

public class Lamp {
    private boolean isOn;
    private int maxPower; // %
    private double currentPower;

    public Lamp(int maxPower) {
        this.maxPower = maxPower;
        this.currentPower = maxPower * 0.6;
    }

    public void onOff() {
        System.out.println((isOn = !isOn) ? " Лампа включена, текущая мощность " + currentPower : " Лампа выключена ");

//        if (isOn) {
//            isOn = false;
//            System.out.println(" Лампа выключена ");
//        } else if (!isOn) {
//            isOn = true;
//            System.out.println(" Лампа включена, текущая мощность " + currentPower);
//        }
    }

    public void increasePower() {
        if ((currentPower <= maxPower) && (isOn)) {
            currentPower = currentPower + 5;
            System.out.println(" Мощность увеличена. Текущая мощность " + currentPower);
        } else System.out.println(" Нельзя увеличить мощность. Включите лампу ");
    }

    public void dicreasePower() {
        if ((currentPower >= 0) && (isOn)) {
            currentPower = currentPower - 5;
            System.out.println(" Мощность уменьшена. Текущая мощность " + currentPower);
        } else System.out.println(" Нельзя уменьшить мощность. Включите лампу ");
    }

}
