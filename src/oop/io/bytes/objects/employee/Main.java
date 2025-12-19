package oop.io.bytes.objects.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Document> docs = new ArrayList<>();
        ArrayList<String> phones = new ArrayList<>();
        Collections.addAll(docs, new Document(1, "DiplomaHighDegrees", 2001),
                new Document(2, "Passport", 1979));
        Collections.addAll(phones, "+380630504878", "+380679874512", "+380508478962");

        Employee employee = new Employee(
                123456789,
                "Petr",
                new Date(1923, 5, 7),
                new Address("New-York", "Manhetten", 128),
                docs,
                "accaunter", 6, phones);



        boolean isSaved = StaffController.save(employee);
        System.out.println("isSaved" + isSaved);

        boolean isUpdated = StaffController.update(employee);
        System.out.println("isUpdated" + isUpdated);

        boolean isDeleted = StaffController.delete(employee);
        System.out.println("isDeleted" + isDeleted);
    }
}
