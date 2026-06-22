package oop.generics.newGenerics;

public class Box<T> {
    private T thing;


    void add(T thing) {
        this.thing = thing;
    }

    public T getThing() {
        T buffer = thing;
        thing = null;
        return buffer;
    }
}
