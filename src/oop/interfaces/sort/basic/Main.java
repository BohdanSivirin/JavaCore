package oop.interfaces.sort.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        double[] array = {1.13, 2.54, 3.25, 7.89, 5.69, 9, 99, -12.58, -66.66, -7.85};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "qwerty", "hello", "!@#$^^", "pavel", "mercedes", "bmw", "audi");
        Collections.sort(strings);
        System.out.println(strings);
        Collections.reverse(strings);
        System.out.println(strings);

    }
}
