package oop.complex.blander;

public class Main {
    public static void main(String[] args) {
        Blander blander = new Blander(5);
        blander.changeSpeed(1);
        blander.installCup(new Cup(8));
        Cup cupoff = blander.takeOffCup();
        blander.installCup(cupoff);
        blander.plugInOut();
        blander.changeSpeed(2);
        Cup cupOff = blander.takeOffCup();
        System.out.println(cupOff);


    }
}
