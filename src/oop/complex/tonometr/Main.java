package oop.complex.tonometr;

public class Main {
    public static void main(String[] args) {
        Tonometr tonometr = new Tonometr();
        Mangetta mangetta = new Mangetta();
        tonometr.connectMangetta(mangetta);
        Arm arm = new Arm(120, 80, 60);
        mangetta.connectArm(arm);
        tonometr.start();
        System.out.println(" *** ");
        tonometr.connectMangetta(null);
        tonometr.start();

    }
}
