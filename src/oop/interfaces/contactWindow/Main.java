package oop.interfaces.contactWindow;

public class Main {
    public static void main(String[] args) {
        ContactWindow contactWindow = new ContactWindow();
        Employee employee = new Employee(12345, "Artur", "Smit", "driver", "+380664330109",
                "driver@taxi.com.ua", "Dnipro, Kotelnikov street, 78b", 25400.50, true);
        Delivery delivery = new Delivery("Glove", "+380679871245",
                "dostavkaDnepr@gmail.com", "Dnipro, Naberejna street, 125a", true);
        Supplier supplier = new Supplier("Petro", "+380993212654",
                "qwerty@gmail.com", "Dnipro, Sovhozna, 5", false);
        Client client = new Client("John", "Yuk", "+380504256598",
                "zxcv1b2m33n4asbdfa@ukr.net", "Dnipro, Loc-Kamen, 715");

        contactWindow.addContact(employee);
        contactWindow.addContact(delivery);
        contactWindow.addContact(supplier);
        contactWindow.addContact(client);


       // contactWindow.info(supplier);

        contactWindow.right();
        contactWindow.right();
        contactWindow.right();
        contactWindow.right();

        contactWindow.left();
        contactWindow.left();
        contactWindow.left();
        contactWindow.left();

        contactWindow.delete();

        contactWindow.left();
        contactWindow.left();
        contactWindow.left();
        contactWindow.left();

        contactWindow.right();
        contactWindow.right();
        contactWindow.right();

        contactWindow.update("name",  "PesBarbos");



//        contactWindow.right();
//        contactWindow.right();
//        contactWindow.right();

    }
}
