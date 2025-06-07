package oop.inheritance.shop;

import java.util.ArrayList;

public final class FoodDept {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        foods.add(food);
    }

    public String toString() {
        StringBuilder t = new StringBuilder();
        int i = 1;
        for (Food food : foods) {
            t = t.append(i).append(") ").append(food).append(";\n");
            i++;
        }
        return t.toString();
    }

}
