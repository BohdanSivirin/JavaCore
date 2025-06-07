package oop.exceptions.basic;

public class First {
    public void methodFirst() throws MyHandledException {

        try {
            Second second = new Second();
            second.methodTwo();
            int[] array = new int[5];
            System.out.println(array[5]);
            System.out.println("after method first");
        } finally {
            important();
        }
//        catch (ArrayIndexOutOfBoundsException e){
//            System.out.println(" catch ArrayIndexOutOfBoundsException in method first");
//        }

        System.out.println("finish method first");
    }

    private void important() {
        System.out.println(" Important logic ");
    }
}
