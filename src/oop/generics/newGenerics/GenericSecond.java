package oop.generics.newGenerics;

public class GenericSecond<T, R> {
    private T field1;
    private R field2;

    public GenericSecond(T field1, R field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public void setField1(T field1) {
        this.field1 = field1;
    }

    public void setField2(R field2) {
        this.field2 = field2;
    }

    public T getField1() {
        return field1;
    }

    public R getField2() {
        return field2;
    }

    public String toString() {
        return "generic second field1: " + field1 + " generic second field2: " + field2;
    }

}
