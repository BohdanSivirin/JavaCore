package oop.io.decorator;

import java.util.ArrayList;
import java.util.Collections;

public class ShadeDecorator extends WidgetDecorator {
    private final ArrayList<Integer> transparency = new ArrayList<>();
    private int defaultTransparency;

    public ShadeDecorator(IWidget iWidget) {
        super(iWidget);
        Collections.addAll(transparency, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        defaultTransparency = transparency.get(transparency.size() - 1);
    }

    public void setDefaultTransparency(int index) {
        defaultTransparency = transparency.get(index);
        System.out.println("Set default transparency: " + defaultTransparency);
    }

    private void drawShade() {
        System.out.println("Shade with this transparency is drawn");
    }

    public void draw(){
        super.draw();
        drawShade();
    }

}
