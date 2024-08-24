package oop.simpleObject.basic.dog;

public class Dog {
    private String breed;  //field
    private double weight;
    private int age;
    private boolean isVactinated = true;

    public Dog(boolean vactination, double weight, String initBreed, int initAge) {
        System.out.println(this);
        this.info();
        age = initAge;
        this.weight = weight;
        this.breed = initBreed;
        isVactinated = vactination;
    }
    public Dog(double weight, int age) {
        this.age = age;
        this.weight = weight;
    }

    public Dog() {
        age = 10;
        weight = 11;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBreed(String initBreed) {
        breed = initBreed;
    }

    public boolean isVactinated() {
        return isVactinated;
    }

    public void run(int speed) { // method
        System.out.println("Собака " + this.breed + " с скоростью " + speed);
    }

    public void eat(String meal, double mealWeight) {
        System.out.println("Собака ест " + meal);
        digest(meal);
        weight = weight + mealWeight;
        System.out.println("Теперь вес собаки " + weight);
    }

    private void digest(String meal) {
        System.out.println("Идет переваривание " + meal);
    }

    public void info() {
        System.out.println("Порода " + breed);
        System.out.println("Вес " + weight);
        System.out.println("Возраст " + age);
        System.out.println("Вакцинирована ? " + isVactinated);

    }
}
