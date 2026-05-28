package oop.stream.payrollEntry;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public abstract class Employee extends Person {
    private final int id;
    private final BigDecimal salary;
    private final Manager manager;

    public Employee(int id, BigDecimal salary, Manager manager, String name, LocalDate date) {
        super(name, date);
        this.salary = salary;
        this.manager = manager;
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Manager getManager() {
        return manager;
    }

    public abstract Object clone();

    public String toString() {
        return super.toString() + "\nid: " + id + "\nsalary: " + salary + "\nmanager: " + manager;
    }

    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) return false;
        return this.id == ((Employee) o).id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        return 17 * hashCode + Integer.hashCode(id);
    }

    public int getId() {
        return id;
    }


}
