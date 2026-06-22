package oop.interfaces.sort.basic.students;

import java.util.Comparator;

public class ByDate implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getDate().compareTo(o1.getDate());

    }
}
