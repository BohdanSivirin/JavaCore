package oop.interfaces.computer;

public class Cow implements Usb {
    private String name;
    private int year;
    private int weight;
    private int amountMilk;
    private int sour;

    public Cow(String name, int year, int weight, int amountMilk, int sour) {
        this.name = name;
        this.year = year;
        this.weight = weight;
        this.amountMilk = amountMilk;
        this.sour = sour;
    }


    @Override
    public String getData() {
        return getClass().getSimpleName() + " name: " + name + " year: " + year + " weight: " + weight + " milk " + amountMilk + " sour " + sour;
    }
}
