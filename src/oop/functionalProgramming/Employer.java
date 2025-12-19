package oop.functionalProgramming;

public class Employer {
    private String name;
    private int number;
    private String position;
    private double salary;

    public Employer(String name, int number, String position, double salary) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return "name: " + name + " salary: " + salary + " number: " + number + " position: " + position;
    }

//    public String getName() {
//        return name;
//    }
//
//    public String getNumber() {
//        return String.valueOf(number);
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
    public double getSalary() {
        return salary;
    }
}
