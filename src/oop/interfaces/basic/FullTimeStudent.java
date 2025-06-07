package oop.interfaces.basic;

public class FullTimeStudent extends Student{
    public FullTimeStudent(int age, String name, String university, String sportType, String instrument) {
        super(age, name, university,sportType,instrument);
    }

    public void study(){
        System.out.println("FullTime Student: "+ name + " studies 24/7 ");
    }
}
