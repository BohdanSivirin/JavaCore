package oop.generics.newGenerics;

public class GenericChild<T,R> extends GenericFirst<T> {
    private R field2;

    public GenericChild(R field2, T value) {
        super(value);
        this.field2 = field2;
    }

    public void setField2(R field2) {
        this.field2 = field2;
    }

    public R getField2() {
        return field2;
    }

    public String toString() {
        return " generic child field2: " + field2;
    }
}
