package oop.generics.old;

public class OldGeneric {
    private Object field1;

    OldGeneric(Object field1) {
        this.field1 = field1;
    }

    public void setField1(Object o) {
        this.field1 = o;
    }
    public String toString(){
        return "field1: " + field1;
    }

}
