package oop.complex.tonometr;

public class Pump {
    private Mangetta mangetta;

    public void connectMangetta(Mangetta mangetta){
        this.mangetta=mangetta;
    }

    public int pumpUp() {
        if (mangetta != null) {
            System.out.println(" Насос сигнал Манжете ");
            mangetta.scanPressure();
            return 0;
        } else {
            return -1;
        }
    }
}
