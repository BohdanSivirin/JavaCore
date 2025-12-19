package oop.nio.texts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(123123123, "Petro", "Petrovich", "Dnipro", "+380630504878",
                new Date(1989 - 1900, Calendar.APRIL, 21), Gender.MALE);
        Person person1 = new Person(784523123, "Elena", "Nikolson", "London", "+380508478962",
                new Date(2000 - 1900, Calendar.OCTOBER, 1), Gender.FEMALE);
        Person person2 = new Person(123697823, "Tom", "Hardy", "Paris", "+380500078912",
                new Date(1978 - 1900, Calendar.FEBRUARY, 13), Gender.MALE);
        List<Person> personList = new ArrayList<>();
        Collections.addAll(personList, person, person1, person2);

        boolean isSavedAll = Controller.saveAll(personList);
        System.out.println("isSavedAll: " + isSavedAll);
        System.out.println("\t___________________________________");

//        List<Person> readAllPersons = Controller.readAll();
//        for (Person p : readAllPersons) {
//            System.out.println("\t read All list after SAVE ALL : \n" + p);
//        }
//        System.out.println("\t___________________________________");

//        boolean isSavedPerson = Controller.save(person);
//        System.out.println("isSavedPerson: " + isSavedPerson);

        Person person3 = new Person(999997823, "oLeg", "Jorry", "Milan", "+380500071337",
                new Date(1994 - 1900, Calendar.MARCH, 9), Gender.MALE);

        boolean isSavedPerson3 = Controller.save(person3);
        System.out.println("isSavedPerson3: " + isSavedPerson3);
        System.out.println("___________________________________");

//        readAllPersons = Controller.readAll();
//        for (Person p : readAllPersons) {
//            System.out.println("\t read All list after SAVE ALL : \n" + p);
//        }
//        System.out.println("\t___________________________________");

        person.setName("Steve");
        person.setSurname("Signal");
        person.setAddress("Berlin");
        person.setDate(new Date(2010 - 1900, Calendar.DECEMBER, 31));
        person.setPhone("380677393733");
        person.setGender(Gender.FEMALE);

        boolean isUpdated = Controller.update(person);
        System.out.println("isUpdatedPerson: " + isUpdated);
        System.out.println("___________________________________");

        List<Person> readAllPersons = Controller.readAll();
        for (Person p : readAllPersons) {
            System.out.println("\t read All list after UPDATE: \n" + p);
        }
        System.out.println("___________________________________");

//        boolean isDeleted = Controller.delete(person1);
//        System.out.println("isDeletedPerson1: " + isDeleted);
//        System.out.println("___________________________________");
//
//        readAllPersons = Controller.readAll();
//        for (Person p : readAllPersons) {
//            System.out.println("\t read All list after DELETE: \n" + p);
//        }

    }
}
