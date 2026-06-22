package oop.generics.newGenerics;

public class GenericFirst<T> {
    private T field1;

    public GenericFirst(T value) {
        this.field1 = value;
    }

    public void setField1(T value) {
        this.field1 = value;
    }

    public String toString() {
        return "generic first field1: " + field1;
    }

    public T getField1() {
        return field1;
    }
}
