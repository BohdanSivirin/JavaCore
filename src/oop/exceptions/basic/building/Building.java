package oop.exceptions.basic.building;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Building {
    private final HashMap<Integer, ArrayList<Apartment>> apartments= new HashMap<>();
    private final Controller controller = new Controller();

    public Building(int[] array) {

        ArrayList<String> owners = new ArrayList<>();
        Collections.addAll(owners, "Harry", "Bob", "John", "Bobby", "Nick", "George", "Vasya", "Petr", "Steve");

        for (int i = 0; i < array.length; i++) {
            ArrayList<Apartment> floor = new ArrayList<>();
            for (int j = 0; j < array[i]; j++) {
                int randomOwner = new Random().nextInt(owners.size());
                floor.add(new Apartment(owners.get(randomOwner), (i + 1) * 10 + j + 1));
            }
            apartments.put(i, floor);
        }
    }

    public void info() {
        for (Integer i : apartments.keySet()) {
            System.out.println("\n || Floor = " + i + " || " + apartments.get(i));
        }
    }

    public void connectDomophone(Domophone domophone) {
        domophone.connectController(controller);
    }


    public class Controller {

        public void search(int value) throws BuildingException {
            for (Integer floor : apartments.keySet()) {
                ArrayList<Apartment> list = apartments.get(floor);
                for (Apartment currentApp : list) {
                    if (currentApp.getFlatNumb() == value) {
                        currentApp.call();
                        return;
                    }
                }
            }
            System.out.println("Flat # " + value + " is not found ");
        }
    }
}
