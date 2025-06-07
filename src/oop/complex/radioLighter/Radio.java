package oop.complex.radioLighter;

public class Radio {
    private boolean isOn;
    private String[] stationsName;
    private Speaker speaker;
    private int currentStation = 0;

    public Radio() {
        stationsName = new String[]{"rock", "pop", "hit", "rap", "jazz"};
        speaker = new Speaker();
    }

    public void onOff() {
        //(isOn = !isOn) ? speaker.play(stationsName[currentStation]) : " asdadasda ";
        isOn = !isOn;
        if (isOn) speaker.play(stationsName[currentStation]);
        else System.out.println(" ");

    }

    public void nextStation() {
        if (isOn && currentStation != stationsName.length) {
            speaker.play(stationsName[++currentStation]);
        } else if (isOn && currentStation == stationsName.length) {
            currentStation = 0;
            speaker.play(stationsName[currentStation]);
        }
    }

    public void previousStation() {
        if (isOn && currentStation != 0) {
            speaker.play(stationsName[--currentStation]);
        } else if (isOn && currentStation == 0) {
            currentStation = stationsName.length - 1;
            speaker.play(stationsName[currentStation]);
        }
    }

    public void increaseVolume() {
        if (isOn) {
            speaker.increaseVolume();
        }
    }

    public void decreaseVolume() {
        if (isOn) {
            speaker.decreaseVolume();
        }
    }

}
