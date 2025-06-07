package oop.interfaces.sort.basic.students;

import java.util.Comparator;

public class ByAveMark implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAveMark() - o2.getAveMark();
    }
}
