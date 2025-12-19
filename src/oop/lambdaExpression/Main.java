package oop.lambdaExpression;

import oop.lambdaExpression.Command;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Command command = new Command() {
            @Override
            public void execute() {
                System.out.println("command from lambda expression");
            }
        };
        command.execute();
        Command walking = () -> System.out.println("walking ....");
        walking.execute();

        Action number = v -> Double.toString(v).split("\\.")[1].length();
        System.out.println(number.getValue(123.569978));

//        AbstractAction action = v -> (v + "").indexOf("\\."));

        ActionTwo numbers = t -> t.length();
        int n = numbers.getPosition("Hello");
        System.out.println(n);
        numbers.createObj();
        int position = ActionTwo.POSITION;
        String title = ActionTwo.TITLE;
        System.out.println(position);
        System.out.println(title);

        ActionTwo.print("numbers for letter");

        int[] array = {12, 55, 7890, -45, 9};
        final SomeClass wrapper = new SomeClass();
        int[] array2 = {0};
//        array2 = new int[5];
        ActionThree averageValue = () -> {
            for (int i = 0; i < array.length; i++) {
//                array2 = new int[2];
//                wrapper.setValue(wrapper.getValue() + array[i]);
                array2[0] += array[i];
            }
            return (double) array2[0] / array.length;
//            return (double) wrapper.getValue() / array.length - 1;
        };
        System.out.println(averageValue.getValue());
        // отсортировать массив интов по убыванию
        Integer[] arr = {12, 55, 7890, -45, 9, -126};
        Comparator<Integer> result = (a, b) -> b - a;
        Arrays.sort(arr, result);
        System.out.println(Arrays.toString(arr));

//        AbstractClass text = (String s) ->

    }
}

