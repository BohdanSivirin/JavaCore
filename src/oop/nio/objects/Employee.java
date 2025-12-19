package oop.nio.objects;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
    private long id;
    private String name;
    private double salary;
    private String position;
    private List<String> phonesNumber;
    private int expirience;

    public Employee(long id, String name, double salary, String position, List<String> phonesNumber, int expirience) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.phonesNumber = phonesNumber;
        this.expirience = expirience;
    }

    public String toString() {
        return "\nname: " + name + " salary: " + salary + " position: " + position + " exp: " + expirience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhonesNumber(List<String> phonesNumber) {
        this.phonesNumber = phonesNumber;
    }

    public void setExpirience(int expirience) {
        this.expirience = expirience;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Employee employee)) {
            return false;
        }
        return employee.id == id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 17 * hashCode + Long.hashCode(id);
        return hashCode;
    }

}
