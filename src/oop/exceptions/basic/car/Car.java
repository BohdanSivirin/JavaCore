package oop.exceptions.basic.car;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Car {
    private final FuelTank fuelTank;
    private final Accumulator accumulator;
    private final CandleBox candleBox;
    private final Engine engine;
    private final Display display;
    private Scanner scanner;

    public Car() {
        this.fuelTank = new FuelTank();
        this.accumulator = new Accumulator();
        this.candleBox = new CandleBox(16);
        this.engine = new Engine(2500);
        this.display = new Display();
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        try {
            startProgram();
        } catch (InputMismatchException e) {
            display.print("Incorrect scanner value");
            scanner = new Scanner(System.in);
        } catch (FuelException | AccumulatorException | EngineException | CandleBoxException | CandleException e) {
            display.print(e.getMessage());
        }
        menu();
    }

    private void startProgram() throws CandleBoxException, FuelException, EngineException, AccumulatorException, CandleException {
        display.print("Chose option : 1 - start | 2 - accelerate | 3 - exit");
        switch (scanner.nextInt()) {
            case 1 -> start();
            case 2 -> accelerate();
            case 3 -> System.exit(0);
        }
    }

    private void start() throws FuelException, AccumulatorException, EngineException, CandleBoxException {
        display.print("Process: Checking car systems ..... ");
        fuelTank.pumpFuel(0.75);
        display.print("FuelTank and Pump -> in good condition");
        accumulator.discharge(15);
        display.print("Accumulator -> in good condition");

        candleBox.checkAllCandlesInBox();
        display.print("More than half candles -> in good condition");
        engine.startEngine();
        display.print("Check is finished -> Engine is starting");
        engine.setStart(true);
    }

    private void accelerate() throws EngineException {
        engine.addTurnovers(1500);
        display.print("Current turnovers: " + engine.getTurnovers());

    }

    static class Display {
        private void print(String t) {
            System.out.println(t);
        }
    }
}
