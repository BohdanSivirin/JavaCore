package oop.exceptions.basic.course;

import java.util.Objects;
import java.util.Random;

public class Student {
    private int id = generateId();
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    private int generateId() {
        return id = new Random().nextInt(1000000, 9999999);
    }

    @Override
    public String toString() {
        return "\nname: " + name + "\nid " + id + "\n";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Student student)) return false;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
