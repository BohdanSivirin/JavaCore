package oop.interfaces.sort.basic.persons;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("New-York", "Manhettan Street", 111, 25);
        Address address1 = new Address("Dnipro", "Naberejna Peremogy", 21, 1135);
        Address address2 = new Address("Shepetivka", "Troyindova", 13, 6);
        Address address3 = new Address("Kiev", "Chreshatic Squar", 10, 7);
        Address address4 = new Address("London", "London'sTower", 56, 89);
        Address address5 = new Address("Paris", "qwertyqwertyStreet", 321, 1147);

        Person person = new Person(78946541303512l, "Vasya", "Pupkin",new Date(1989-1900,3,21) , 89.44, 175, address);
        Person person1 = new Person(78946541374252l, "Petya", "Mospan", new Date(1992-1900, Calendar.FEBRUARY,23), 69.24, 195, address1);
        Person person2 = new Person(12346541374252l, "Jack", "Nikolson", new Date(1956-1900,7,11), 78.05, 155, address2);
        Person person3 = new Person(12894541374252l, "Tom", "Hardy", new Date(2010-1900,11,22), 120.05, 197, address3);
        Person person4 = new Person(12825913374252l, "luis", "Hardy", new Date(2000-1900,9,1), 100.30, 185, address4);
        Person person5 = new Person(12834975374252l, "Mike", "Tyson", new Date(1999-1900,10,31), 99.30, 166, address5);

        ArrayList<Person> persons = new ArrayList<>();
        Collections.addAll(persons, person, person1, person2, person3, person4, person5);
        Collections.sort(persons);

        System.out.println(persons);


    }
}
