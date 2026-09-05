package oop.stream.payrollEntry;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Manager director = EmployeeGenerator.randomManager();
        Manager manager1 = EmployeeGenerator.randomManager();
        Manager manager2 = EmployeeGenerator.randomManager();
        Manager manager3 = EmployeeGenerator.randomManager();
        Manager manager4 = EmployeeGenerator.randomManager();
        Manager manager5 = EmployeeGenerator.randomManager();
        Manager manager6 = EmployeeGenerator.randomManager();
        Manager manager7 = EmployeeGenerator.randomManager();
        Manager manager8 = EmployeeGenerator.randomManager();
        Manager manager9 = EmployeeGenerator.randomManager();
        Manager manager10 = EmployeeGenerator.randomManager();
        Manager manager11 = EmployeeGenerator.randomManager();
        Manager manager12 = EmployeeGenerator.randomManager();
        Manager manager13 = EmployeeGenerator.randomManager();
        Manager manager14 = EmployeeGenerator.randomManager();
        Manager manager15 = EmployeeGenerator.randomManager();
        Manager manager16 = EmployeeGenerator.randomManager();

        Trainee trainee = EmployeeGenerator.randomTrainee(director);
        Trainee trainee1 = EmployeeGenerator.randomTrainee(manager1);
        Trainee trainee2 = EmployeeGenerator.randomTrainee(manager2);
        Trainee trainee3 = EmployeeGenerator.randomTrainee(director);
        Trainee trainee4 = EmployeeGenerator.randomTrainee(manager1);
        Trainee trainee5 = EmployeeGenerator.randomTrainee(manager1);
        Trainee trainee6 = EmployeeGenerator.randomTrainee(null);
        Trainee trainee7 = EmployeeGenerator.randomTrainee(null);
        Trainee trainee8 = EmployeeGenerator.randomTrainee(null);
        Trainee trainee9 = EmployeeGenerator.randomTrainee(null);
        Trainee trainee10 = EmployeeGenerator.randomTrainee(director);

        Worker worker = EmployeeGenerator.randomWorker(director);
        Worker worker1 = EmployeeGenerator.randomWorker(manager1);
        Worker worker2 = EmployeeGenerator.randomWorker(manager2);
        Worker worker3 = EmployeeGenerator.randomWorker(director);
        Worker worker4 = EmployeeGenerator.randomWorker(manager1);
        Worker worker5 = EmployeeGenerator.randomWorker(manager1);
        Worker worker6 = EmployeeGenerator.randomWorker(null);
        Worker worker7 = EmployeeGenerator.randomWorker(null);
        Worker worker8 = EmployeeGenerator.randomWorker(null);
        Worker worker9 = EmployeeGenerator.randomWorker(null);
        Worker worker10 = EmployeeGenerator.randomWorker(director);
        Worker worker11 = EmployeeGenerator.randomWorker(director);

        worker11.setBonus(null);

        Manager cloneDirector = director.clone();
        Manager cloneManager1 = manager1.clone();
        Manager cloneManager2 = manager2.clone();
        Manager cloneManager3 = manager3.clone();
        Manager cloneManager4 = manager4.clone();
        Manager cloneManager5 = manager5.clone();
        Manager cloneManager6 = manager6.clone();
        Manager cloneManager7 = manager7.clone();
        Manager cloneManager8 = manager8.clone();
        Manager cloneManager9 = manager9.clone();
        Manager cloneManager10 = manager10.clone();

        Trainee cloneTrainee = trainee.clone();
        Trainee cloneTrainee1 = trainee1.clone();
        Trainee cloneTrainee2 = trainee2.clone();
        Trainee cloneTrainee3 = trainee3.clone();
        Trainee cloneTrainee4 = trainee4.clone();
        Trainee cloneTrainee5 = trainee5.clone();
        Trainee cloneTrainee6 = trainee6.clone();
        Trainee cloneTrainee7 = trainee7.clone();
        Trainee cloneTrainee8 = trainee8.clone();
        Trainee cloneTrainee9 = trainee9.clone();
        Trainee cloneTrainee10 = trainee10.clone();

        Worker cloneWorker = worker.clone();
        Worker cloneWorker1 = worker1.clone();
        Worker cloneWorker2 = worker2.clone();
        Worker cloneWorker3 = worker3.clone();
        Worker cloneWorker4 = worker4.clone();
        Worker cloneWorker5 = worker5.clone();
        Worker cloneWorker6 = worker6.clone();
        Worker cloneWorker7 = worker7.clone();
        Worker cloneWorker8 = worker8.clone();
        Worker cloneWorker9 = worker9.clone();
        Worker cloneWorker10 = worker10.clone();

        director.addEmployee(trainee);
        director.addEmployee(trainee3);
        director.addEmployee(worker);
        director.addEmployee(worker3);
        director.addEmployee(trainee10);
        director.addEmployee(worker10);
        director.addEmployee(manager1);
        director.addEmployee(manager2);
        director.addEmployee(trainee);
        director.addEmployee(worker);
        director.addEmployee(manager1);

        manager1.addEmployee(trainee1);
        manager1.addEmployee(worker1);
        manager2.addEmployee(worker1);
        manager3.addEmployee(worker1);
        manager1.addEmployee(cloneTrainee4);

        manager2.addEmployee(worker2);
        manager2.addEmployee(cloneWorker2);
        manager1.addEmployee(cloneWorker2);
        manager3.addEmployee(cloneWorker2);
        manager2.addEmployee(cloneTrainee2);

        manager3.addEmployee(trainee3);
        manager4.addEmployee(trainee3);
        manager5.addEmployee(trainee3);
        manager3.addEmployee(cloneWorker3);
        manager3.addEmployee(cloneWorker3);

        manager4.addEmployee(worker4);
        manager4.addEmployee(cloneTrainee5);

        manager5.addEmployee(cloneWorker5);
        manager5.addEmployee(trainee5);

        manager6.addEmployee(worker6);
        manager6.addEmployee(cloneTrainee6);

        manager7.addEmployee(cloneWorker7);
        manager7.addEmployee(trainee7);

        manager8.addEmployee(worker8);
        manager8.addEmployee(cloneTrainee8);

        manager1.addEmployee(worker9);
        manager9.addEmployee(worker9);
        manager5.addEmployee(worker9);
        manager8.addEmployee(worker9);
        manager9.addEmployee(cloneWorker9);

        manager10.addEmployee(trainee10);
        manager10.addEmployee(cloneTrainee10);

        director.addEmployee(cloneDirector);
        director.addEmployee(cloneManager1);
        director.addEmployee(cloneManager2);

        cloneDirector.addEmployee(cloneWorker);
        cloneDirector.addEmployee(cloneTrainee);

        cloneManager1.addEmployee(cloneWorker1);
        cloneManager1.addEmployee(cloneTrainee1);

        cloneManager2.addEmployee(cloneWorker10);
        cloneManager2.addEmployee(cloneTrainee3);

        cloneManager3.addEmployee(cloneWorker4);

        cloneManager4.addEmployee(cloneTrainee7);

        cloneManager5.addEmployee(cloneWorker6);

        cloneManager6.addEmployee(cloneWorker8);

        cloneManager7.addEmployee(cloneTrainee9);

        cloneManager8.addEmployee(worker5);

        cloneManager9.addEmployee(trainee8);

        cloneManager10.addEmployee(worker10);

        List<Employee> allEmployee = new ArrayList<>();
        Collections.addAll(allEmployee, director, manager1, manager2, manager3, manager4, manager5, manager6, manager7, manager8, manager9, manager10,
                cloneDirector, cloneManager1, cloneManager2, cloneManager3, cloneManager4, cloneManager5, cloneManager6, cloneManager7, cloneManager8, cloneManager9, cloneManager10,
                trainee, trainee1, trainee3, trainee4, trainee5, trainee6, trainee7, trainee8, trainee9, trainee10, cloneTrainee, cloneTrainee1, cloneTrainee2, cloneTrainee3, cloneTrainee4, cloneTrainee5, cloneTrainee6, cloneTrainee7, cloneTrainee8, cloneTrainee9, cloneTrainee10,
                worker, worker1, worker2, worker3, worker4, worker5, worker6, worker7, manager2, manager3, manager4, manager5, manager6, manager7, manager8, manager9, manager10,
                cloneDirector, cloneManager1, cloneManager2, cloneManager3, cloneManager4, cloneManager5, cloneManager6, cloneManager7, cloneManager8, cloneManager9, cloneManager10,
                trainee, trainee1, trainee3, trainee4, trainee5, trainee6, trainee7, trainee8, trainee9, trainee10, cloneTrainee, cloneTrainee1, cloneTrainee2, cloneTrainee3, cloneTrainee4, cloneTrainee5, cloneTrainee6, cloneTrainee7, cloneTrainee8, cloneTrainee9, cloneTrainee10,
                worker, worker1, worker2, worker3, worker4, worker5, manager16, manager11, manager12, manager13, manager14, manager15, worker6, worker8, worker9, worker10, worker11, cloneWorker, cloneWorker1, cloneWorker2, cloneWorker3, cloneWorker4, cloneWorker5, cloneWorker6, cloneWorker7, cloneWorker8, cloneWorker9, cloneWorker10);
        System.out.println("Default list : List<Employee> allEmployee ");
        allEmployee.forEach(e -> System.out.println(e + "\n----------------------------"));
        System.out.println("\nMETHOD RESULT:\n");

