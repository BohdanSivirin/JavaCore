package oop.io.decorator;

public class Button implements IWidget {
    private final String type = "Primary";

    @Override
    public void draw() {
        System.out.println("Button drawn");
    }
}
