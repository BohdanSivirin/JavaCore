package oop.generics.test;

public class Calculator<R extends Number> {
    private R result;

    public Calculator(R value){
        result = value;
    }

    R getResult(){
        Double value = result.doubleValue()*102.25;
        return (R) value;
    }
}
