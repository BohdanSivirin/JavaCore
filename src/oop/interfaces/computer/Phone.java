package oop.interfaces.computer;

public class Phone implements Usb {
    private String name;
    private int serialNumb;

    public Phone(String name, int serialNumb) {
        this.name = name;
        this.serialNumb = serialNumb;
    }

    @Override
    public String getData() {
        return getClass().getSimpleName() + " name: " + name + " serial number: " + serialNumb;
    }
}
