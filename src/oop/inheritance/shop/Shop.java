package oop.inheritance.shop;


public class Shop {
    private final FoodDept foodDept;
    private final ToysDept toysDept;
    private final Dispatcher dispatcher;

    public Shop() {
        foodDept = new FoodDept();
        toysDept = new ToysDept();
        dispatcher = new Dispatcher();
    }

    public void addProduct(Product product) {
        dispatcher.putGoodsInDept(product);
    }


    private class Dispatcher {

        public void putGoodsInDept(Product product) {
            if (product instanceof Food) {
                Food food = (Food) product;
                foodDept.addFood(food);
            } else {
                Toy toy = (Toy) product;
                toysDept.addToy(toy);
            }
        }

        public String toString() {
            return " Vasya Dispatcher ";
        }

    }

    @Override
    public String toString() {
        return " * "+getClass().getSimpleName() + " * \n " + " * Toys Dept * \n " + toysDept + " * Food Dept * \n " + foodDept;
    }
}
