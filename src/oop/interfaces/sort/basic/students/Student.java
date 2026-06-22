package oop.interfaces.sort.basic.students;

public class Student {
    private final String name;
    private final String surname;
    private final double studentId;
    private final int course;
    private final int aveMark;
    private final String gender;
    private final String date;

    public Student(String name, String surname, double studentId, int course, int aveMark, String gender, String date) {
        this.name = name;
        this.surname = surname;
        this.studentId = studentId;
        this.course = course;
        this.aveMark = aveMark;
        this.gender = gender;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public int getAveMark() {
        return aveMark;
    }

    public String toString() {
        return "\nname: " + name + " course: " + course + " aveMark: " + aveMark + " date: " + date;
    }
}
