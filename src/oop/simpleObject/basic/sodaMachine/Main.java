package oop.simpleObject.basic.sodaMachine;

public class Main {
    public static void main(String[] args) {
        SodaMachine machine = new SodaMachine();
        machine.getCurrentStateSodaMachine();
        machine.receiveMoneySodaMashine();
        machine.payForDrink(3);
        machine.getCurrentStateSodaMachine();
        machine.payForDrink(1);
        machine.getCurrentStateSodaMachine();
        machine.payForDrink(3);
        machine.payForDrink(1);
        machine.getCurrentStateSodaMachine();
        machine.receiveMoneySodaMashine();
        machine.getCurrentStateSodaMachine();


    }
}
