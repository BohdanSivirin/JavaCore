package oop.collections.arrayList.contactsBook;

import oop.simpleObject.basic.contactBook.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ContactBook {
    private final ArrayList<Contact> contacts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ContactBook() {
        Contact ihor = new Contact("Ihor", null, "38050789456", "doctor  home", "ihor@ukr.net");
        Contact andre = new Contact("Andre", null, "38063123123", "teatcher school", null);
        Contact vasya = new Contact("Vasya", "Olegovich", "380994255021", "doctor builder", "oooVasya@gmail.com");
        Collections.addAll(contacts, ihor, andre, vasya);
        menu();
    }

    private ArrayList<Contact> findContact() {
        System.out.println(" Введите данные для поиска ");
        String text = scanner.next();
        ArrayList<Contact> foundContacts = new ArrayList<>();
        boolean isFindContact = false;
        for (Contact object : contacts) {
            if (object.getName() != null && object.getName().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                foundContacts.add(object);
                object.info();
                isFindContact = true;
            } else if (object.getLastName() != null && object.getLastName().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                foundContacts.add(object);
                object.info();
                isFindContact = true;
            } else if (object.getFeature() != null && object.getFeature().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                foundContacts.add(object);
                object.info();
                isFindContact = true;
            } else if (object.getEmail() != null && object.getEmail().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                foundContacts.add(object);
                object.info();
                isFindContact = true;
            } else if (object.getPhone() != null && object.getPhone().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                foundContacts.add(object);
                object.info();
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
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone)) {
                System.out.println(" Такой контакт уже есть ");
                contact.info();
                return;
            }
        }
        System.out.println(" Введите name ");
        String name = scanner.next();
        System.out.println(" Введите lastName ");
        String lastName = scanner.next();
        System.out.println(" Введите feature ");
        String feature = scanner.next();
        System.out.println(" Введите email ");
        String email = scanner.next();
        contacts.add(new Contact(name, lastName, phone, feature, email));
        System.out.println(" Добавлен новый контакт ");
    }

    private void updateContact() {
        ArrayList<Contact> updateContacts = findContact();
        if (updateContacts.isEmpty()) {
            System.out.println(" Контакт не найден, попробуйте снова");
            return;
        }
        for (int i = 0; i < updateContacts.size(); i++) {
            Contact object = updateContacts.get(i);
            System.out.print(i + " ");
            object.info();
        }
        int index;
        do {
            System.out.println(" Введите индекс контакта который хотите обновить ");
            index = scanner.nextInt();
        } while (index < 0 && index >= updateContacts.size());
        System.out.println(" \" Выберите поле для обновления \" ");
        System.out.println("1 -> Имя ");
        System.out.println("2 -> Фамилия ");
        System.out.println("3 -> Работа ");
        System.out.println("4 -> Email ");
        int field = scanner.nextInt();
        if (field == 1) {
            System.out.println(" Введите новое имя ");
            String name = scanner.next();
            contacts.get(index).setName(name);
            System.out.println(" Контакту - " + contacts.get(index).getPhone() + " присвоено новое имя - " + contacts.get(index).getName());
        }
        if (field == 2) {
            System.out.println(" Введи новую фамилию ");
            String name = scanner.next();
            contacts.get(index).setLastName(name);
            System.out.println(" Контакту - " + contacts.get(index).getPhone() + " присвоена новая фамилия - " + contacts.get(index).getLastName());
        }
        if (field == 3) {
            System.out.println(" Введите новое место работы ");
            String name = scanner.next();
            contacts.get(index).setFeature(name);
            System.out.println(" Контакту - " + contacts.get(index).getPhone() + " присвоено новое место работы - " + contacts.get(index).getFeature());
        }
        if (field == 4) {
            System.out.println(" Введите новый email ");
            String name = scanner.next();
            contacts.get(index).setEmail(name);
            System.out.println(" Контакту - " + contacts.get(index).getPhone() + " присвоено новое email - " + contacts.get(index).getEmail());
        }
    }

    private void deleteContact() {
        ArrayList<Contact> deleteContacts = findContact();
        if (deleteContacts.isEmpty()) {
            System.out.println(" Контакт не найден, попробуйте снова");
            return;
        }
        for (int i = 0; i < deleteContacts.size(); i++) {
            Contact object = deleteContacts.get(i);
            System.out.print(i + " ");
            object.info();
        }
        int index;
        do {
            System.out.println(" Введите индекс контакта который хотите удалить ");
            index = scanner.nextInt();
        } while (index < 0 && index >= deleteContacts.size());
        contacts.remove(index);
        System.out.println(" Контакт с индексом " + index + " удален ");
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
                return;
            }
        }
        menu();
    }


}

