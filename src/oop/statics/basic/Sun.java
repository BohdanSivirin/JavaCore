package oop.statics.basic;

public class Sun {
    private final int size = 9999;
    private String colour = "Yellow";

    void shine() {
        System.out.println(" Sun " + colour + " shine ");
    }

    void changeColour(String colour) {
        this.colour = colour;
    }


}
