package oop.stream.payrollEntry;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public abstract class Person {
    private final String name;
    private final LocalDate birthdate;

    public Person(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String toString() {
        return "\nname: " + name + "\nbirthday: " + birthdate;
    }

}
