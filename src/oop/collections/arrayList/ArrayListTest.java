package oop.collections.arrayList;

import java.util.*;

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
        String[] s = list.toArray(new String[0]);
        System.out.println(Arrays.toString(s));
        // есть массив типа стринг, Используя эрейлист получить набор уникальных элементов
        String[] array = {"5Text", "Go45od", "12345#4&text", "DER45()*", "DER45()*", "Go45od"};
        ArrayList<String> arrayList = new ArrayList<>();
        for (int k = 0; k < array.length; k++) {
            if (!(arrayList.contains(array[k]))) {
                arrayList.add(array[k]);
            }
        }
        System.out.println(arrayList);
        //есть эрейлист типа инт/ Сделать зеркальный не создавая нового
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 5, -3, 7, -52, 789);
        for (int q = numbers.size() - 1, j = 0; q >= numbers.size() / 2; q--, j++) {
            int buffer = numbers.get(q);
            numbers.set(q, numbers.get(j));
            numbers.set(j, buffer);
        }
        System.out.println(numbers);

        randomString();
        changeNumbers();
        calculateElements();
    }

    //HW1 - есть эрейлист стрингов/ Перемешать элементы случайным образом
    public static void randomString() {
        Random generator = new Random();
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "5Text", "Go45od", "12345#4&text", "DER45()*", "DER45()*", "Go45od", "test", "!@#3450gh");
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            int a = generator.nextInt(0, arrayList.size());
            String buffer = arrayList.get(a);
            arrayList.set(a, arrayList.get(i));
            arrayList.set(i, buffer);
        }
        System.out.println(arrayList);
    }

    //HW2- есть эрейлист интов, все положительные элементы сделать отрицательными и наоборот
    public static void changeNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 8, -21, -22, -6, 5, -3, 7, -52, 789, -15, -10, 11);
        for (int i = numbers.size() - 1; i >= 0; i--) {
            numbers.set(i, -numbers.get(i));
        }
        System.out.println(numbers);
    }

    //есть массив типа инт/ Используя эрейлист подсчитать количество каждого элемента в нем, чтобы потом можна было использовать (информация должна храниться)
    public static void calculateElements() {
        ArrayList<Integer> elements = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 8, 21, 22, 11, 22, 789, 52, 789, 15, 10, 11, 789, 4544);
//        for (int i = 0; i < list.size(); i++) {
//            int counter = 1;
//            nameOfEachElements.add(String.valueOf(list.get(i)));
//            for (int j = i + 1; j < list.size(); j++) {
//                if (Objects.equals(list.get(i), list.get(j))) {
//                    counter++;
//                    list.remove(j);
//                    j--;
//                }
//            }
//            elements.add(counter);
//        }
//        System.out.println("names" + nameOfEachElements);
//        System.out.println("numbers " + elements);

        Integer[] num = list.toArray(new Integer[0]);
        elements = new ArrayList<>();
        ArrayList<Integer> amount = new ArrayList<>();
        for (Integer numb : num) {
            int index = elements.indexOf(numb);
            if (index == -1) {
                elements.add(numb);
                amount.add(1);
            } else {
                amount.set(index, amount.get(index) + 1);
            }
        }
        System.out.println("names" + elements);
        System.out.println("amount " + amount);
    }

}
