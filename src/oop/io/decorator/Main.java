package oop.io.decorator;

public class Main {
    public static void main(String[] args) {
        ScrollDecorator scroll = new ScrollDecorator(new TextArea());
        IWidget widget = new BorderDecorator(new ShadeDecorator(scroll));
        widget.draw();
        System.out.println("widget before" + widget);

        scroll.setNewIWidget(new Combobox());

        System.out.println("widget after" + widget);
        System.out.println("* * * *");
        widget.draw();

//        IWidget widget1 = new BorderDecorator(new ShadeDecorator(new ScrollDecorator(new Button())));


    }
}
