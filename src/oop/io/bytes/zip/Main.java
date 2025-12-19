package oop.io.bytes.zip;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(123456789, 1111222233, 1, "PrivatBank", "Petro", 1478);
        BankAccount bankAccount1 = new BankAccount(789456123, 111111111, 2, "UKRBank", "Vasya", 4512);

        boolean isSaved = Controller.save(bankAccount);
        System.out.println("isSaved " + isSaved);
        boolean isSaved1 = Controller.save(bankAccount1);
        System.out.println("isSaved 1 " + isSaved1);

        BankAccount foundAccount = Controller.findById(1111222233);
        System.out.println("foundAccount before update: " + foundAccount);
        BankAccount foundAccount1 = Controller.findById(111111111);
        System.out.println("foundAccount 1 before update: " + foundAccount1);

        bankAccount1.setSum(12456);

        boolean isUpdated = Controller.update(bankAccount1);
        System.out.println("isUpdated " + isUpdated);

        foundAccount1 = Controller.findById(111111111);
        System.out.println("foundAccount 1 updated: " + foundAccount1);

        boolean isDeleted = Controller.delete(bankAccount);
        System.out.println("isDeleted " + isDeleted);

        BankAccount bankAccount3 = Controller.findById(1111222233);
        System.out.println(" bankAccount3: " + bankAccount3);
    }
}
