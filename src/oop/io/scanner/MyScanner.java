package oop.io.scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyScanner {
    //    private BufferedReader bufferedReader;
    private BufferedReader bufferedReader;

    public MyScanner() {
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    }

    public void close() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long readLong() {
        try {
            String t = bufferedReader.readLine();
            return Long.valueOf(t);
        } catch (IOException e) {
            throw new IncorrectInputException("Cannot convert value to Long");
        }
    }

    public String readString() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new IncorrectInputException("Cannot convert value to String");
        }
    }
}
