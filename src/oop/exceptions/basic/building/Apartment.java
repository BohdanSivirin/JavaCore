package oop.exceptions.basic.building;


public class Apartment {
    private final String owner;
    private final int flatNumb;

    public Apartment(String owner, int flatNumb) {
        this.owner = owner;
        this.flatNumb = flatNumb;
    }

    void call() throws BuildingException {
        throw new BuildingException(" [apartment] = " + flatNumb + " [owner] = " + owner + " received the call");
    }

    @Override
    public String toString() {
        return "\n [owner] = " + owner + " [apartment] = " + flatNumb;
    }

    public int getFlatNumb() {
        return flatNumb;
    }
}
