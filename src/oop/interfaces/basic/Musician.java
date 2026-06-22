package oop.interfaces.basic;

import java.util.ArrayList;

public interface Musician {
    String INSTRUMENT_1 = "Balalaika";
    String INSTRUMENT_2 = "Piano";
    String INSTRUMENT_3 = "Guitar";

    void playMusic();

    default void repetition() {
        System.out.println("Musician is preparing");
    }

    static Musician loudest(ArrayList<Musician> musicians) {
        int index = 0;
        int buffer = 0;
        for (int i = 0; i < musicians.size(); i++) {
            if (musicians.get(i) instanceof Barber barber) {
                if (barber.getVoiceLevel() > buffer) {
                    buffer = barber.getVoiceLevel();
                    index = i;
                }
            }
        }
        return musicians.get(index);
    }

}
