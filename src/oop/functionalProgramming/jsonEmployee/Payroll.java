package oop.functionalProgramming.jsonEmployee;

public class Payroll {
    private int employeeId;
    private double sum;

    public Payroll(int employeeId, double sum) {
        this.employeeId = employeeId;
        this.sum = sum;
    }

    public String toString() {
        return "employeeId " + employeeId + " sum " + sum;
    }

}



