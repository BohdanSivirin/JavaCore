package oop.generic_wildCard;

import oop.generics.newGenerics.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main_3 {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        Collections.addAll(animals, new Cat(true), new Puma(), new Tiger(), new Dog());
        StorageController<Animal> storageController = new StorageController<>("book Of Animal.txt");
        Consumer<Animal> animalConsumer = (animal) -> storageController.save(animal);
        process(animals, animalConsumer);

        PdfDocument pdf = new PdfDocument("PDF");
        WordDocument word = new WordDocument("Word");
        ExcelDocument excel = new ExcelDocument("Excel");
        Contract contract = new Contract(11);
        Invoice invoice = new Invoice(22);
        Book book = new Book(378);

        List<Document> documentList = Arrays.asList(pdf, word, excel, contract, invoice, book);
        process(
                documentList,
                (l) -> new StorageController<Document>("documents.txt").save(l));

        String documentsData = new StorageController<Document>("documents.txt").getData();
        System.out.println("documentsData: \n" + documentsData);

        List<Cat> cats = new ArrayList<>(Arrays.asList(new Cat(true), new Cat(false), new Tiger(), new Puma()));
//        List<Animal> cats = new ArrayList<>(Arrays.asList(new Cat(true), new Cat(false), new Tiger(), new Puma()));
        process(cats, animalConsumer);

//        process(cats,animalConsumer);
        Consumer<Object> objectConsumer = (o) -> new StorageController<>("zooObjects.txt").save(o);
        process(cats, objectConsumer);

        List<Dog> dogs = new ArrayList<>(Arrays.asList(new Dog()));
        process(dogs, objectConsumer);
        process(dogs, animalConsumer);

        List<Animal> emptyList = new ArrayList<>();
        Predicate<Animal> isAgeLessThan = (animal) -> animal.getAge() < 7;
//        filter(animals, emptyList, isAgeLessThan);
//        emptyList.forEach(e -> System.out.println(e));
        List<Cat> catList = new ArrayList<>(Arrays.asList(new Cat(false), new Cat(true), new Tiger(), new Puma()));
//        filter(catList, emptyList, isAgeLessThan);
//        emptyList.forEach(e -> System.out.println(e));

        //с листа с документами добавить в новый лист только электронные доки
//        Predicate<Document> isElectronic = (d) -> d instanceof ElectronicDocument;
//        List<Document> emptyList = new ArrayList<>();
//        filter(documentList, emptyList, isElectronic);
//        emptyList.forEach(e -> System.out.println(e));
        //с листа котов в лист животных но только тигров?
        List<Object> objects = new ArrayList<>();
        Predicate<Cat> isTiger = (a) -> a.getClass().getSimpleName().equals("Tiger");
        filter(catList,objects,isTiger);


    }

    public static <T> void process(List<? extends T> data, Consumer<? super T> action) {
        // какое то действие над каждым элементом листа (Дженерик)
        for (int i = 0; i < data.size(); i++) {
            T o = data.get(i);
            action.accept(o);
        }
    }

    public static <T> void filter(List<? extends T> listOne, List<? super T> listTwo, Predicate<? super T> predicate) {
        for (int i = 0; i < listOne.size(); i++) {
            T element = listOne.get(i);
            boolean result = predicate.test(element);
            if (result) {
                listTwo.add(element);
            }
        }
    }
}
