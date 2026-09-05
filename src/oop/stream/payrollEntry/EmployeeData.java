package oop.stream.payrollEntry;

import java.io.Serializable;

public record EmployeeData(String name, String position, int age) implements Serializable {

}
