package oop.generics.test;

public class FirstClass extends ParentClass<String> {

    public FirstClass(String t) {
        super(t);
        setField("t2");
    }
}
