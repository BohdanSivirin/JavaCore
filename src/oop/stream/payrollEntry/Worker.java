package oop.stream.payrollEntry;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Worker extends Employee {
    private final LocalDate employmentDate;
    private BigDecimal bonus;

    public Worker(int id, BigDecimal salary, Manager manager, String name, LocalDate date, LocalDate employmentDate, BigDecimal bonus) {
        super(id, salary, manager, name, date);
        this.employmentDate = employmentDate;
        this.bonus = bonus;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    @Override
    public Worker clone() {
        return new Worker(getId(),
                new BigDecimal(String.valueOf(getSalary())),
                getManager(),
                getName(),
                getBirthdate(),
                employmentDate,
                new BigDecimal(String.valueOf(bonus))
        );
    }

    public String toString() {
        return super.toString() + "\nbonus: " + bonus + "\nemployment date: " + employmentDate;
    }
}
