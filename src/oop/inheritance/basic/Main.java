package oop.inheritance.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Animal animal = new Animal(45.50, 8, 5);
        Animal animal = new BlueWhale(11225.50, 45, 7, true, true, "Volley");
        animal.info();
        BlueWhale vasya = new BlueWhale(25000.50, 59, 24, false, false, "Vasya");
        vasya.info();
        vasya.hitFish();
        CaterpillarChild caterpillarChild = new CaterpillarChild(false, 12, 60, 3);
        GrasshopperChild grasshopperChild = new GrasshopperChild(true, 2);
        SharkChild sharkChild = new SharkChild(12.55, 2, 1, true, " Koos ");
        caterpillarChild.run();
        HareRabbit hareRabbit = new HareRabbit(8.25, 4, 5, 2);
        OstrichChild ostrichChild = new OstrichChild(false, " Lola ");
        PigeonChild pigeonChild = new PigeonChild(1.10, 1, 9, true, false, false, " pigeon ");
        GreyWolf greyWolf = new GreyWolf(33.50, 12, 2, true, false, " Kolya ");
        ArrayList<Animal> animals = new ArrayList<>();
        Collections.addAll(animals, vasya, caterpillarChild, grasshopperChild, sharkChild, hareRabbit, ostrichChild, pigeonChild, greyWolf);
        System.out.println("***********");
        Animal animal1 = animals.get(0);
        for (int i = 0; i < animals.size(); i++) {
            if (animal1.getWeight() < animals.get(i).getWeight()) {
                animal1 = animals.get(i);
            }
        }
        animal1.info();
        System.out.println(caterpillarChild.toString());
        Date date = new Date();
        System.out.println(date);
        System.out.println(sharkChild);
        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).voice();
        }
        caterpillarChild.eat();
        caterpillarChild.eat("grass");
    ostrichChild.info();
    }
}
