package oop.collections.hashMap;

import java.awt.geom.Rectangle2D;
import java.util.*;


public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Double> exchange = new HashMap<>();
        //HashMap exchange = new HashMap();
        int size = exchange.size();
        System.out.println(size);
        //добавление
        exchange.put("USD", 47.25);
        //exchange.put(12346787L, "UAH");
        exchange.put("UAH", 12.55);
        exchange.put("EUR", 50.66);
        exchange.put("GBJ", 112.55);
        size = exchange.size();
        System.out.println(size);
        System.out.println(exchange);
        exchange.put("EUR", 55.65);
        System.out.println(exchange);
        //получить значение
        Double course = exchange.get("GBJ");
        System.out.println(course);
        Double course2 = exchange.get("TYP");
        System.out.println(course2);
        //1 способ -заменить значение в мапе
        Double oldValue = exchange.replace("UAH", 88.12);
        System.out.println("oldValue " + oldValue);
        Double newCourseUah = exchange.get("UAH");
        System.out.println(newCourseUah);
//        exchange.replace("ZAECH", 88.12);
//        Double course3 = exchange.get("ZAECH");
//        System.out.println(course3);
        exchange.put("ZAECH", 100.13);
        System.out.println(exchange);
        //2 способ -заменить значение в мапе
        boolean isChange = exchange.replace("UAH", 88.12, 250.45);
        System.out.println(isChange);
        // Поиск ключа, есть ли?
        boolean isExist = exchange.containsKey("OOP");
        System.out.println(isExist);
        System.out.println(exchange);
        boolean isExist2 = exchange.containsValue(250.45);
        System.out.println(isExist2);
        // delete
        Double oldValue2 = exchange.remove("POI");
        System.out.println(oldValue2);
        exchange.remove("UAH", 250.46);
        System.out.println(exchange);
        // clear
        // exchange.clear();
        System.out.println(exchange);
        for (String currency : exchange.keySet()) {
            System.out.print(" " + currency);
        }
        for (Double value : exchange.values()) {
            System.out.print(" " + value);
        }
        for (String currency : exchange.keySet()) {
            System.out.println(" " + currency + " " + exchange.get(currency));
        }
        //в мапе типа стринг -дабл найти ключ, отвечающий наибольшему значению
        HashMap<String, Double> map = new HashMap<>();
        map.put("uah", 78.12);
        map.put("usd", 18.12);
        map.put("eur", 87.12);
        map.put("rol", 112.33);
        String maxKey = "";
        Double buffer = Double.MIN_VALUE;
        for (String key : map.keySet()) {
            if (map.get(key) > buffer) {
                buffer = map.get(key);
                maxKey = key;
            }
        }
        System.out.println(map);
        System.out.println(" Max key " + maxKey);

        //есть эрейлист типа стринг/ Используя мапу определить количество каждого из стрингов в листе
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "text", "hello", "#$%good", "hi", "132", "hi", "hi", "text");
        HashMap<String, Integer> map1 = new HashMap<>();
        for (String text : list) {
            if (map1.containsKey(text)) {
                int counter = map1.get(text) + 1;
                map1.put(text, counter);
            } else map1.put(text, 1);
        }
        System.out.println(" map1 " + map1);

        //есть мапа типа стринг-инт заменить все положительные значения на отрицательные и наоборот
        HashMap<String, Integer> maps = new HashMap<>();
        maps.put("a", 10);
        maps.put("b", -7);
        maps.put("c", 85);
        maps.put("d", -310);
        maps.put("g", -10);
        maps.put("h", -12);
        maps.put("u", 18);
        maps.put("e", -82);
        maps.put("r", 112);
        System.out.println("maps before" + maps);
        for (String key : maps.keySet()) {
            int val = maps.get(key) * -1;
            maps.replace(key, val);
            //      maps.replace(key, maps.get(key), val);
        }
        System.out.println("maps after " + maps);

        //в мапе типа инт-стринг заменить все положительные ключи на отрицательные
        HashMap<Integer, String> num = new HashMap<>();
        num.put(-7, "nu89m");
        num.put(10, "n^um");
        num.put(27, "nu%m");
        num.put(-77, "num%");
        num.put(-37, "num#");
        num.put(789, "num#");
        num.put(7123, "num#");
        System.out.println("num before" + num);
        int newKey;
        String val;
        Set<Integer> keys = new HashSet<>(num.keySet());
        for (Integer key : keys) {
            if (key > 0) {
                newKey = key * -1;
                val = num.remove(key);
                num.put(newKey, val);
            }
        }
        System.out.println("num after" + num);
    }
}
