package oop.io.decorator;

public class TextArea implements IWidget {
    private final boolean isSymbolsAvailable = false;
    private final boolean isNumbersAvailable = true;
    private final boolean isTextAvailable = true;


    @Override
    public void draw() {
        System.out.println("Text area drawn");

    }
}
