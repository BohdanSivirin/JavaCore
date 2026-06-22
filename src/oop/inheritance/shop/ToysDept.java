package oop.inheritance.shop;

import java.util.ArrayList;

public final class ToysDept {
    private final ArrayList<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public String toString() {
        StringBuilder t = new StringBuilder();
        int i = 1;
        for (Toy toy : toys) {
            t = t.append(i).append(") ").append(toy).append(";\n");
            i++;
        }
        return t.toString();
    }

}
