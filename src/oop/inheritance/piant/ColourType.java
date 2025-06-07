package oop.inheritance.piant;

public enum ColourType {
    WHITE(255, 255, 255),
    BLACK(0, 0, 0),
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    GREEN(0, 128, 0);

    private int red;
    private int green;
    private int blue;

    ColourType(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

}
