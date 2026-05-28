package oop.stream.payrollEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
        manager1.addEmployee(cloneTrainee4);

        manager2.addEmployee(worker2);
        manager2.addEmployee(cloneWorker2);
        manager2.addEmployee(cloneTrainee2);

        manager3.addEmployee(trainee3);
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

        manager9.addEmployee(worker9);
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

        List<Employee> all = new ArrayList<>();
        Collections.addAll(all, director, manager1, manager2, manager3, manager4, manager5, manager6, manager7, manager8, manager9, manager10,
                cloneDirector, cloneManager1, cloneManager2, cloneManager3, cloneManager4, cloneManager5, cloneManager6, cloneManager7, cloneManager8, cloneManager9, cloneManager10,
                trainee, trainee1, trainee3, trainee4, trainee5, trainee6, trainee7, trainee8, trainee9, trainee10, cloneTrainee, cloneTrainee1, cloneTrainee2, cloneTrainee3, cloneTrainee4, cloneTrainee5, cloneTrainee6, cloneTrainee7, cloneTrainee8, cloneTrainee9, cloneTrainee10,
                worker, worker1, worker2, worker3, worker4, worker5, worker6, worker7, worker8, worker9, worker10, worker11, cloneWorker, cloneWorker1, cloneWorker2, cloneWorker3, cloneWorker4, cloneWorker5, cloneWorker6, cloneWorker7, cloneWorker8, cloneWorker9, cloneWorker10);


//        director.printSubordinates(director.getSubordinates());
//        director.printAllSubordinates(director.getAllSubordinates());

//        Controller.getPayrollEntryForEachEmployee(new ArrayList<>(director.getAllSubordinates())).forEach(p -> System.out.println(p));
//        Controller.getPayrollEntryForParticularManager(manager1).forEach(p-> System.out.println(p));
        System.out.println(Controller.calculateTotalBonus(all));
    }
}
