package oop.generics.newGenerics;

public class GenericClassForInterface<T, P> implements FirstInterface<T> {
    private T hours;
    private P seconds;

    public GenericClassForInterface(T hours, P seconds) {
        this.hours = hours;
        this.seconds = seconds;
    }

    @Override
    public int getValue(T value) {
        if (value instanceof Integer) {
            Integer number = (Integer) value;
            if (number >= 25) {
                return number - 5;
            }
        }
        return -1;
    }

    @Override
    public void calculate(T value) {
        System.out.println("value" + value);
    }

}

