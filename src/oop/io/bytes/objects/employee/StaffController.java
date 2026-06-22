package oop.io.bytes.objects.employee;

import java.io.*;
import java.util.ArrayList;

public class StaffController {

    public static boolean save(Employee employee) {
        ArrayList<Employee> employees = findAll();
        // return !employees.contains(employee) ? employees.add(employee) && saveAll(employees) : false;
        return !employees.contains(employee) && employees.add(employee) && saveAll(employees);
    }

    public static ArrayList<Employee> findAll() {
        ArrayList<Employee> employees = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Employee.obj"))) {
            try {
                while (true) {
                    employees.add((Employee) objectInputStream.readObject());
                }
            } catch (EOFException e) {

            }
            return employees;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static boolean saveAll(ArrayList<Employee> employees) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Employee.obj"))) {
            for (Employee e : employees) {
                objectOutputStream.writeObject(e);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete(Employee employee) {
        ArrayList<Employee> employees = findAll();
        return employees.remove(employee) && saveAll(employees);
    }

    public static boolean update(Employee employee) {
        ArrayList<Employee> employees = findAll();
        //return employees.remove(employee) ? employees.add(employee) && saveAll(employees) : false ;
        return employees.remove(employee) && employees.add(employee) && saveAll(employees);
    }

}

