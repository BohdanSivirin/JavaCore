package oop.generics.test;

public class ParentClass<R> {
    private R field;

    public ParentClass(R value) {
        this.field = value;
    }

    void setField(R value) {
        field = value;
    }
}
