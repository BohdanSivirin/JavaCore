package oop.inheritance.shop;

import java.util.Map;

public abstract class Toy extends Product {
    private final String title;
    private final int age;
    private final Map<String, Integer> features;

    public Toy(String name, String title, double price, int age, Map<String, Integer> features) {
        super(name, price);
        this.age = age;
        this.title = title;
        this.features = features;
    }

    public void info() {
        System.out.println(this);
    }

    public String toString() {
        return " <- " + getClass().getSimpleName()+ " ->\n " +
                super.toString() +
                "\ntitle : " + title +
                "\nage from : " + age + " years " +
                "\nfeatures : \n" + printFeature();
    }

    private String printFeature() {
        StringBuilder t = new StringBuilder();
        int i = 1;
        for (String text : features.keySet()) {
            t.append(i).append(") ").append(text).append(" -> ").append(features.get(text)).append("\n");
            i++;
        }
        return t.toString();
    }
}
