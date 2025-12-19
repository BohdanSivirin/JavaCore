package oop.io.bytes.objects.employee;

import java.io.Serializable;

public class Document implements Serializable {
    private int number;
    private String title;
    private int year;

    public Document(int number, String title, int year) {
        this.number = number;
        this.title = title;
        this.year = year;
    }
}
