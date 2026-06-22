package oop.interfaces.sort.multySort.phones;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone("Nokia", "1100", 250, 3, 8, 123456789, "Black");
        Phone phone1 = new Phone("Nokia", "1100", 340, 3, 8, 1234564789, "Blue");
        Phone phone2 = new Phone("Nokia", "1100", 1250, 3, 8, 123456711, "Grey");
        Phone phone3 = new Phone("Nokia", "1100", 8000, 3, 8, 198786789, "Brown");
        Phone phone4 = new Phone("Samsung", "A34", 400, 6, 6, 335856789, "Yellow");
        Phone phone5 = new Phone("Samsung", "A52", 1100, 16, 8, 334546789, "Green");
        Phone phone6 = new Phone("Samsung", "A33", 560, 12, 4, 45256789, "Red");
        Phone phone7 = new Phone("Samsung", "A68", 890, 11, 5, 342455789, "Black");
        Phone phone8 = new Phone("Iphone", "14", 9999, 17, 72, 399995789, "BlackGrafit");
        Phone phone9 = new Phone("Iphone", "15pro", 8999, 18, 125, 399995789, "BlueGrafit");
        Phone phone10 = new Phone("Iphone", "15", 19925, 21, 100, 399995789, "RedGrafit");
        Phone phone11 = new Phone("Iphone", "16pro", 29999, 23, 150, 399995789, "GreenkGrafit");
        ArrayList<Phone> phones = new ArrayList<>();
        Collections.addAll(phones, phone, phone3, phone4, phone8, phone2, phone5, phone1, phone4, phone6, phone9, phone7, phone10, phone11);
        Collections.sort(phones);
        System.out.println(phones);


    }


}
