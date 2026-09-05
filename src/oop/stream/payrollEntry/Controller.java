package oop.stream.payrollEntry;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {
    public static final Path path = Path.of("streamPayRollData/payData.txt");
    public static final Path data = Path.of("EmployeeData/data.txt");
    private static final Path object = Path.of("streamPayRollData/employeeDataObject.obj");


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

    // находим в файле должность с наибольшим заработком
    public static List<String> getEmployeeWithHighestSalaryAndBonusFromFile() {
        try {
            String maxSalaryAndBonus = Files
                    .lines(data)
                    .max((l1, l2) ->
                            new BigDecimal(l1.split(" ")[4])
                                    .compareTo(new BigDecimal(l2.split(" ")[4])))
                    .get();

            return Files
                    .lines(data)
                    .filter(l -> l
                                         .split(" ")[4]
                                         .compareTo(maxSalaryAndBonus) == 0)
                    .toList();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    //найти топ-3 сотрудника з наибольшей зарплатой
    public static List<Employee> getThreeEmployeeWithHighestSalary(List<Employee> list) {
        return list
                .stream()
                .distinct()
                .sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary()))
                .limit(3)
                .toList();
    }

    //вывести в обектный файл данные про сотрудника (имя фамилия должность и возраст)
    public static void saveDataToFile(List<Employee> list) {
        OpenOption[] options = {StandardOpenOption.CREATE, StandardOpenOption.WRITE};
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(object, options))) {
            List<EmployeeData> employeeData = list
                    .stream()
                    .distinct()
                    .map(employee -> new EmployeeData(employee.getName(), employee.getClass().getSimpleName(), employee.getAge()))
                    .toList();
            outputStream.writeObject(employeeData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //найти в объектном файле всех сотрудников таких-то должностей старше стольки-то лет
    public static List<EmployeeData> findAllEmployeeParticularPositionAndAge(List<String> positions, int age) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(object, StandardOpenOption.READ))) {
            return ((List<EmployeeData>) objectInputStream
                    .readObject())
                    .stream()
                    .filter(employeeData -> employeeData.age() >= age && positions.contains(employeeData.position()))
                    .toList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }

    // найти всех стажеров, практика которых длится больше стольки-то дней
    public static List<Trainee> getTraineeWithCurrentPracticalDays(List<Employee> list, int num) {
        return list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Trainee trainee && trainee.getPracticeLength() > num)
                .map(employee -> ((Trainee) employee))
                .toList();
    }

    //проверить или все работники совершеннолетние (21+)
    public static boolean isAllEmployeeAdults(List<Employee> list) {
        return list.stream().allMatch(employee -> employee.getAge() >= 21);
    }
