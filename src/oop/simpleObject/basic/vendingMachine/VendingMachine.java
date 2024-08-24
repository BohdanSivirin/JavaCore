package oop.simpleObject.basic.vendingMachine;

import java.util.Scanner;

public class VendingMachine {
    private Product[] products = new Product[4];
    Scanner scanner = new Scanner(System.in);

    public VendingMachine() {
        Product cola = new Product("cola", 5, 1, 5);
        Product pepsi = new Product("pepsi", 6, 3, 5);
        Product snikers = new Product("snikers", 12, 4, 20);
        Product gum = new Product("buble gum", 2, 8, 100);
        products[0] = cola;
        products[1] = pepsi;
        products[2] = snikers;
        products[3] = gum;
        menu();
    }

    private void menu() {
        System.out.println(" 1 -> Выбрать товар ");
//        System.out.println(" 2 -> Посчитать сдачу ");
//
//        System.out.println(" 3 -> Пополнить ресуры ");
        System.out.println(" 4 -> Выйти ");
        int a = scanner.nextInt();
        switch (a) {

            case 1 -> calculateMoney();
            //case 2 -> calculateChange();
            //case 3 -> fill();
            case 4 -> {
                return;
            }
        }
        menu();
    }

    private void printProduct() {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getCurrentAmount() != 0) {
                System.out.println(i + " " + products[i].getTitle());
            }
        }
    }

    //1 - распечатать список достпуных к покупке товаров т.е не ноль
    //2 - Сначала выбираем товар уникальный, можно изменить кол-во при покупке
    //3 - Показхываем кол-во денег к оплате
    //4 принимаем деньги, купюры 1,2,5,100 бумажные, без центов
    //5 цена товара целыми
    //6 водишь купюры до тех пор пока сумма не равна стоимости товара или больше......после выпадает товар из машины и сдача

    //ф-я покупки товара
    //ф-я проверки вкинутой налички
    //ф-я расчета сдачи, если вкинуто больше суммы товара

    // выбираем товар + количество, получаем итоговую сумму к оплате
    private int chooseProduct() {
        System.out.println("************************");
        printProduct();
        int productAmount;
        System.out.println(" Выберите товар : ");
        int productName = scanner.nextInt();
        do {
            System.out.println(" В наличии - " + products[productName].getCurrentAmount() + " едениц товара ");
            System.out.println(" Хотите продолжить покупки - 1, или выйти - 2 ");
            int a = scanner.nextInt();
            if (a != 1) {
                menu();
            }
            System.out.println(" Введите кол-во товара : ");
            productAmount = scanner.nextInt();
        } while (productAmount <= 0 || productAmount > products[productName].getCurrentAmount());
        System.out.println(" Выбран товар : " + products[productName].getTitle() + " в количестве :" + productAmount);
        return productAmount * products[productName].getPrice();
    }

    // считаем полученные деньги за товар
    private void calculateMoney() {
        int sum = chooseProduct();
        int allMoney = 0;
        while (allMoney <= sum) {
            int money;
            System.out.println(" Автомат принимает купюры номиналом 1, 2, 5, 10, 20, 50, 100 $ ");
            System.out.println(" Киньте денюшку, общая сумма к оплате = " + sum);
            money = scanner.nextInt();
            if (!(money == 1 || money == 2 || money == 5 || money == 10 || money == 20 || money == 50 || money == 100)) {
                System.out.println(" Некорректный номинал ");
            } else allMoney = allMoney + money;
//            System.out.println(" allMoney = " + allMoney);
//            System.out.println(" money - " + money);
        }
        System.out.println(" allMoney = " + allMoney);
        int change = allMoney - sum;
        calculateChange(change);
    }

    private void calculateChange(int change) {

        int amount100 = change / 100;
        if (amount100 != 0) {
            System.out.println(" Выдаем сдачу 100 $ = " + amount100 + " купюр ");
            change = change - amount100 * 100;
        }
        int amount50 = change / 50;
        if (amount50 != 0) {
            System.out.println(" Выдаем сдачу 50 $ = " + amount50 + " купюр ");
            change = change - amount50 * 50;
        }
        int amount20 = change / 20;
        if (amount20 != 0) {
            System.out.println(" Выдаем сдачу 20 $ = " + amount20 + " купюр ");
            change = change - amount20 * 20;
        }
        int amount10 = change / 10;
        if (amount10 != 0) {
            System.out.println(" Выдаем сдачу 10 $ = " + amount10 + " купюр ");
            change = change - amount10 * 10;
        }
        int amount5 = change / 5;
        if (amount5 != 0) {
            System.out.println(" Выдаем сдачу 5 $ = " + amount5 + " купюр ");
            change = change - amount5 * 5;
        }
        int amount2 = change / 2;
        if (amount2 != 0) {
            System.out.println(" Выдаем сдачу 2 $ = " + amount2 + " купюр ");
            change = change - amount2 * 2;
        }
        if (change != 0) {
            System.out.println(" Выдаем сдачу 1 $ =" + change + " купюр ");
        }
    }

// считаем сдачу

//        if(money !=1&&money !=2&&money !=5&&money !=10&&money !=20)
//
//    {
//        System.out.println(" Киньте денюшку, общая сумма к оплате = " + sum);
//        money = 0;
//    }
//
//        while(money<sum)
//
//    {
//        System.out.println(" Киньте денюшку, внесенная сумма = " + money + ", а необходимая сумма = " + sum);
//        money = money + scanner.nextInt();
//    }
//        if(money ==sum)
//
//    {
//        System.out.println(" Товар куплен! Заберите товар " + products[productName].getTitle() + " в корзинке ");
//    }
//        if(money >sum)
//
//    {
//        int change = money - sum;
//        System.out.println(" Товар куплен! Заберите товар " + products[productName].getTitle() + " в корзинке, Сдача составила = " + change);
//    }
//
//    products[productName].
//
//    setCurrentAmount(products[productName].getCurrentAmount() -productAmount);
//}
//
//private void fill() {
//    System.out.println(" Какой товар пополнить? ");
//    System.out.println("************************");
//    printProduct();
//    int a = scanner.nextInt();
//    System.out.println(" Введи кол-во ");
//    int amount = scanner.nextInt();
//    if (amount + products[a].getCurrentAmount() <= products[a].getMaxAmount()) {
//        products[a].setCurrentAmount(amount);
//        System.out.println(" Новое кол-во продукта " + products[a].getTitle() + " " + products[a].getCurrentAmount());
//    } else {
//        amount = products[a].getMaxAmount();
//        products[a].setCurrentAmount(amount);
//        System.out.println(" Новое кол-во продукта " + products[a].getCurrentAmount());
//    }
//}

}
