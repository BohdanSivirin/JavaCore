//package oop.inheritance.coffeeMachineToDelete;
//
//import oop.inheritance.CoffeeMachine.Cup;
//import oop.inheritance.CoffeeMachine.Ingredient;
//
//import java.util.HashMap;
//
//public class CoffeeMaker {
//    private final HashMap<Ingredient, Integer> ingredients = new HashMap<>();
//
//
//    public void addIngredientToMachine(Ingredient ingredient) {
//        if (ingredients.containsKey(ingredient)) {
//            ingredients.replace(ingredient, ingredients.get(ingredient) + 1);
//            return;
//        }
//        ingredients.put(ingredient, 1);
//        info();
//    }
//
//    private void calculateRestOfIngredients(Drink drink) {
//        HashMap<Ingredient, Integer> recipe = drink.getRecipe();
//        for (Ingredient i : recipe.keySet()) {
//            ingredients.replace(i, ingredients.get(i) - recipe.get(i));
//        }
//    }
//
//    public Cup makeDrink(Cup cup, Drink drink) {
//        if (cup == null) {
//            System.out.println("Cup is not found ");
//            return cup;
//        }
//        if (drink == null) {
//            System.out.println(" Drink is null ");
//            return cup;
//        }
//        if (ingredients.isEmpty()) {
//            System.out.println("Add ingredients to the machine ");
//            return cup;
//        }
//        if (!isEnoughIngredients(drink)) {
//            System.out.println("Not enough ingredients | " + drink);
//            return cup;
//        }
//        cup.setDrink(drink);
//        calculateRestOfIngredients(drink);
//        System.out.println("Enjoy drinking !!! ");
//        printOrder(drink);
//        return cup;
//    }
//
//    private boolean isEnoughIngredients(Drink drink) {
//        HashMap<Ingredient, Integer> recipe = drink.getRecipe();
//        for (Ingredient i : recipe.keySet()) {
//            if (!ingredients.containsKey(i)) return false;
//            if (ingredients.get(i) < recipe.get(i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void info() {
//        System.out.println("\n* * * Ingredients in machine * * *");
//        for (Ingredient i : ingredients.keySet()) {
//            System.out.println(i + " portion: " + ingredients.get(i) + " | ");
//        }
//    }
//
//    private void printOrder(Drink drink) {
//        HashMap<Ingredient, Integer> recipe = drink.getRecipe();
//        System.out.println("\n* * * Order * * * ");
//        double total = 0;
//        for (Ingredient i : recipe.keySet()) {
//            System.out.println(i + " portion: " + recipe.get(i) + " | ");
//            total = total + i.getPrice();
//        }
//        System.out.println("_______\nTotal : " + total + " $\n");
//    }
//
//}
