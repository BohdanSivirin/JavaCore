package oop.generics.newGenerics;

import java.util.ArrayList;

public class GenericZoo<T extends Animal> {
    private ArrayList<T> animals = new ArrayList<>();

    void addAnimal(T animal) {
        animals.add(animal);
    }

    void makeSound() {
        for (T animal : animals) {
            animal.voice();
        }
    }
}
