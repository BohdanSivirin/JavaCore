package oop.interfaces.sort.multySort.phones;

public class Phone implements Comparable<Phone> {
    private String brand;
    private String model;
    private int price;
    private int screenSize;
    private int memory;
    private long serialNumber;
    private String color;

    public Phone(String brand, String model, int price, int screenSize, int memory, long serialNumber, String color) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.screenSize = screenSize;
        this.memory = memory;
        this.serialNumber = serialNumber;
        this.color = color;
    }

    public String toString() {
        return "\nPhone: brand " + brand +  ", model " + model + ", screen " + screenSize + ", memory " + memory + ", price " + price;
    }


    @Override
    public int compareTo(Phone o) {
        if (brand.compareTo(o.brand) != 0) {
            return brand.compareTo(o.brand);
        } else if (model.compareTo(o.model) != 0) {
            return model.compareTo(o.model);
        } else if ((o.screenSize - screenSize) != 0) {
            return o.screenSize - screenSize;
        } else if ((memory - o.memory) != 0) {
            return memory - o.memory;
        } else {
            return price - o.price;
        }
    }
}


