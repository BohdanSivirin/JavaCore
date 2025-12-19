package oop.generics.test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //создать простой интерфейс с методом, который является дженериком и принимает дженерик параметр интерфейса,
        // а возвращает параметр тоже дженерик, но такой, которого нет в интерфейсе

        //сделать класс, который не является  дженериком, но разработан как наследник дженерик класса с одним параметром
        // сделать класс, который работает только с числовыми типами данных (Лонг, Дабл, Интежер, Флоатом, Шортом или байтом) и являются при этом дженерикаом

//        Calculator<String> calculator = new Calculator<String>();
        Calculator<Short> calculator3 = new Calculator<>(Short.valueOf("123"));
        Calculator<Integer> calculator1 = new Calculator<>(12);
        Calculator<Float> calculator2 = new Calculator<>(345F);
//        Calculator<Short> calculator4 = new Calculator<>(new Short(789));
//        Float res =  calculator2.getResult();
//        Double floatResult = res.doubleValue();
//        System.out.println(floatResult);
        Short res1 = calculator3.getResult();
        System.out.println(res1);
//        double res2 = calculator1.getResult();
//        System.out.println(res2);
        List<String> text = new ArrayList<>();

    }
}
