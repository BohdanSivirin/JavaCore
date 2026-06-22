package oop.inheritance.basic;

public abstract class Ostrich extends Bird {
    private boolean isBuryHeadInTheSand;

    public Ostrich(boolean iBuryHeadInTheSand) {
        super(65, 8, 4, false, false);
        this.isBuryHeadInTheSand = iBuryHeadInTheSand;
    }

    public boolean isBuryHeadInTheSand() {
        return isBuryHeadInTheSand;
    }

    public void info() {
        super.info();
        System.out.println(" Ostrich is Bury Head In The Sand : " + isBuryHeadInTheSand);
    }

}
