package oop.io.scanner;

public class Main {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        long value = scanner.readLong();
        System.out.println("value long: " + value);
        scanner.close();
    }
}
