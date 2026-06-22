package oop.io.texts.toy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        Toy toy = new Toy("Lego", 125.78, 6, "plastic", false, 1234445566, Map.of(
                "instruction", 1,
                "panel", 10, "roof", 2
        ));

        Toy toy1 = new Toy("Car", 458.99, 3, "steel", true, 999888777, new HashMap<>(Map.of("instruction", 1, "wheel", 4)));
        Toy toy2 = new Toy("Bugatti", 9458.99, 21, "brand-new", false, 99969999, new HashMap<>(Map.of("instruction", 1, "wheel", 4, "driver", 1, "licence", 1)));
        Toy toy4 = new Toy("Parabellum", 505.99, 18, "iron", true, 5566, new HashMap<>(Map.of("bullet", 25)));

        boolean isSaved = ToyController.save(toy);
        System.out.println("isSavedToy " + isSaved);
        boolean isSaved1 = ToyController.save(toy1);
        System.out.println("isSavedToy1 " + isSaved1);
        boolean isSaved2 = ToyController.save(toy2);
        System.out.println("isSavedToy2 " + isSaved2);

        boolean isSaved4 = ToyController.save(toy4);
        System.out.println("isSavedToy4 " + isSaved4);

        ArrayList<Toy> isFounded = ToyController.findAvailableToys(10, 11);
        for (Toy t : isFounded) {
            System.out.println("\nisFounded " + t);
        }

        toy.setPrice(500.05);
        boolean isUpdated = ToyController.update(toy);
        System.out.println("\nisUpdated toy price " + isUpdated);
        System.out.println("\nisUpdated toy " + toy);

        boolean isDeleted = ToyController.delete(toy2);
        System.out.println("\nisDeleted " + isDeleted);

        ArrayList<Toy> all = ToyController.readAll();
        for (Toy t : all) {
            System.out.println("\nall toys left " + t);
        }

        toy4.setPrice(999.99);
        toy4.setMaterial("wood");
        toy4.setToxic(true);
        toy4.setFeatures(new HashMap<>(Map.of("Type", 1,"Power", 10,"Accuracy", 75,"Range", 90 )));

        boolean isUpdated4 = ToyController.update(toy4);
        System.out.println("\nisUpdated toy4 " + isUpdated4);
        System.out.println("\nisUpdated toy4 " + toy4);
        System.out.println("* * * ");
        toy4.setFeatures(new HashMap<>());
        boolean isUpdated5 = ToyController.update(toy4);
        System.out.println("\nisUpdated toy4 " + isUpdated5);
        System.out.println("\nisUpdated toy4 " + toy4);




    }
}
