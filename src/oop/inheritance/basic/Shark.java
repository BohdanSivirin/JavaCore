package oop.inheritance.basic;

public abstract class Shark extends Fish {
    private boolean isHasElectroreceptorOrgans;


    public Shark(double weight, int age, int sleepingTime, boolean isHasElectroreceptorOrgans) {
        super(weight, age, sleepingTime, true, true);
        this.isHasElectroreceptorOrgans = isHasElectroreceptorOrgans;
    }

    public boolean isHasElectroreceptorOrgans() {
        return isHasElectroreceptorOrgans;
    }

    public void info() {
        super.info();
        System.out.println(" Shark is Has Electroreceptor Organs : " + isHasElectroreceptorOrgans);
    }

    public String toString() {
        return super.toString() + " Shark is Has Electroreceptor Organs : " + isHasElectroreceptorOrgans;
    }
}
