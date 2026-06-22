package oop.interfaces.basic;

public class PartTimeStudent extends Student implements Tractorist {
    public PartTimeStudent(int age, String name, String university,String sportType, String instrument) {
        super(age, name, university,sportType,instrument);
    }

    public void notStudy() {
        System.out.println("PartTime Student: " + name + " is not study ");
    }

    @Override
    public void driveTractor() {
        System.out.println("PartTime Student:" + name + " is driving tractor ");
    }

    @Override
    public void drive() {
        System.out.println("PartTime Student:" + name + " can drive");
    }

    @Override
    public void fix() {
        System.out.println("PartTime Student:" + name + " fix ");
    }
}
