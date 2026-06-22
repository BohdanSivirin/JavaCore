package oop.io.adapters.toys;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Toy toy = new Toy("Lego", 125.78, 6, "plastic", false, 1234445566,
                new HashMap<>(Map.of("instruction", 1, "panel", 10, "roof", 2)));
        Toy toy1 = new Toy("Car", 458.99, 3, "steel", true, 999888777,
                new HashMap<>(Map.of("instruction", 1, "wheel", 4)));
        Toy toy2 = new Toy("Bugatti", 9458.99, 21, "brand-new", false, 99969999,
                new HashMap<>(Map.of("instruction", 1, "wheel", 4, "driver", 1, "licence", 1)));
        Toy toy4 = new Toy("Antebellum", 505.99, 18, "iron", true, 5566,
                new HashMap<>(Map.of("bullet", 25)));

        List<Toy> t = new ArrayList<>();
        Collections.addAll(t, toy, toy1, toy2, toy4);
//        System.out.println("t.size(): " + t.size());

        boolean isSaved = ToyController.saveAll(t);
        System.out.println("isSavedAll: " + isSaved);

        List<Toy> toysRead = ToyController.readAll();
        System.out.println("toysReadAll.size(): " + toysRead.size());

        for (Toy t1 : toysRead) {
            System.out.println(t1 + "\n * * * * * ");
        }
        System.out.println("\n_______________________\n ");
        toy.setPrice(500.05);
        boolean isUpdated = ToyController.update(toy);
        System.out.println("\nisUpdated toy price:  " + isUpdated);
        System.out.println("\nisUpdated toy:  " + toy);
        System.out.println("\n_______________________\n ");
        boolean isDeleted = ToyController.delete(toy2);
        System.out.println("\nisDeleted: " + isDeleted);
        List<Toy> all = ToyController.readAll();
        for (Toy t2 : all) {
            System.out.println("\nall toys left\n " + t2);
        }

        toy4.setPrice(999.99);
        toy4.setMaterial("wood");
        toy4.setToxic(true);
        toy4.setFeatures(new HashMap<>(Map.of("Type", 1, "Power", 10, "Accuracy", 75, "Range", 90)));
                System.out.println("\n_______________________\n ");

        boolean isUpdated4 = ToyController.update(toy4);
        System.out.println("\nisUpdated:  " + isUpdated4);
        System.out.println("\nisUpdated toy4: " + toy4);
        System.out.println("\n_______________________\n ");
        toy4.setFeatures(new HashMap<>());
        boolean isUpdated5 = ToyController.update(toy4);
        System.out.println("\nisUpdated: " + isUpdated5);
        System.out.println("\nisUpdated toy4: " + toy4);

    }
}
