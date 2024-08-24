package oop.simpleObject.basic.vendingMachine;

public class Product {
    private String title;
    private int price;
    private int currentAmount;
    private int maxAmount;

    public Product(String title, int price, int currentAmount, int maxAmount) {
        this.title = title;
        this.currentAmount = currentAmount;
        this.price = price;
        this.maxAmount = maxAmount;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }
}
