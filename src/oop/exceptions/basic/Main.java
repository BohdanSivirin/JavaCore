package oop.exceptions.basic;


public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[2];
//        System.out.println("arr[2]" + arr[2]);
        try {
            methodOne();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catch ArrayIndexOutOfBoundsException in main ");
        } catch (NullPointerException e) {
            System.out.println("catch NullPointerException in main");
        } catch (MyHandledException exception){
            System.out.println(exception.getMessage());
            
        }
        System.out.println("finish");

    }

    public static void methodOne() throws MyHandledException {
        First first = new First();
        try {
            first.methodFirst();
        } catch (MyUnhandledException exception) {
            System.out.println(" handle in method one ");
        }

        int a = 0;
        int divide = 20 / a;
        System.out.println("divide = " + divide);
        System.out.println("after devide");
    }
}
