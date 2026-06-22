package oop.interfaces.basic;

public class Barber extends Person implements Musician {
    private final boolean isWorkInBarberShop;
    private final int voiceLevel;
    private String instrument;

    public Barber(int age, String name, boolean isWorkInBarberShop, int voiceLevel, String instrument) {
        super(age, name);
        this.isWorkInBarberShop = isWorkInBarberShop;
        this.voiceLevel = voiceLevel;
        this.instrument = instrument;
    }

    public void cutHair() {
        System.out.println("Barber: " + name + " cut the hear");
    }

    public int getVoiceLevel() {
        return voiceLevel;
    }

    @Override
    public void playMusic() {
        System.out.println("Barber: " + name + " is playing music like Musician Instrument: " + instrument);
    }

    @Override
    public void repetition() {
        Musician.super.repetition();
    }
}
