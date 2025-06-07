//package oop.inheritance.coffeeMachine;
//
//import oop.inheritance.CoffeeMachine2.Coffee;
//import oop.inheritance.CoffeeMachine2.Milk;
//import oop.inheritance.CoffeeMachine2.Sugar;
//import oop.inheritance.CoffeeMachine2.Water;
//
//import java.util.HashMap;
//
//
//public abstract class Drink {
//    private final HashMap<Ingredient, Integer> recipe = new HashMap<>();
//
//    public Drink(Coffee coffee, int coffeeValue, Milk milk, int milkValue, Water water, int waterValue, Sugar sugar, int sugarValue) {
//        recipe.put(coffee, coffeeValue);
//        recipe.put(milk, milkValue);
//        recipe.put(water, waterValue);
//        recipe.put(sugar, sugarValue);
//    }
//
//    public HashMap<Ingredient, Integer> getRecipe() {
//        return recipe;
//    }
//
//    @Override
//    public String toString() {
//        return "current drink : " + getClass().getSimpleName();
//    }
//}
