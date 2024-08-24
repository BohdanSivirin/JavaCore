package oop.simpleObject.basic.safebox;

public class Main {
    public static void main(String[] args) {
        SafeBox box = new SafeBox();
        box.close("123%");
        box.close("as@#");
        box.open("dfr4#$@");
        box.open("dfr4#$@");
        box.open("dfr4#$@sadfasf");
        box.open("123%");
        box.open("***");
        box.open("**243*");
        box.open("1111");
        box.close("123%");
        box.setPin("1111", "7894");
        box.open("1111");
        box.setPin("1111", "7894");




    }
}
