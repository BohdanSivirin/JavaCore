package oop.generics.newGenerics;

public class SimpleClassTwo {
    private String value;

    public SimpleClassTwo(String value) {
        this.value = value;
    }

    public <T> void calculate(T t) {
        System.out.println(t);
    }

}
