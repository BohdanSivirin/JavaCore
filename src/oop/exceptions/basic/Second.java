package oop.exceptions.basic;

public class Second {
    public void methodTwo() throws MyHandledException {
        Third third = new Third();
        third.thirdMethod();
        String t = null;
        System.out.println("length = " + t.length());
    }
}
