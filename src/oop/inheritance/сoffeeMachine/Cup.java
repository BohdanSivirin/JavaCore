package oop.inheritance.сoffeeMachine;


import java.util.HashMap;

public class Cup {
    private final HashMap<Ingredient, Integer> cupIngredients = new HashMap<>();

    public void addIngredients(Ingredient ingredient, int value) {
       cupIngredients.put(ingredient, value);
    }

    @Override
    public String toString() {
        String t = "";
        System.out.println(" Cup ");
        for (Ingredient ingredient : cupIngredients.keySet()) {
            t = t + "\n " + ingredient + " " + cupIngredients.get(ingredient);
        }
        return t;
    }
}


