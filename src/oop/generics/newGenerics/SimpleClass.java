package oop.generics.newGenerics;

public class SimpleClass extends GenericChild<String, Integer> {
    private int number;
    private String name;

    public SimpleClass(int number, String name, String value1, Integer value2) {
        super(value2, value1);
        this.name = name;
        this.number = number;
    }

}
