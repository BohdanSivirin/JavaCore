package oop.io.decorator;

public class Combobox implements IWidget {
    private final String name = "Menu";
    private boolean isOpen = false;

    @Override
    public void draw() {
        System.out.println("Combo box drawn");
    }
}
