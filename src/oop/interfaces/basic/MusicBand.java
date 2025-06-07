package oop.interfaces.basic;

import java.util.ArrayList;

public class MusicBand {
    private final ArrayList<Musician> musicBand = new ArrayList<>();

    public void addMusician(Musician musician) {
        musicBand.add(musician);
        System.out.println(" Musician" + musician + " is added to band ");
    }

    public void perform() {
        for (int i = 0; i < musicBand.size(); i++) {
            musicBand.get(i).playMusic();
        }
    }
}