//        director.printSubordinates(director.getSubordinates());
//        director.printAllSubordinates(director.getAllSubordinates());
//
//        Controller.getPayrollEntryForEachEmployee(new ArrayList<>(director.getAllSubordinates())).forEach(p -> System.out.println(p));
//        Controller.getPayrollEntryForParticularManager(manager1).forEach(p-> System.out.println(p));
//        System.out.println(Controller.calculateTotalBonus(allEmployee));
//        List<Manager> managers = Controller.getManagersWithSalaryMoreThan(allEmployee, new BigDecimal("7990.99"));
//        managers.forEach(m-> System.out.println(" who? : " + m.getClass().getSimpleName() + ", name: " + m.getName() + ", salary+bonus: " + m.getSalary().add(m.getBonus())));
//
//        Controller.getEmployeeWithMinExp(allEmployee).forEach(w-> System.out.println(" who? : " + w.getClass().getSimpleName() + ", name: " + w.getName() + ", date: " + w.getEmploymentDate()));
//        Controller.saveEmployeePayrollDataToTxtFile(allEmployee);
//        Controller.getEmployeePayrollDataFromTxtFile().forEach(p-> System.out.println(p));
//        System.out.println("Bonus: " + Controller.getMinBonusOnlyManagers(allEmployee));
//        Controller.getEmployeeWithSomeNumberOfSubordinatesAndMinMoney(allEmployee, 4).forEach(employee -> System.out.println(" who: " + employee.getClass().getSimpleName() + ", id: " + employee.getId() + ", salary: " + employee.getSalary()));
//
//        Controller.calculateAllEmployeesByPosition(allEmployee).forEach((position, count) -> {
//            System.out.println(" Position: " + position + ", count: " + count);
//        });
//
//        Controller.saveEmployeeDataNamePositionSalaryAndBonusToFile(allEmployee);
//
//        Controller.dublicate_saveEmployeeDataNamePositionSalaryAndBonusToFile(allEmployee);
//
//        System.out.println(Controller.getEmployeeWithHighestSalaryAndBonusFromFile());
//
//        Controller
//                .getThreeEmployeeWithHighestSalary(allEmployee)
//                .forEach(employee -> System.out.println(employee.getClass().getSimpleName()+ " " + employee.getSalary()));
//
//        Controller.saveDataToFile(allEmployee);

