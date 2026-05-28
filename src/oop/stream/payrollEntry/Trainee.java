package oop.stream.payrollEntry;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Trainee extends Employee {
    private final LocalDate startDate;
    private final int practiceLength;

    public Trainee(int id, BigDecimal salary, Manager manager, String name, LocalDate date, LocalDate startDate, int practiceLength) {
        super(id, salary, manager, name, date);
        this.startDate = startDate;
        this.practiceLength = practiceLength;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getPracticeLength() {
        return practiceLength;
    }

    public String toString() {
        return super.toString() + "\npractice length: " + practiceLength + "\nwork start date: " + startDate;
    }

    public Trainee clone() {
        return new Trainee(getId(),
                new BigDecimal(String.valueOf(getSalary())),
                getManager(),
                getName(),
                getBirthdate(),
                startDate,
                practiceLength
        );
    }
}
