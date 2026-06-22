package oop.generic_wildCard;

import oop.generics.newGenerics.Animal;
import oop.generics.newGenerics.Cat;
import oop.generics.newGenerics.Puma;
import oop.generics.newGenerics.Tiger;

import java.util.*;
import java.util.function.Predicate;

public class Main_4 {
    public static void main(String[] args) {
        StoreImpl<Number, Cat> catStore = new StoreImpl<>();
        Map<Long, Cat> catMap = new HashMap<>();
        catMap.putAll(Map.of(
                123456789999L, new Cat(true),
                987654321L, new Cat(false),
                77788899910L, new Puma(),
                741258963L, new Tiger()));
        catStore.putAll(catMap);

        Map<Long, Tiger> tigerMap = new HashMap<>();
        tigerMap.putAll(Map.of(123456789L, new Tiger()));
        catStore.putAll(tigerMap);

        Predicate<Cat> catPredicate = (cat) -> cat.getIsTebby();
        Collection<Cat> collection = catStore.getAll(catPredicate);

        Predicate<Animal> animalPredicate = (animal) -> animal.getAge() < 5;
        Collection<Cat> collection1 = catStore.getAll(animalPredicate);

        ArrayList<Long> list = new ArrayList<>(Arrays.asList(123456789999L, 987654321L, 77788899910L, 741258963L, 99999999999L));
        Map<Number, Cat> map = catStore.getAll(list);

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,10));
        catStore.getAll(list1);


    }
}
