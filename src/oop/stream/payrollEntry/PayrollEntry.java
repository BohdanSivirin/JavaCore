package oop.stream.payrollEntry;

import java.math.BigDecimal;

public class PayrollEntry {
    private final Employee employee;
    private final BigDecimal salaryPlusBonus;

    public PayrollEntry(Employee employee, BigDecimal salary, BigDecimal bonus) {
        this.employee = employee;
        this.salaryPlusBonus = (salary == null ? BigDecimal.ZERO : salary).add(bonus == null ? BigDecimal.ZERO : bonus);
    }

    public Employee getEmployee() {
        return employee;
    }

    public BigDecimal getSalaryPlusBonus() {
        return salaryPlusBonus;
    }

    public String toString() {
        return "id " + employee.getId() + " position " + employee.getClass().getSimpleName() + " name " + employee.getName() + " salary+bonus " + salaryPlusBonus + " $\n";
    }
}
