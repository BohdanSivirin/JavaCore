package oop.functionalProgramming;

import java.math.BigDecimal;

public class Good {
    private final String title;
    private int amount;
    private BigDecimal price;
    private boolean hasDiscount = false;

    public Good(String title, int amount, BigDecimal price) {
        this.title = title;
        this.amount = amount;
        this.price = price;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String toString() {
        return "title: " + title + ", price: " + price + ", amount: " + amount + ", hasDiscount: " + hasDiscount + " --> total: " + total();
    }

    public BigDecimal total() {
        return price.multiply(BigDecimal.valueOf(amount));
    }

}
