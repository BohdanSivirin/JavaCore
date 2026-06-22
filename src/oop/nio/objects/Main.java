package oop.nio.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> phones = new ArrayList<>();
        List<String> phones1 = new ArrayList<>();
        List<String> phones2 = new ArrayList<>();
        Collections.addAll(phones, "+380630504878", "+380679874512", "+380508478962");
        Employee employee = new Employee(123456789, "Viktor", 2546.89, "accaunter", phones, 6);
        Collections.addAll(phones1, "+380630504238", "+380679879999", "+380338478962");
        Employee employee1 = new Employee(123456799, "Viktor", 2546.89, "director", phones, 24);
        Collections.addAll(phones2, "+380630502378", "+380679874512", "+380508478962");
        Employee employee2 = new Employee(123456711, "Viktor", 2546.89, "taunter", phones, 5);

//        boolean isSaved = Controller.save(employee);
//        System.out.println("isSaved" + isSaved);
//
//        boolean isSaved1 = Controller.save(employee1);
//        System.out.println("isSaved1" + isSaved1);
//
//        boolean isSaved2 = Controller.save(employee2);
//        System.out.println("isSaved2" + isSaved2);

//        boolean isSaved4 = Controller.save(employee);
//        System.out.println("isSaved4" + isSaved4);

        employee.setExpirience(11);
        employee.setSalary(178698.25);
        employee.setPosition("new director");
        boolean isUpdated = Controller.update(employee);
        System.out.println("isUpdated employee " + isUpdated);
        List<Employee> all = Controller.findAll();
        for(Employee e: all){
            System.out.println("\n" + e);
        }

        boolean isDeleted = Controller.delete(employee);
        System.out.println("isDeleted employee " + isDeleted);
        all = Controller.findAll();
        for(Employee e: all){
            System.out.println("\n" + e);
        }


    }
}
