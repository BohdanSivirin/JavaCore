package oop.exceptions.basic.course;

import java.util.ArrayList;

public abstract class Course {
    private final String title;
    private final String prof;
    private final Boolean isStarted;
    private final Boolean isFinished;
    private final int minStudents;
    private final int maxStudents;
    private int currentStudents = 25;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String title, String prof, Boolean isStarted, Boolean isFinished, int minStudents, int maxStudents) {
        this.title = title;
        this.prof = prof;
        this.isStarted = isStarted;
        this.isFinished = isFinished;
        this.minStudents = minStudents;
        this.maxStudents = maxStudents;
    }

    public void addStudent(Student student) throws CourseHandledException {
        if (isStarted) throw new CourseHandledException("Error - This course is started");
        if (isFinished) throw new CourseHandledException("Error - This course is finished");
        if (currentStudents == maxStudents) throw new CourseHandledException("Error - No free place at this course");
        if (students.contains(student)) throw new CourseHandledException("Error - This course already taken");
        students.add(student);
        currentStudents++;
    }

    public void removeStudent(Student student) throws CourseHandledException {
        if (isFinished) throw new CourseHandledException("Error - This course is finished");
        if (!students.contains(student)) throw new CourseHandledException("Error - Student isn't found ");
        students.remove(student);
        currentStudents--;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Course{" +
               "title='" + title + '\'' +
               ", prof='" + prof + '\'' +
               ", isStarted=" + isStarted +
               ", isFinished=" + isFinished +
               ", minStudents=" + minStudents +
               ", maxStudents=" + maxStudents +
               ", currentStudents=" + currentStudents +
               '}';
    }
}
