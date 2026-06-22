package oop.complex.waterSystem;

public class WaterTank {
    private int maxVolume = 100;
    private int currentVolume = 15;
    private Controller controller = new Controller();

    public void setAddedCurrentVolume(int value) {
        currentVolume = currentVolume + value;
    }

    public void setLeftCurrentVolume(int value) {
        currentVolume = currentVolume - value;
        controller.initProcess();
    }

    public void connectPomp(Pump pump) {
       controller.connectPump(pump);
    }

//    // Метод для получения контроллера
//    public Controller getController() {
//        return controller;
//    }

    private class Controller {
        private Pump pump;
        private int minVolume = 3;

        public void connectPump(Pump pump) {
            this.pump = pump;
        }

        public void initProcess() {
            if (currentVolume < minVolume) {
                System.out.println(" Init process ");
                int amount = maxVolume - currentVolume;
                pump.fillWaterTank(amount);
            }
        }
    }
}