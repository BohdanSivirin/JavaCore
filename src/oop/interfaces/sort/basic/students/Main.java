package oop.interfaces.sort.basic.students;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Student student = new Student("Petro", "Petrovsky", 1.12, 1, 4, "male", "01/01/91");
        Student student1 = new Student("Vasya", "Pupkin", 2.15, 2, 5, "male", "02/03/89");
        Student student2 = new Student("Jack", "Nikolson", 3.45, 3, 3, "male", "21/06/68");
        Student student3 = new Student("Tom", "Hardy", 5.56, 4, 2, "male", "13/01/93");
        Student student4 = new Student("luis", "Vitonovich", 7.78, 5, 4, "female", "03/05/06");
        Student student5 = new Student("Kiril", "Kirilych", 1.12, 1, 4, "male", "01/01/91");
        Student student6 = new Student("Mike", "Tyson", 9.56, 1, 1, "male", "10/09/87");
        Student student7 = new Student("Elena", "Miroshnik", 1.13, 3, 2, "female", "31/12/12");
        Student student8 = new Student("Natalya", "Shepetivska", 9.09, 1, 4, "female", "19/09/66");


        ArrayList<Student> students = new ArrayList<>();
        Collections.addAll(students, student, student1, student2, student3, student4, student5, student6, student7, student8);
//        Collections.sort(students, new ByCourse());
        Scanner scanner = new Scanner(System.in);
        for(;;){
            switch (scanner.nextInt()){
                case 1-> Collections.sort(students, new ByNameAscComparator());
                case 2-> Collections.sort(students, new ByNameDescComparator());
                case 3-> Collections.sort(students, new ByCourse());
                case 4-> Collections.sort(students, new ByAveMark());
                case 5-> Collections.sort(students, new ByDate());
//                case 6-> System.exit(0);
            }
            System.out.println(students);
        }
    }
}
