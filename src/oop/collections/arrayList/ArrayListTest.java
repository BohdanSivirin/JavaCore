package oop.collections.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(15);
        // размер
        int size = list.size();

        list.add("Vasya");
        list.add("Petya");
        list.add("Ihor");
        size = list.size();
        System.out.println(size);
        System.out.println(list);
        Collections.addAll(list, "Vasya", "Petya", "Max");
        System.out.println(list);
        // вставка в массив
        list.add(0, "John");
        System.out.println(list);
//        list.add(14,"Olga");
//        System.out.println(list);
        ArrayList<String> cars = new ArrayList<>();
        Collections.addAll(cars, "Bmw", "Volkswagen", "Audi");
        System.out.println(cars);
        list.addAll(cars);
        System.out.println(list);
        cars.addAll(2, list);
        System.out.println(cars);
        // получить значение из ячейки
        String name = cars.get(3);
        System.out.println(name);
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(" " + i + " " + cars.get(i));
        }
        System.out.println(" ");
        for (int i = cars.size() - 1; i >= 0; i--) {
            System.out.print(" " + i + " " + cars.get(i));
        }
        boolean isExist = cars.contains("Bmw");
        System.out.println("\n" + isExist);
        int index = cars.indexOf("Bmw");
        System.out.println("\n" + index);
        int index2 = cars.lastIndexOf("Bmw");
        System.out.println(index2);
        // delete
        list.add(null);
        list.add(0, null);
        System.out.println(list);
        boolean isRemove = list.remove(null);
        System.out.println(list);
        list.remove(0);
        //есть лист интов, удалить у него все отрицательные элементы
        ArrayList<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, -5, 1, 4, -12, -5, 7, -1, 9, -10, 99);
//        for (int i = nums.size()-1; i >= 0; i--) {
//            if (nums.get(i) < 0) {
//                nums.remove(i);
//            }
//            // nums.get(i) == nums.get(-i)? "ok": nums.remove(i);
//        }
//        System.out.println(nums);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < 0) {
                nums.remove(i);
                i--;
            }
            // nums.get(i) == nums.get(-i)? "ok": nums.remove(i);
        }
        System.out.println(nums);
        //замена
        int i = nums.indexOf(9);
        nums.set(i, 30);
        System.out.println(nums);
        //есть лист чаров удалить в нем все гласные
        ArrayList<Character> chars = new ArrayList<Character>();
        Collections.addAll(chars, 'a', 'f', 'e', 'g', 'Y', '%', '2', ')', '@', '9', null, null);
        ArrayList<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels, 'a', 'e', 'y', 'u', 'i', 'o', 'A', 'E', 'Y', 'U', 'I', 'O');
        chars.removeAll(vowels);
        System.out.println(chars);
        for (Character l : chars) {
            System.out.println(l);
        }
        list.trimToSize();
        System.out.println(list);
//        list.clear();
        System.out.println(list);
        boolean is = list.isEmpty();
        System.out.println(is);
        int a = list.size();
        System.out.println(a);
        String [] s = list.toArray(new String[0]);
        System.out.println(Arrays.toString(s));
    }
}
