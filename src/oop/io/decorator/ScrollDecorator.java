package oop.io.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ScrollDecorator extends WidgetDecorator {
    private final ArrayList<String> type = new ArrayList<>();


    public ScrollDecorator(IWidget iWidget) {
        super(iWidget);
        Collections.addAll(type, "vertical", "horizontal", "all");

    }

    private void setType() {
        System.out.println("Current scroll is drawn" + type.get(new Random().nextInt(type.size())));
    }

    public void draw() {
        super.draw();
        setType();
    }

}
