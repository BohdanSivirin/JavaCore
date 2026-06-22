package oop.complex.clock;

public class Mechanism {
    private Clock clock;
    private Battery battery;

    public Mechanism(Clock clock, Battery battery) {
        this.clock = clock;
        this.battery = battery;
    }

    public void work() {
        int countHours = 0;
        while (battery.getCurrentVolume() >= 0) {
            clock.setSec(clock.getSec() + 1);
            if (clock.getSec() == 60) {
                clock.setSec(0);
                clock.setMin(clock.getMin() + 1);
                if (clock.getMin() == 60) {
                    clock.setMin(0);
                    clock.setHours(clock.getHours() + 1);
                    countHours++;
                    if (clock.getHours() == 24) {
                        clock.setHours(0);
                    }
                }
            }
            if (countHours == 4) {
                battery.decreaseBatteryLvl();
                countHours = 0;
            }
            clock.print();
        }
    }

//
//    public void print() {
//        int countHours = 0;
//        int startMin = min;
//        int startSec = sec;
//        if (mechanism.getIsWork()) {
//
//            for (int recharge = 0; battery.getCurrentVolume() > recharge; sec++) {
//                if (sec == 60) {
//                    min++;
//                    sec = 0;
//                    if (min == 60) {
//                        min = 0;
//                        hours++;
//                        countHours++;
//                        if (hours == 24) {
//                            hours = 0;
//                        }
//                    }
//                }
//                if (countHours == 4 && startMin == min && startSec == sec) {
//                    battery.decreaseBatteryLvl();
//                    countHours = 0;
//                    if (battery.getCurrentVolume() == 0) {
//                        mechanism.onOffMechanism();
//                        return;
//                    }
//                }
//                System.out.println((hours <= 9 ? "0" + hours : hours) + ":"
//                        + (min <= 9 ? "0" + min : min) + ":" + (sec <= 9 ? "0" + sec : sec));
//            }
//        } else {
//            System.out.println(" Mechanism doesn't work ");
//        }
//    }


}
