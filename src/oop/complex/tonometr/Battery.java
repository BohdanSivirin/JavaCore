package oop.complex.tonometr;

import oop.complex.tonometr.Tonometr.Controller;

public class Battery {
    private int currentLevel;


    public Battery(int currentLevel, Controller controller) {
               this.currentLevel = currentLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void decreaseCurrentLevel(int value) {
        currentLevel = currentLevel - value;

    }

}
