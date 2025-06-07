package oop.interfaces.basic;

public abstract class Student extends Person implements Musician, Sportsman {
    private final String university;
    private String sportType;
    private String instrument;

    public Student(int age, String name, String university, String sportType, String instrument) {
        super(age, name);
        this.university = university;
        this.sportType = sportType;
        this.instrument = instrument;
    }

    public void study() {
        System.out.println("Student: " + name + " is study");
    }

    @Override
    public void playMusic() {
        System.out.println("Student: " + name + " is playing music like Musician. Instrument: " + instrument);

    }

    @Override
    public void repetition() {
        Musician.super.repetition();
    }

    @Override
    public void train() {
        System.out.println("Student: " + name + " is training like Sportsman. Sport type is " + sportType);

    }
}
