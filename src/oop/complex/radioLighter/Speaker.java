package oop.complex.radioLighter;

public class Speaker {
    private int speakerVolume = 50; // %

    public void play(String info) {
        System.out.println(" Speaker is playing " + info + " on volume " + speakerVolume);
    }

    public void increaseVolume() {
        if (speakerVolume <= 100) {
            speakerVolume = speakerVolume + 10;
        }
        System.out.println(" Speakers volume is higher " + speakerVolume);
    }

    public void decreaseVolume() {
        if (speakerVolume >= 0) {
            speakerVolume = speakerVolume - 10;
        }
        System.out.println(" Speakers volume is lower " + speakerVolume);
    }

}
