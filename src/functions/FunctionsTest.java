package functions;

public class FunctionsTest {
    public static void main(String[] args) {
        Functions.print();
        Functions.print(3, "ivan");
        Functions.print(5, "house");
        Functions.createArray(10);
        Functions.print(5, '$');
        Functions.glue(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{10, 20, 300, 30, 40});
        Functions.print(new char[]{'k', 'Y', '5', 'Y', '?', '+', 'F', '$', '%', '*', '#', '*',});
        System.out.println("______");
        Functions.printTrue(new char[]{'1', '7', '<', '9', '?', ')', '0', '$', '%', '*', 'k', '8',});
        Functions.list(new char[]{'d', '*', 'i', '<', 'B', 'l', '%', '@', 'n', 'K', 'M', 'F', '<', '9', '?', 'V', 'v'});
        Functions.fill('*', 4, 6);
        Functions.fill(4);
        Functions.multiply(18);
        Functions.triangle(9);
        Functions.deleteNegative(new int[]{10, 20, -12, -78, 300, 30, 40, -100, -56, -45, 45, 78, -99});
        Functions.booblik(10,5, '*');




    }

}
