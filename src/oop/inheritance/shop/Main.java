package oop.inheritance.shop;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Meat meat = new Meat(450.35, 132.25, 10.55, 178.00);
        Banana banana = new Banana(88.52, 150, 2.10, 67.13);
        Nut nut = new Nut(854.99, 450.15, 8.5, 365.77);
        Barby barby = new Barby("Klava", "Barby", 45.12, 6, Map.of("Dress", 5, "Shoes", 3, "Purse", 2));
        Constructor constructor = new Constructor("Castle", "Lego", 652.25, 9, Map.of("roof", 5, "whell", 4, "panel", 8));

        Shop shop = new Shop();
        shop.addProduct(meat);
        shop.addProduct(constructor);
        shop.addProduct(banana);
        shop.addProduct(nut);
        shop.addProduct(barby);
        shop.addProduct(meat);
        shop.addProduct(constructor);
        System.out.println(shop);

    }
}
