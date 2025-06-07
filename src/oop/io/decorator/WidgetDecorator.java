package oop.io.decorator;

public abstract class WidgetDecorator implements IWidget {
    private IWidget iWidget;

    public WidgetDecorator(IWidget iWidget) {
        this.iWidget = iWidget;
    }

    public void setNewIWidget(IWidget iWidget1) {
        this.iWidget = iWidget1;
    }


    public void draw() {
        iWidget.draw();
    }
}
