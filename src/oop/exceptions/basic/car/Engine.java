package oop.exceptions.basic.car;

import java.util.Random;

public class Engine {
    private final boolean isStartCorrectly;
    private boolean isStart;
    private int turnovers;

    public Engine(int turnovers) {
        int error = new Random().nextInt(101);
        isStartCorrectly = error > 5;
        this.turnovers = turnovers;
        isStart = false;
    }

    public void startEngine() throws EngineException {
        if (!isStartCorrectly) {
            throw new EngineException("Error: Engine isn't start correctly");
        }
    }

    public void addTurnovers(int value) throws EngineException {
        if (!isStart) {
            throw new EngineException("Error: Engine is off");
        }
        turnovers = turnovers + value;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setStart(boolean start) {
        isStart = start;
    }
}
