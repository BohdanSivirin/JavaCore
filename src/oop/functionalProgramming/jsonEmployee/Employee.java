package oop.functionalProgramming.jsonEmployee;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;
    private String position;
    private int exp;

    public Employee(int id, String name, double salary, int age, String position, int exp) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.position = position;
        this.exp = exp;
    }

    public String toString() {
        return "id " + id + "\nname " + name + "\nsalary " + salary + "\nage " + age + "\nposition " + position + "\nexp " + exp;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public int getExp() {
        return exp;
    }
}
