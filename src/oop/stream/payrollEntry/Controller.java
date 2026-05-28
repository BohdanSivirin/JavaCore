package oop.stream.payrollEntry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    //принимаем список сотрудников и возвращаем список пейролов, для них всех без дубликатов
    public static List<PayrollEntry> getPayrollEntryForEachEmployee(List<Employee> list) {
        return list
                .stream()
                .distinct()
                .map(employee -> new PayrollEntry(
                        employee,
                        employee.getSalary(),
                        employee instanceof Worker worker ? worker.getBonus() : BigDecimal.ZERO)
                )
                .collect(Collectors.toList());
    }

    //подготовить список пейролов для подчиненных конкретного менеджера (менеджер передается)
    public static List<PayrollEntry> getPayrollEntryForParticularManager(Manager manager) {
        if (manager.getSubordinates().isEmpty()) {
            return new ArrayList<>();
        }
        return getPayrollEntryForEachEmployee(manager.getSubordinates());
    }

    //найти общую стоимость всех бонусов
    public static BigDecimal calculateTotalBonus(List<Employee> list) {
        return list
                .stream()
                .distinct()
                .map(employee -> employee instanceof Worker worker ? (worker.getBonus() == null ? BigDecimal.ZERO : worker.getBonus()) : BigDecimal.ZERO)
                .reduce((b1, b2) -> b1.add(b2))
                .get();
    }

    //найти всех менеджеров, зарабатывающих больше такойто суммы (сумма передается)
    public static List<Manager> getManagersWithSalaryMoreThan(List<Employee> list, BigDecimal edgeSum) {
        return list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Manager)
                .filter(m -> (m.getSalary().compareTo(edgeSum) > 0))
                .map(employee -> (Manager) employee)
                .toList();
    }


}
