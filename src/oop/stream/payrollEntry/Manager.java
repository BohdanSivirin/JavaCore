package oop.stream.payrollEntry;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Manager extends Worker {
    private List<Employee> subordinates = new ArrayList<>();
    private Set<Employee> allSubordinates = new HashSet<>();

    public Manager(int id, BigDecimal salary, Manager manager, String name, LocalDate date, LocalDate employmentDate, BigDecimal bonus) {
        super(id, salary, manager, name, date, employmentDate, bonus);
    }

    public Manager(int id, String name) {
        super(id, name);
    }

    public Manager clone() {
        Manager cloneManager = new Manager(getId(),
                new BigDecimal(String.valueOf(getSalary())),
                getManager(),
                getName(),
                getBirthdate(),
                getEmploymentDate(),
                new BigDecimal(String.valueOf(getBonus()))
        );
        subordinates.forEach(e -> cloneManager.subordinates.add((Employee) e.clone()));
        allSubordinates.forEach(e -> cloneManager.allSubordinates.add((Employee) e.clone()));
        return cloneManager;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public Set<Employee> getAllSubordinates() {
        return allSubordinates;
    } // непосредственные

    public void addEmployee(Employee e) {
        if (e != null) {
            subordinates.add(e);
            allSubordinates.add(e);
        }
        if (e instanceof Manager manager) {
            allSubordinates.addAll((manager.allSubordinates));
        }
    }

    public void printAllSubordinates(Set<Employee> list) {
        list.forEach(e -> System.out.println("AllSubordinates list: " + e + ",\n"));
    }

    public void printSubordinates(List<Employee> list) {
        list.forEach(e -> System.out.println("Subordinates list: " + e + ",\n"));
    }

}
