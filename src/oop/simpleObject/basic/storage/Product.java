package oop.simpleObject.basic.storage;

public class Product {
    private String title;
    private double price;
    private int maxToStore; // макс кол-во товара для хранения в 1 ячейке
    private int currentAmount; // текущее кол-во товара в ячейке

    public Product(String title, double price, int maxToStore) {
        this.title = title;
        this.price = price;
        this.maxToStore = maxToStore;

    }

    public void info() {
        System.out.println(" title: " + title);
        System.out.println(" price: " + price);
        System.out.println(" currentAmount: " + currentAmount);
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getMaxToStore() {
        return maxToStore;
    }


}
