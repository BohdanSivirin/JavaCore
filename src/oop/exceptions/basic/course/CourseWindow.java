package oop.exceptions.basic.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CourseWindow {
    private final ArrayList<Course> courses = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Course selectedCourse = null;

    public CourseWindow() {
        Collections.addAll(courses, new CourseC(), new CourseJava(), new CourseKotlin());
        menu();
    }

    private void menu() {
        System.out.println("\nMenu:\n1 - choose\n2 - take a course\n3 - leave a course \n4 - exit");
        try {
            switch (scanner.nextInt()) {
                case 1 -> choose();
                case 2 -> take();
                case 3 -> leave();
                case 4 -> System.exit(0);
            }
        } catch (CourseHandledException | CourseUnHandledException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Incorrect data input");
            scanner = new Scanner(System.in);
        }
        menu();
    }

    private void choose() {
        String value = "";
        System.out.println("\nChoose the course you want to take:\n1 - Java\n2 - C++\n3 - Kotlin\n4 - Menu");
        switch (scanner.nextInt()) {
            case 1 -> value = "Java";
            case 2 -> value = "C++";
            case 3 -> value = "Kotlin";
        }
        for (Course course : courses) {
            if (course.getTitle().equals(value)) {
                selectedCourse = course;
                System.out.println("Course: " + selectedCourse.getTitle() + " is chosen");
            }
        }
    }

    private void leave() throws CourseHandledException {
        System.out.println("Write student's name: ");
        selectedCourse.removeStudent(new Student(scanner.next()));
        System.out.println("Student left the course");
    }

    private void take() throws CourseHandledException {
        System.out.println("Write student's name: ");
        selectedCourse.addStudent(new Student(scanner.next()));
        System.out.println("Student added to the course");
    }

}
