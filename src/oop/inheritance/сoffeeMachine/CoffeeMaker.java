package oop.inheritance.сoffeeMachine;

import java.util.HashMap;
import java.util.Scanner;


public class CoffeeMaker {
    private final HashMap<Ingredient, Integer> ingredients = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private final Cup cup = new Cup();

    public CoffeeMaker() {
        ingredients.put(new Coffee(), 3);
        ingredients.put(new Water(), 2);
        ingredients.put(new Sugar(), 0);
        ingredients.put(new Milk(), 3);
        menu();
    }

    private void makeDrink() {
        if (ingredients.isEmpty()) {
            System.out.println("not enough resources");
            return;
        }
        System.out.println("\nchoose type of drink: 1 - Americano, 2 - Latte");
        switch (scanner.nextInt()) {
            case 1 -> {
                if (2 <= ingredients.get(new Coffee())
                        && 1 <= ingredients.get(new Water())
                        && 2 <= ingredients.get(new Sugar())) {
                    cup.addIngredients(new Coffee(), 2);
                    cup.addIngredients(new Water(), 1);
                    cup.addIngredients(new Sugar(), 2);
                    ingredients.replace(new Coffee(), ingredients.get(new Coffee()) - 2);
                    ingredients.replace(new Water(), ingredients.get(new Water()) - 1);
                    ingredients.replace(new Sugar(), ingredients.get(new Sugar()) - 2);
                    System.out.println(cup);
                } else System.out.println("not enough resources ");
            }
            case 2 -> {
                if (ingredients.containsKey(new Coffee()) && 1 <= ingredients.get(new Coffee())
                        && ingredients.containsKey(new Milk()) && 1 <= ingredients.get(new Milk())
                        && ingredients.containsKey(new Sugar()) && 3 <= ingredients.get(new Sugar())
                        && ingredients.containsKey(new Water()) && 1 <= ingredients.get(new Water())) {
                    cup.addIngredients(new Coffee(), 1);
                    cup.addIngredients(new Water(), 1);
                    cup.addIngredients(new Sugar(), 3);
                    cup.addIngredients(new Milk(), 1);
                    ingredients.replace(new Coffee(), ingredients.get(new Coffee()) - 1);
                    ingredients.replace(new Water(), ingredients.get(new Water()) - 1);
                    ingredients.replace(new Sugar(), ingredients.get(new Sugar()) - 3);
                    ingredients.replace(new Milk(), ingredients.get(new Milk()) - 1);
                    System.out.println(cup);
                } else System.out.println("not enough resources ");
            }
        }
    }


    private void fillResources() {
        for (; ; ) {
            Ingredient ingredient = null;
            System.out.println("\nchoose ingredient :\n1 - Coffee\n2 - Milk\n3 - Sugar\n4 - Water\n5 - Menu ");
            int value = scanner.nextInt();
            if (value <= 0 || value >= 6) {
                System.out.println("choose number from 1 to 5 ");
                continue;
            }
            switch (value) {
                case 1 -> ingredient = new Coffee();
                case 2 -> ingredient = new Milk();
                case 3 -> ingredient = new Sugar();
                case 4 -> ingredient = new Water();
                case 5 -> {
                    return;
                }
            }
            if (ingredients.containsKey(ingredient)) {
                ingredients.replace(ingredient, ingredients.get(ingredient) + 1);
            } else ingredients.put(ingredient, 1);
            info();
        }
    }

    private void menu() {
        System.out.println("\nChoose option:\n1 - make drink\n2 - fill resources\n3 - exit");
        switch (scanner.nextInt()) {
            case 1 -> makeDrink();
            case 2 -> fillResources();
            case 3 -> {
                scanner.close();
                System.exit(0);
            }
        }
        menu();
    }

    private void info() {
        System.out.println("\n{Ingredients in machine}");
        for (Ingredient i : ingredients.keySet()) {
            System.out.println(" -> " + i + " portion: " + ingredients.get(i) + " | ");
        }
    }
}
