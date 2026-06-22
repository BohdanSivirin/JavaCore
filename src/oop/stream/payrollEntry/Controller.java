package oop.stream.payrollEntry;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    public static final Path path = Path.of("streamPayRollData/payData.txt");
    public static final Path data = Path.of("EmployeeData/data.txt");


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
        return getPayrollEntryForEachEmployee(list)
                .stream()
                .distinct()
                .filter(payrollEntry -> payrollEntry.getEmployee() instanceof Manager && (payrollEntry.getSalaryPlusBonus().compareTo(edgeSum) > 0))
                .map(payrollEntry -> (Manager) payrollEntry.getEmployee())
                .toList();
    }

    //найти сонтудника с наименьшим стажем работы
    public static List<Worker> getEmployeeWithMinExp(List<Employee> list) {
        LocalDate localDate = list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Worker)
                .map(employee -> ((Worker) employee).getEmploymentDate())
                .min((d1, d2) -> d2.compareTo(d1))
                .get();

        return list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Worker)
                .map(employee -> ((Worker) employee))
                .filter(w -> w.getEmploymentDate().isEqual(localDate))
                .collect(Collectors.toList());
    }

    //сохранить в текстовый файл все начисления (Пейролы) сотрудников
    public static void saveEmployeePayrollDataToTxtFile(List<Employee> list) {
        try {
            Files.writeString(
                    path,
                    getPayrollEntryForEachEmployee(list)
                            .stream()
                            .map(payrollEntry -> payrollEntry.toString())
                            .reduce((s1, s2) -> s1 + s2)
                            .get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        try (BufferedWriter bw = new BufferedWriter(Files.newBufferedWriter(path, options))) {
//            bw.append(getPayrollEntryForEachEmployee(list).toString());
//        } catch (IOException e){
//            e.printStackTrace();
//        }
    }

    //считать с помощью стрима пейролы с файла
    public static List<PayrollEntry> getEmployeePayrollDataFromTxtFile() {

        try {
            return Files.lines(path).map(lines -> {
                String[] line = lines.split(" ");
                int id = Integer.valueOf(line[1]);
                String position = line[3];
                String name = line[5];
                BigDecimal salaryAndBonus = new BigDecimal(line[7]);

                Employee e = switch (position) {
                    case "Worker" -> new Worker(id, name);
                    case "Manager" -> new Manager(id, name);
                    case "Trainee" -> new Trainee(id, name);
                    default -> throw new IllegalStateException("Unexpected value: " + position);
                };
                return new PayrollEntry(e, salaryAndBonus, BigDecimal.ZERO);
            }).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    //найти сотрудников, зарабатывающих выше среднего
    public static Set<Employee> getEmployeeWithSalaryMoreThanAverage(List<Employee> list) {
        BigDecimal totalSum = getPayrollEntryForEachEmployee(list)
                .stream()
                .map(payrollEntry -> payrollEntry.getSalaryPlusBonus())
                .reduce((sb1, sb2) -> sb1.add(sb2))
                .get();

        BigDecimal average = totalSum.divide(BigDecimal.valueOf(list.size()));

        return getPayrollEntryForEachEmployee(list)
                .stream()
                .filter(payrollEntry -> payrollEntry.getSalaryPlusBonus().compareTo(average) > 0)
                .map(payrollEntry -> payrollEntry.getEmployee())
                .collect(Collectors.toSet());
    }

    // найти минимальный бонус но только у ненеджеров
    public static BigDecimal getMinBonusOnlyManagers(List<Employee> list) {
        return ((Manager) list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Manager manager)
                .min((m1, m2) -> ((Manager) m1).getBonus().compareTo(((Manager) m2).getBonus()))
                .get())

                .getBonus();
    }

    //найти  сотрудников, имеющих менее стольки-то подчиненных, вывести того, кто заработал меньше всех
    public static List<Employee> getEmployeeWithSomeNumberOfSubordinatesAndMinMoney(List<Employee> list, int subValue) {
        BigDecimal currentEmployeeSalaryAndBonus = getPayrollEntryForEachEmployee(list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Trainee ||
                                    employee instanceof Worker ||
                                    (employee instanceof Manager manager && manager.getSubordinates().size() < subValue))
                .toList())
                .stream()
                .min((p1, p2) -> p1.getSalaryPlusBonus().compareTo(p2.getSalaryPlusBonus()))
                .get()
                .getSalaryPlusBonus();

        return getPayrollEntryForEachEmployee(list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Trainee ||
                                    employee instanceof Worker ||
                                    (employee instanceof Manager manager && manager.getSubordinates().size() < subValue))
                .toList())
                .stream()
                .filter(payrollEntry -> payrollEntry.getSalaryPlusBonus().compareTo(currentEmployeeSalaryAndBonus) == 0)
                .map(payrollEntry -> payrollEntry.getEmployee())
                .toList();
    }

    //определить количество сотрудников каждой должности
    public static Map<String, Long> calculateAllEmployeesByPosition(List<Employee> list) {
        return list
                .stream()
                .distinct()
                .collect(Collectors.groupingBy(employee -> employee.getClass().getSimpleName(), Collectors.counting()));
    }

    //записать в текстовый файл данные (имя фамилия - должность - заработок)
    public static void saveEmployeeDataNamePositionSalaryAndBonusToFile(List<Employee> list) {
        OpenOption[] options = {StandardOpenOption.CREATE, StandardOpenOption.WRITE};
        try (BufferedWriter bufferedWriter = new BufferedWriter(Files.newBufferedWriter(data, options))) {
            getPayrollEntryForEachEmployee(list)
                    .stream()
                    .distinct()
                    .forEach(payrollEntry -> {
                        try {
                            bufferedWriter.append(payrollEntry.getEmployee().getName())
                                    .append(" - ")
                                    .append(payrollEntry.getEmployee().getClass().getSimpleName())
                                    .append(" - ")
                                    .append(String.valueOf(payrollEntry.getSalaryPlusBonus()))
                                    .append("\n");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dublicate_saveEmployeeDataNamePositionSalaryAndBonusToFile(List<Employee> list) {
        try {
            Files.writeString(
                    data,
                    getPayrollEntryForEachEmployee(list)
                            .stream()
                            .map(payrollEntry -> payrollEntry.getEmployee().getName()
                                                 + " - "
                                                 + payrollEntry.getEmployee().getClass().getSimpleName()
                                                 + " - "
                                                 + payrollEntry.getSalaryPlusBonus()
                                                 + "\n")
                            .reduce((s1, s2) -> s1 + s2)
                            .get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
