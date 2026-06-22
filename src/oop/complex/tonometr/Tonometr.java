package oop.complex.tonometr;

public class Tonometr {
    private Pump pump;
    private Display display;
    private Battery battery;
    private Controller controller;
    private Mangetta mangetta;

    public Tonometr() {
        this.pump = new Pump();
        this.display = new Display();
        this.controller = new Controller();
        this.battery = new Battery(47, controller);
    }

     void connectMangetta(Mangetta mangetta) {
        if (mangetta == null) {
            display.print(" Mangetta is not connected ");
            this.mangetta = mangetta;
            pump.connectMangetta(mangetta);
        } else {
            this.mangetta = mangetta;
            mangetta.connectController(controller);
            pump.connectMangetta(mangetta);
        }
    }

    public void start() {
        controller.pump();
    }


    public class Controller {

        public void pump() {
            System.out.println(" Контроллер сигнал 1 на насос ");
            int isMangettaConnect = pump.pumpUp();

            if (isMangettaConnect == -1) {
                display.print(" Mangetta is not connected ");
                return;
            }
            battery.decreaseCurrentLevel(3);
            display.print(" battery level : " + battery.getCurrentLevel() + " % ");
        }

        public void analysePressure(int upPressure, int downPressure, int pulse) {
            if (upPressure == 0 && downPressure == 0 && pulse == 0) {
                display.print(" Hand is not found ");
                return;
            }
            display.print(" << Info >> ");
            display.print(" up pressure : " + upPressure);
            display.print(" down pressure : " + downPressure);
            display.print(" pulse : " + pulse);
        }

    }
}
