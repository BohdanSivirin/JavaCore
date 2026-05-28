package oop.stream.invoices;

public class Item implements Cloneable, Comparable<Item> {
    private String title;
    private double price;
    private long barcode;
    private String brand;
    private int amount;
//    private double discount;

    public Item(String title, double price, long barcode, String brand, int amount) {
        this.title = title;
        this.price = price;
        this.barcode = barcode;
        this.brand = brand;
        this.amount = amount;
//        this.discount = discount;
    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(o.price, price);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return barcode == item.barcode;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        return 17 * hashCode + Long.hashCode(barcode);
    }

    public Item clone() {
        return new Item(this.title, this.price, this.barcode, this.brand, this.amount);
    }

    @Override
    public String toString() {
        return "{title: " + title + ", brand: " + brand + ", price: " + price + ", barcode: " + barcode + ", amount: " + amount + ", || getTotal() ==> " + getTotal() + "}";
    }

    public double getTotal() {
        return Math.round((price * amount) * 100) / 100.0;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public long getBarcode() {
        return barcode;
    }

    public String getBrand() {
        return brand;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount() {
        amount++;
    }

//    @Override
//    public int compareTo(Item o) {
//        return 0;
//    }

//    public double getDiscount() {
//        return discount;
//    }
}
