package oop.collections.hashMap.contactBook;

import oop.simpleObject.basic.contactBook.Contact;

import java.util.HashMap;
import java.util.Scanner;

public class ContactBook {

    private final HashMap<String, Contact> contacts = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public ContactBook() {

        Contact ihor = new Contact("Ihor", null, "38050789456", "doctor  home", "ihor@ukr.net");
        Contact andre = new Contact("Andre", null, "38063123123", "teatcher school", null);
        Contact vasya = new Contact("Vasya", "Olegovich", "380994255021", "doctor builder", "oooVasya@gmail.com");
        contacts.put("38050789456", ihor);
        contacts.put("38063123123", andre);
        contacts.put("380994255021", vasya);
        menu();
    }

    private HashMap<String, Contact> findContact() {
        System.out.println(" Введите данные для поиска ");
        String text = scanner.next();
        HashMap<String, Contact> foundContacts = new HashMap<>();
        boolean isFindContact = false;
        for (Contact contact : contacts.values()) {

            if (contact.getName() != null && contact.getName().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                foundContacts.put(contact.getPhone(), contact);
                contact.info();
                isFindContact = true;
            } else if (contact.getLastName() != null && contact.getLastName().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                foundContacts.put(contact.getPhone(), contact);
                contact.info();
                isFindContact = true;
            } else if (contact.getFeature() != null && contact.getFeature().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                foundContacts.put(contact.getPhone(), contact);
                contact.info();
                isFindContact = true;
            } else if (contact.getEmail() != null && contact.getEmail().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                foundContacts.put(contact.getPhone(), contact);
                contact.info();
                isFindContact = true;
            } else if (contact.getPhone() != null && contact.getPhone().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                foundContacts.put(contact.getPhone(), contact);
                contact.info();
                isFindContact = true;
            }
        }
        if (!isFindContact) {
            System.out.println(" Контакт не найден ");
        }
        return foundContacts;
    }

    private void addContact() {
        System.out.println(" Введите номер телефона ");
        String phone = scanner.next();
        if (contacts.containsKey(phone)) {
            System.out.println(" Такой контакт уже есть ");
            return;
        }
        System.out.println(" Введите name ");
        String name = scanner.next();
        System.out.println(" Введите lastName ");
        String lastName = scanner.next();
        System.out.println(" Введите feature ");
        String feature = scanner.next();
        System.out.println(" Введите email ");
        String email = scanner.next();
        contacts.put(phone, new Contact(name, lastName, phone, feature, email));
        System.out.println(" Добавлен новый контакт ");
    }

    private void updateContact() {
        HashMap<String, Contact> updateContacts = findContact();
        if (updateContacts.isEmpty()) {
            return;
        }
        String phoneNumber = "";
        do {
            System.out.println(" Введите номер контакта который хотите обновить ");
            phoneNumber = scanner.next();
        } while (!updateContacts.containsKey(phoneNumber));
        Contact contact = updateContacts.get(phoneNumber);
        System.out.println(" \" Выберите поле для обновления \" ");
        System.out.println("1 -> Имя ");
        System.out.println("2 -> Фамилия ");
        System.out.println("3 -> Работа ");
        System.out.println("4 -> Email ");
        System.out.println("5 -> Phone  ");
        int field = scanner.nextInt();
        if (field == 1) {
            System.out.println(" Введите новое имя ");
            contact.setName(scanner.next());
            System.out.println(" Контакту - " + phoneNumber + " присвоено новое имя - " + contact.getName());
        }
        if (field == 2) {
            System.out.println(" Введи новую фамилию ");
            contact.setLastName(scanner.next());
            System.out.println(" Контакту - " + phoneNumber + " присвоена новая фамилия - " + contact.getLastName());
        }
        if (field == 3) {
            System.out.println(" Введите новое место работы ");
            contact.setFeature(scanner.next());
            System.out.println(" Контакту - " + phoneNumber + " присвоено новое место работы - " + contact.getFeature());
        }
        if (field == 4) {
            System.out.println(" Введите новый email ");
            contact.setEmail(scanner.next());
            System.out.println(" Контакту - " + phoneNumber + " присвоено новое email - " + contact.getEmail());
        }
        if (field == 5) {
            System.out.println(" Введите новый phone ");
            String newPhone = scanner.next();
            contact.setPhone(newPhone);
            contacts.remove(phoneNumber);
            contacts.put(newPhone, contact);
            System.out.println(" Контакту - " + phoneNumber + " присвоено новое phone - " + contact.getPhone());
        }
    }

    private void deleteContact() {
        HashMap<String, Contact> deleteContacts = findContact();
        if (deleteContacts.isEmpty()) {
            System.out.println(" Контакт не найден, попробуйте снова");
            return;
        }
        String phoneNumber = "";
        do {
            System.out.println(" Введите номер контакта который хотите удалить ");
            phoneNumber = scanner.next();
        } while (!deleteContacts.containsKey(phoneNumber));
        Contact oldName = contacts.remove(phoneNumber);
        System.out.println(" Контакт " + oldName.getName() + " удален ");
    }

    private void menu() {
        System.out.println(" \" Список контактов \" ");
        System.out.println(" 1 -> addContact ");
        System.out.println(" 2 -> findContact ");
        System.out.println(" 3 -> updateContact ");
        System.out.println(" 4 -> deleteContact ");
        System.out.println(" 5 -> Quit ");
        System.out.println(" \" Введи номер программы \" ");
        int a = scanner.nextInt();
        switch (a) {
            case 1 -> addContact();
            case 2 -> findContact();
            case 3 -> updateContact();
            case 4 -> deleteContact();
            case 5 -> {
                System.exit(0);
            }
        }
        menu();
    }


}

