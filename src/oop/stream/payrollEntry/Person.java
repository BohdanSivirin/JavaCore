package oop.stream.payrollEntry;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

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

    public int getAge(){
        return Period.between(getBirthdate(), LocalDate.now()).getYears();
    }

    public String getAgeRange() {
        int age = Period.between(birthdate, LocalDate.now()).getYears();

        if (age >= 20 && age < 30) {
            return "20 - 30";
        } else if (age >= 30 && age < 40) {
            return "30 - 40";
        } else if (age >= 40 && age < 50) {
            return "40 - 50";
        } else if (age >= 50) {
            return "от 50";
        }
        return "до 20";
    }

}
