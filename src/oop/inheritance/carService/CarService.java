package oop.inheritance.carService;

import java.util.ArrayList;
import java.util.Random;

public class CarService {
    private final ArrayList<Engine> engines = new ArrayList<>();


    public void changeEngine(Car car) {
        if (!engines.isEmpty()) {
            int randomIndex = new Random().nextInt(engines.size() );
            car.setEngine(engines.remove(randomIndex));
            //engines.remove(randomIndex);
            System.out.println("Engine is changed ");
        } else System.out.println("Engines list is empty ");
    }

    public void addEngineToList(Engine engine) {
        if (engine == null) {
            System.out.println("Error - Engine is not created ");
            return;
        }
        engines.add(engine);
        System.out.println("Engine = " + engine.getClass().getSimpleName() + " added to engines ");
    }


}
