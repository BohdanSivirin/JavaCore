package oop.io.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BorderDecorator extends WidgetDecorator {
    private final ArrayList<String> type = new ArrayList<>();
    private final ArrayList<String> width = new ArrayList<>();
    private final ArrayList<String> color = new ArrayList<>();
    private String defaultType;
    private String defaultWidth;
    private String defaultColor;

    public BorderDecorator(IWidget iWidget) {
        super(iWidget);
        Collections.addAll(type, "dotted", "dashed", "solid", "double", "groove");
        Collections.addAll(width, "50", "75", "100", "150", "200", "250", "1000");
        Collections.addAll(color, "red", "orange", "yellow", "green", "blue", "indigo", "violet");

    }

    public void setType() {
        defaultType = type.get(new Random().nextInt(type.size()));
        System.out.println("Set new type: " + defaultType);
    }

    public void setWidth() {
        defaultWidth = width.get(new Random().nextInt(width.size()));
        System.out.println("Set new width: " + defaultWidth);
    }

    public void setColor() {
        defaultColor = color.get(new Random().nextInt(color.size()));
        System.out.println("Set new color: " + defaultColor);
    }

    public void draw() {
        super.draw();
        setType();
        setWidth();
        setColor();
    }
}