//        Controller
//                .findAllEmployeeParticularPositionAndAge(List.of("Trainee", "Worker"), 40)
//                .forEach(employeeData -> System.out.println(employeeData));
//        Controller.getTraineeWithCurrentPracticalDays(allEmployee, 35)
//                .forEach(e -> System.out.println("Trainee: " + e.getClass().getSimpleName() + " practic days: " + e.getPracticeLength()));

//        System.out.println(Controller.isAnyOfEmployeeTrainee(allEmployee));
//        Controller.getEmployeeWithParticularMonthBirthday(allEmployee).forEach(e -> System.out.println(" Employee: " + e.getName() + " date: " + e.getBirthdate()));

//        System.out.println(Controller.getListWithFourthTheYoungestEmployees(allEmployee));
//        Controller.getAllSubordinates(allEmployee).forEach(employee -> System.out.println(employee.getId()+ ", " + employee.getName()+ ", " + employee.getClass().getSimpleName() + "\n"));
//        Employee e = Controller.getEmployeeWithMaxSubordinates(allEmployee);
//        System.out.println(e.getId() + ", " + e.getName() + ", " + ((Manager) e).getAllSubordinates().size());
//
//        System.out.println(Controller.getTotalBonusSumAllEmployeeWithCurrentExpAndSubordinatesNumber(allEmployee, 4, 5));

