//package oop.inheritance.coffeeMachineToDelete;
//
//import oop.inheritance.CoffeeMachine.*;
//
//public class Main {
//    public static void main(String[] args) {
//        CoffeeMaker coffeeMaker = new CoffeeMaker();
//        Cup cup = new Cup();
//
//        Coffee coffee = new Coffee("Dark", 30, 12.22);
//        Coffee coffee1 = new Coffee("Dark", 30, 12.22);
//        Water water = new Water("Djellaba", 80, 36.58);
//        Water water1 = new Water("Djellaba", 80, 36.58);
//        Sugar sugar = new Sugar("Brown", 15, 9.69);
//        Sugar sugar1 = new Sugar("Brown", 15, 9.69);
//        Milk milk = new Milk("Milka", 100, 15.45);
//        Milk milk1 = new Milk("Milka", 100, 15.45);
//
//        Americano americano = new Americano(coffee, 2, milk, 1, water, 1, sugar, 0);
//        Americano americano1 = new Americano(coffee, 2, milk, 1, water, 1, sugar, 0);
//        Cappuccino cappuccino = new Cappuccino(coffee, 1, milk, 2, water, 2, sugar, 2);
//        Latte latte = new Latte(coffee1, 0, milk1, 2, water1, 1, sugar1, 1);
//
//        coffeeMaker.addIngredientToMachine(coffee);
//        coffeeMaker.addIngredientToMachine(coffee1);
//        coffeeMaker.addIngredientToMachine(water);
//        coffeeMaker.addIngredientToMachine(water1);
//        coffeeMaker.addIngredientToMachine(sugar);
//        coffeeMaker.addIngredientToMachine(sugar1);
//        coffeeMaker.addIngredientToMachine(milk);
//        coffeeMaker.addIngredientToMachine(milk1);
//        coffeeMaker.addIngredientToMachine(water1);
//        coffeeMaker.addIngredientToMachine(water);
//        coffeeMaker.addIngredientToMachine(milk1);
//
//        coffeeMaker.makeDrink(cup, americano);
//        coffeeMaker.makeDrink(cup, latte);
//        coffeeMaker.makeDrink(cup, cappuccino);
//
//        int a = water.hashCode();
//        int a1 = water1.hashCode();
//        int b = milk.hashCode();
//        int b1 = milk1.hashCode();
//        int c = sugar.hashCode();
//        int c1 = sugar1.hashCode();
//        int h = coffee.hashCode();
//        int h1 = coffee1.hashCode();
//
//
//        System.out.println("water " + a);
//        System.out.println("water1 " + a1);
//        System.out.println("milk " + b);
//        System.out.println("milk1 " + b1);
//        System.out.println("sugar " + c);
//        System.out.println("sugar1 " + c1);
//        System.out.println("coffee " + h);
//        System.out.println("coffee1 " + h1);
//
//        int am = americano.hashCode();
//        int am1 = americano1.hashCode();
//
//        System.out.println("americano " + am);
//        System.out.println("americano1 " + am1);
//
//
//    }
//}
