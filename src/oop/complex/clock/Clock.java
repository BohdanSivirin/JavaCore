package oop.complex.clock;

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
        mechanism = new Mechanism(this, battery);
        mechanism.work();
    }

    public void print() {
        System.out.println((hours <= 9 ? "0" + hours : hours + ":"
                + (min <= 9 ? "0" + min : min + ":" + (sec <= 9 ? "0" + sec : sec))));
    }

    public int getHours() {
        return hours;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }
}