//        System.out.println(Controller.calculateAllSum(Path.of("streamPayRollData/numbers.txt")));
//        System.out.println(Controller.getMaxValueFromFile(Path.of("streamPayRollData/numbersWithPoint.txt")));
//        System.out.println(Controller.getMaxValueFromCsvFile(Path.of("streamPayRollData/numbersCSV.csv")));
//        Set<Manager> employees = Controller.getEmployeesWithMaxAmountSubordinates(allEmployee);
//        employees.forEach(i-> System.out.println(i.getAllSubordinates().size() + ", " + i.getName()));
//

//        Set<Employee> employees = Controller.getEmployeeWithIncreasedSalary(allEmployee,new BigDecimal("0.10"),new BigDecimal("5654.45"));
//        employees.forEach(e-> System.out.println("\nnew salary: " + e.getId() + ", " + e.getName() + ", " + e.getSalary()));

//    Controller.getMapWithEmployeeWhoHaveBonusAndWhoHavenot(allEmployee)
//            .entrySet()
//            .forEach((e)-> {
//                System.out.println(e.getKey());
//                e.getValue().forEach(v-> System.out.println(v.getClass().getSimpleName() + "\n" +
//                                                            "id" + v.getId() + "\n" +
//                                                            (v.getClass().getSimpleName().equals("Worker") ? "bonus:" + ((Worker) v).getBonus() : "bonus:" + BigDecimal.ZERO)));
//            });


//        Controller.getMapWithEmployeeWhoHaveBonusAndWhoHavenot(allEmployee)
//                .forEach((hasBonus, employees) -> {
//                    System.out.println("hasBonus = " + hasBonus);
//
//                    employees.forEach(employee -> {
//                        System.out.println(employee.getClass().getSimpleName() + "\nid: " + employee.getId());
//
//                        if (employee instanceof Worker w) {
//                            System.out.println("bonus: " + w.getBonus());
//                        } else {
//                            System.out.println("bonus: N/A");
//                        }
//                    });
//                });
//        Controller.getManagersSubordinatesTotalSalary(allEmployee).forEach((k, v) -> {
//            System.out.println("Position: " + k + ", salary of workers: " + v);
//        });

//
//        Controller
//                .getUniqueWordsSortedByAlphabet(Path.of("C:\\Users\\PC\\IdeaProjects\\JavaCore\\TextFilesPackage"))
//                .forEach(s -> System.out.print("\t"+s));

//        Controller.getGroupEmployeeByAgeStatistics(allEmployee).forEach((k, v) -> {
//            System.out.println(" Group: " + k);
//            v.forEach(employee -> System.out.println("- id: " + employee.getId() + ", name: " + employee.getName() + ", age: " + employee.getAge() + "\n"));
//
//        });

//        Controller.getTotalPurchaseForEachManagersSubordinates(allEmployee).forEach((k, v) -> {
//            System.out.println(" Manager: " + k.getId() + ", " + k.getName() + ", totalSum: " + v);
//        });

        Controller.getEmployeeWithParticularSalary(allEmployee, new BigDecimal("9458.17")).forEach((k, v) ->{
            System.out.println(" - " + k + ", value E : " + v);
        });
    }
}
