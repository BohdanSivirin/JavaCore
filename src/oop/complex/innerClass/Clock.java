package oop.complex.innerClass;

public class Clock {
    private int hours;
    private int min;
    private int sec;
    private Battery battery;
    private Mechanism mechanism;


    public Clock(int hours, int min, int sec) {
        this.hours = hours;
        this.min = min;
        this.sec = sec;
        battery = new Battery(5);
        mechanism = new Mechanism();
        mechanism.work();
    }

    private void print() {
        System.out.println((hours <= 9 ? "0" + hours : hours + ":"
                + (min <= 9 ? "0" + min : min + ":" + (sec <= 9 ? "0" + sec : sec))));
    }

    public class Mechanism {

        public void work() {
            int countHours = 0;
            while (battery.getCurrentVolume() >= 0) {
                sec = sec + 1;
                if (sec == 60) {
                    sec = 0;
                    min = min + 1;
                    if (min == 60) {
                        min = 0;
                        hours = hours + 1;
                        countHours++;
                        if (hours == 24) {
                            hours = 0;
                        }
                    }
                }
                if (countHours == 4) {
                    battery.decreaseBatteryLvl();
                    countHours = 0;
                }
                print();
            }
        }
    }
}
