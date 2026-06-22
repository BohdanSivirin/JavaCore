package oop.nio.objects;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static final Path path = Path.of("NioDir/objects/employeeList.obj");

    public static boolean saveAll(List<Employee> employeeList) {
        OpenOption[] options = {StandardOpenOption.CREATE, StandardOpenOption.WRITE};
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path, options))) {
            objectOutputStream.writeObject(employeeList);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Employee> findAll() {
        OpenOption[] options = {StandardOpenOption.READ};
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path, options))) {
            return (List<Employee>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static boolean save(Employee employee) {
        List<Employee> list = findAll();
        return !list.contains(employee) && list.add(employee) && saveAll(list);
    }

    public static boolean update(Employee employee) {
        List<Employee> list = findAll();
        return list.remove(employee) && list.add(employee) && saveAll(list);
    }

    public static boolean delete(Employee employee) {
        List<Employee> list = findAll();
        return list.remove(employee) && saveAll(list);
    }


}




