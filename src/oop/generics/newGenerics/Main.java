package oop.generics.newGenerics;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GenericFirst<String> genericFirst = new GenericFirst<>("some text");
        genericFirst.setField1("new text");
        System.out.println(genericFirst);
//        genericFirst.setField1(34.55);

        GenericFirst<Integer> genericFirst1 = new GenericFirst<>(34);
        genericFirst1.setField1(146);
        System.out.println(genericFirst1);
//        genericFirst=genericFirst1;

        GenericSecond<Double, Long> genericSecond = new GenericSecond<>(34.99, 12345555678L);
        genericSecond.setField1(999.99);
        genericSecond.setField2(999999999999L);
        System.out.println(genericSecond.getField1());
        System.out.println(genericSecond.getField2());

        GenericSecond<String, String> stringMap = new GenericSecond<>("$1", "someText");

        GenericChild<Integer, String> store = new GenericChild<>("text", 11);
        store.setField2("new text");
        store.setField1(13);
        System.out.println(store);

        GenericFirst<Double> price = new GenericChild<>("text2", 77.12);
        price.setField1(99.44);

        SimpleClass simpleClass = new SimpleClass(22, "Vova", "salary", 1200);
        System.out.println("simpleClass field 2 " + simpleClass.getField2());
        System.out.println("simpleClass field 1 " + simpleClass.getField1());
        System.out.println("*****");
        simpleClass.setField1("SomeText1");
        simpleClass.setField2(66);
        System.out.println("simpleClass field 2 " + simpleClass.getField2());
        System.out.println("simpleClass field 1 " + simpleClass.getField1());

        GenericClassForInterface<String, Integer> interfacesClass = new GenericClassForInterface<>("six", 33);
        int v = interfacesClass.getValue("sometext");
        System.out.println("interfacesClass " + v);
        interfacesClass.calculate("text");
//        FirstInterface<Integer> numb = new GenericClassForInterface<>()

        Dog dog = new Dog();
        Cat cat = new Cat(true);
        GenericZoo<Animal> zoo = new GenericZoo<>();
        zoo.addAnimal(dog);
        zoo.addAnimal(cat);
        zoo.makeSound();
//        GenericZoo<String> zoo1 = new GenericZoo<>();
//        zoo1.addAnimal("dog");

        Box<Animal> animalBox = new Box<>();
        animalBox.add(cat);
        Animal bufferAnimal = animalBox.getThing();
        System.out.println(bufferAnimal);
        animalBox.add(dog);
        Animal bufferAnimal1 = animalBox.getThing();
        System.out.println(bufferAnimal1);

        Box<Cat> catBox = new Box<>();
        catBox.add(cat);
        Animal animal = cat;
        //animalBox=catBox;
        // инварианты
        ArrayList<Cat> cats = new ArrayList<>();
        Tiger tiger = new Tiger();
        Puma puma = new Puma();
        cats.add(cat);
        cats.add(tiger);
        cats.add(puma);
        ArrayList<Tiger> tigers = new ArrayList<>();
        tigers.add(tiger);
//        cats=tigers;
        // invariations
        Cat cat1=tiger;




    }
}