//проверить или у нас среди работников есть хоть один стажер

    public static boolean isAnyOfEmployeeTrainee(List<Employee> list) {
        return list.stream().anyMatch(employee -> employee instanceof Trainee);
    }

    //найти всех работников, у которых день рождения в текущем месяце
    public static List<Employee> getEmployeeWithParticularMonthBirthday(List<Employee> list) {
        return list
                .stream()
                .filter(employee -> employee.getBirthdate().getMonth().equals(LocalDate.now().getMonth()))
                .toList();
    }

    //найти третьего по величене зароботка сотрудника
    public static Employee getThirdHighestSalaryAndBonusEmployee(List<Employee> list) {
//        getPayrollEntryForEachEmployee(list)
//                .stream()
//                .sorted((p1, p2) -> p2.getSalaryPlusBonus().compareTo(p1.getSalaryPlusBonus()))
//                .limit(3)
//                .forEach(payrollEntry -> System.out.println(payrollEntry));

        return getPayrollEntryForEachEmployee(list)
                .stream()
                .sorted((p1, p2) -> p2.getSalaryPlusBonus().compareTo(p1.getSalaryPlusBonus()))
                .skip(2)
                .findFirst()
                .orElse(null)
                .getEmployee();
    }

    //найти четырех самых молодых сотрудников, вернуть в виде имя- должность- возраст
    public static List<String> getListWithFourthTheYoungestEmployees(List<Employee> list) {
//        list
//                .stream()
//                .distinct()
//                .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
//                .forEach(employee -> System.out.println(" " + employee.getId() + employee.getClass().getSimpleName() + employee.getName() + employee.getAge() + "\n"));
        return list
                .stream()
                .distinct()
                .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .limit(4)
                .map(e -> e.getName() + "-" + e.getClass().getSimpleName() + "-" + e.getAge())
                .toList();
    }

    //найти список всех подчиненных всех менеджеров без повторов
    public static Set<Employee> getAllSubordinates(List<Employee> list) {
        return list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Manager manager)
                .flatMap(employee -> ((Manager) employee).getAllSubordinates().stream())
                .collect(Collectors.toSet());
    }

    //найти сотрудника с наибольшим количеством подчиненных
    public static Employee getEmployeeWithMaxSubordinates(List<Employee> list) {
        return list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Manager manager)
                .map(employee -> (Manager) employee)
                .max((Comparator.comparingInt(m -> m.getAllSubordinates().size())))
                .orElse(null);
    }

    //найти сумму всех бонусов сотрудников, у которых стаж работы больше стольки-то и имеют в подчинении не меннее стольки-то непосредственных подчиненных
    public static BigDecimal getTotalBonusSumAllEmployeeWithCurrentExpAndSubordinatesNumber(List<Employee> list, int exp, int subordinates) {
        return list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Manager manager
                                    && manager.getSubordinates().size() >= subordinates
                                    && (Period.between(manager.getEmploymentDate(), LocalDate.now())).getYears() > exp)
                .map(employee -> ((Manager) employee).getBonus())
                .reduce((BigDecimal::add))
                .orElse(null);
    }

    //найти сумму всех цифр в файле пейДата (или любом другом)
    public static Integer calculateAllSum(Path path) throws IOException {
//        return Files
//                .readString(path)
//                .codePoints()
//                .filter(value -> Character.isDigit(value))
//                .forEach(value -> System.out.println(value-48));
//                .map(operand -> operand - 48)
//                .reduce((v1, v2) -> v1+v2)
//                .orElse(0);

        return Files
                .lines(path)
                .flatMapToInt(s -> s.codePoints())
                .filter(value -> Character.isDigit(value))
                .map(i -> i - 48)
                .reduce((i1, i2) -> i1 + i2)
                .orElse(0);
    }

    //представим, что есть фал сданными такого вида -  Найти максимальное число   10.6  20.1   15.2

    //  3.14  8.5
    // 4  100.1 0.1  2.45
    // 100.02
    public static Double getMaxValueFromFile(Path path) throws IOException {
        return Files
                .lines(path)
                .flatMap(s -> Arrays.stream(s.split("[ ]+")))
                .mapToDouble(s -> Double.parseDouble(s))
                .max()
                .orElse(0.0);
    }
    //формат файла .csv  (могут быть и запятые , а могут быть и точки с запятой как разделители

    public static Double getMaxValueFromCsvFile(Path path) throws IOException {
        return Files
                .lines(path)
                .flatMap(s -> Arrays.stream(s.split("[ ,;]+")))
                .mapToDouble(s -> Double.parseDouble(s))
                .max()
                .orElse(0.0);
    }

    //найти общее количество подчиненных
    public static Integer countAllSubordinates(List<Employee> list) {
        return getAllSubordinates(list).size();
    }

    //найти сотрудников с наибольшим количеством подчиненных менеджеров
    public static Set<Manager> getEmployeesWithMaxAmountSubordinates(List<Employee> list) {
        Manager managerWithMaxManagers = list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Manager)
                .map(employee -> (Manager) employee)
                .max((m1, m2)
                        -> Long.compare(
                        m1.getAllSubordinates().stream().filter(s -> s instanceof Manager).count(),
                        m2.getAllSubordinates().stream().filter(s -> s instanceof Manager).count())
                )
                .orElse(null);

        long value = managerWithMaxManagers.getAllSubordinates().stream().filter(s -> s instanceof Manager).count();

        return list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Manager manager)
                .map(employee -> (Manager) employee)
                .filter(manager -> manager.getAllSubordinates().stream().filter(s -> s instanceof Manager).count() == value)
                .collect(Collectors.toSet());
    }

    //поднять зарплату сотрудникам на такой-то процент, если они зарабатывають меньше определенной суммы
    public static Set<Employee> getEmployeeWithIncreasedSalary(List<Employee> list, BigDecimal percent, BigDecimal edgeSum) {
        return getPayrollEntryForEachEmployee(list)
                .stream()
                .map(payrollEntry -> {
                    if (payrollEntry.getSalaryPlusBonus().compareTo(edgeSum) < 0) {
                        payrollEntry.getEmployee().setSalary(
                                payrollEntry.getEmployee()
                                        .getSalary()
                                        .multiply(BigDecimal.ONE.add(percent))
                        );
                    }
                    return payrollEntry.getEmployee();
                })
                .collect(Collectors.toSet());
    }

    //разделить всех работников на 2 списка - первый это те, что имеют бонус и те у которых его нет или 0
    public static Map<Boolean, List<Employee>> getMapWithEmployeeWhoHaveBonusAndWhoHavenot(List<Employee> list) {
        return list
                .stream()
                .distinct()
                .collect(Collectors.partitioningBy(employee -> employee instanceof Worker worker &&
                                                               worker.getBonus() != null &&
                                                               worker.getBonus().compareTo(BigDecimal.ZERO) > 0));
    }

    //найти количество сотрудников по каджой из должностей
    public static Map<String, Long> getPositionAndAmountOfWorkers(List<Employee> list) {
        return list
                .stream()
                .distinct()
                .collect(Collectors.groupingBy(e -> e.getClass().getSimpleName(), Collectors.counting()));
    }

    //для каждого менеджера найти сумарный фонд зарплат непосредственных подчиненных
    public static Map<Manager, BigDecimal> getManagersSubordinatesTotalSalary(List<Employee> list) {
        Map<Manager, BigDecimal> map = new HashMap<>();

        list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Manager)
                .map(employee -> (Manager) employee)
                .forEach(manager -> manager.getSubordinates()
                        .forEach(s -> map
                                .put(
                                        manager,
                                        map.getOrDefault(manager, BigDecimal.ZERO)
                                                .add(s.getSalary() == null ? BigDecimal.ZERO : s.getSalary())
                                )));
        return map;
    }

    //принимаем путь и возвращаем список уникальных слов отсортированный по алфавиту (+ в каждом слове первая буква заглавная)
    public static List<String> getUniqueWordsSortedByAlphabet(Path dir) throws IOException {
        return Files.list(dir).flatMap(path1 -> {
                    try {
                        return Files.lines(path1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .flatMap(line -> Arrays.stream(line.split("[, .]+")))
                .map(String::toLowerCase)
                .filter(s -> !s.isBlank())
                .distinct()
                .sorted(String::compareTo)
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .collect(Collectors.toList());
    }

    //отгруппировать сотрудников по возрастам ("от 25 до 30   ,  от 30 до 40, от 40 до 50 и от 50)
    public static Map<String, List<Employee>> getGroupEmployeeByAgeStatistics(List<Employee> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.groupingBy(Person::getAgeRange));
    }

    //найти фонд выплат для каждой категории сотрудников
    public static Map<String, BigDecimal> getTotalPurchaseSumForEachGroupEmployee(List<Employee> list) {
        return getPayrollEntryForEachEmployee(list)
                .stream()
                .collect(Collectors.groupingBy(
                        payrollEntry -> payrollEntry
                                .getEmployee()
                                .getClass()
                                .getSimpleName(),
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                PayrollEntry::getSalaryPlusBonus,
                                BigDecimal::add
                        )
                ));
    }

    //для каждого менеджера определить сумму выплат его подчиненных (непосредственных)
    public static Map<Manager, BigDecimal> getTotalPurchaseForEachManagersSubordinates(List<Employee> list) {
        return list
                .stream()
                .distinct()
                .filter(employee -> employee instanceof Manager)
                .map(employee -> (Manager) employee)
                .collect(Collectors.toMap(manager -> manager,
                        manager -> getPayrollEntryForParticularManager(manager)
                                .stream()
                                .distinct()
                                .map(payrollEntry -> payrollEntry.getSalaryPlusBonus())
                                .reduce((p1, p2) -> p1.add(p2))
                                .orElse(BigDecimal.ZERO)
                ));
    }

    //определить количество сотрудников зарабатывающих больше или равно и меньше перадаваемой суммы
    public static Map<Boolean,Long> getEmployeeWithParticularSalary(List<Employee> list, BigDecimal value) {
        return getPayrollEntryForEachEmployee(list)
                .stream()
                .collect(Collectors.partitioningBy(
                        payrollEntry -> payrollEntry.getSalaryPlusBonus() != null
                                        && payrollEntry.getSalaryPlusBonus().compareTo(value) < 0,
                        Collectors.counting()
                ));
    }
}

