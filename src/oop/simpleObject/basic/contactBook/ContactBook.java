package oop.simpleObject.basic.contactBook;

import java.util.Arrays;
import java.util.Scanner;

public class ContactBook {
    private Contact[] contacts = new Contact[4];
    Scanner scanner = new Scanner(System.in);
    private int freeIndex;

    public ContactBook() {
        Contact ihor = new Contact("Ihor", null, "38050789456", "doctor  home", "ihor@ukr.net");
        Contact andre = new Contact("Andre", null, "38063123123", "teatcher school", null);
        Contact vasya = new Contact("Vasya", "Olegovich", "380994255021", "doctor builder", "oooVasya@gmail.com");

        contacts[0] = ihor;
        contacts[1] = andre;
        contacts[2] = vasya;
        freeIndex = 3;
        menu();
    }

//    private void chooseSearchMethod() {
//        System.out.println(" \" Выберите способ поиска \" ");
//        System.out.println("1 -> findByPhoneNumber ");
//        System.out.println("2 -> findByName ");
//        System.out.println("3 -> findByLastName ");
//        System.out.println("4 -> findByFeature ");
//        System.out.println("5 -> findByEmail ");
//        int a = scanner.nextInt();
//        switch (a) {
//          //  case 1 -> findByPhoneNumber();
//            case 2 -> findByName();
//            case 3 -> findByLastName();
//            case 4 -> findByFeature();
//            case 5 -> findByEmail();
//        }
//    }

//    private Contact findByPhoneNumber() {
//        System.out.println(" Введите номер телефона ");
//        Long phone = scanner.nextLong();
//        for (int i = 0; i < freeIndex; i++) {
//            if (phone.equals(contacts[i].getPhone())) {
//                System.out.println(" Мы нашли контакт в книжке = ");
//                contacts[i].info();
//                return contacts[i];
//            }
//        }
//        System.out.println(" Контакт не найден ");
//        return null;
//    }
//
//    private void findByName() {
//        System.out.println(" Введите имя ");
//        String name = scanner.next();
//        for (int i = 0; i < freeIndex; i++) {
//            if (name.equals(contacts[i].getName())) {
//                System.out.println(" Мы нашли контакт в книжке = ");
//                contacts[i].info();
//                return;
//            }
//        }
//        System.out.println(" Контакт не найден ");
//    }
//
//    private void findByLastName() {
//        System.out.println(" Введите фамилию ");
//        String lastName = scanner.next();
//        for (int i = 0; i < freeIndex; i++) {
//            if (lastName.equals(contacts[i].getLastName())) {
//                System.out.println(" Мы нашли контакт в книжке = ");
//                contacts[i].info();
//                return;
//            }
//        }
//        System.out.println(" Контакт не найден ");
//    }

    private int[] findContact() {
        System.out.println(" Введите данные для поиска ");
        String text = scanner.next();
        int[] indexes = new int[0];
        boolean isFindContact = false;
        int foundIndex = -1;
        for (int i = 0; i < freeIndex; i++) {
            if (contacts[i].getName() != null && contacts[i].getName().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                System.out.println("Index of the contact: " + i);
                foundIndex = i;
                contacts[i].info();
                isFindContact = true;
            } else if (contacts[i].getLastName() != null && contacts[i].getLastName().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                contacts[i].info();
                foundIndex = i;
                isFindContact = true;
            } else if (contacts[i].getFeature() != null && contacts[i].getFeature().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                contacts[i].info();
                foundIndex = i;
                isFindContact = true;
            } else if (contacts[i].getEmail() != null && contacts[i].getEmail().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                contacts[i].info();
                foundIndex = i;
                isFindContact = true;
            } else if (contacts[i].getPhone() != null && contacts[i].getPhone().startsWith(text)) {
                System.out.println(" Мы нашли контакт в книжке = ");
                contacts[i].info();
                foundIndex = i;
                isFindContact = true;
            }
            if (foundIndex != -1) {
                int[] indexes2 = new int[indexes.length + 1];
                System.arraycopy(indexes, 0, indexes2, 0, indexes.length);
                indexes2[indexes.length] = i;
                indexes = indexes2;
                foundIndex = -1;
            }
        }
        if (!isFindContact) {
            System.out.println(" Контакт не найден ");
        }
        return indexes;
    }

    private void addContact() {
        System.out.println(" Введите номер телефона ");
        String phone = scanner.next();
        for (int i = 0; i < freeIndex; i++) {
            if (contacts[i].getPhone().equals(phone)) {
                System.out.println(" Такой контакт уже есть ");
                contacts[i].info();
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
        Contact contact = new Contact(name, lastName, phone, feature, email);
        contacts[freeIndex++] = contact;
        System.out.println(" Добавлен новый контакт ");
        if (freeIndex == contacts.length) {
            Contact[] newContacts = new Contact[contacts.length + 2];
            System.arraycopy(contacts, 0, newContacts, 0, contacts.length);
            contacts = newContacts;
        }
    }

//    private void chooseUpdateMethod() {
//        System.out.println(" \" Выберите поле для обновления \" ");
//        System.out.println("1 -> updateContactName ");
//        System.out.println("2 -> updateLastName ");
//        System.out.println("3 -> updateEmail ");
//        System.out.println("4 -> updateFeature ");
//        int a = scanner.nextInt();
//        switch (a) {
//            case 1 -> updateContactName();
//            case 2 -> updateLastName();
//            case 3 -> updateEmail();
//            case 4 -> updateFeature();
//        }
//    }

    private void updateContact() {
        int[] update = findContact();
        int updateIndex = -1;
        //System.out.println(Arrays.toString(update));
        for (int i = 0; i < update.length; i++) {
            System.out.print(i + " ");
            contacts[i].info();
            updateIndex = i;
        }
        System.out.println(" Введите мобильный номер контакта который хотите обновить ");
        String number = scanner.next();
        if (!contacts[updateIndex].getPhone().equals(number)) {
            System.out.println(" Контакт не найден, попробуйте снова");
            return;
        }
        System.out.println(" \" Выберите поле для обновления \" ");
        System.out.println("1 -> Имя ");
        System.out.println("2 -> Фамилия ");
        System.out.println("3 -> Работа ");
        System.out.println("4 -> Email ");
        int field = scanner.nextInt();
        if (field == 1) {
            System.out.println(" Введите новое имя ");
            String name = scanner.next();
            contacts[updateIndex].setName(name);
            System.out.println(" Контакту - " + contacts[updateIndex].getPhone() + " присвоено новое имя - " + contacts[updateIndex].getName());
        }
        if (field == 2) {
            System.out.println(" Введи новую фамилию ");
            String name = scanner.next();
            contacts[updateIndex].setLastName(name);
            System.out.println(" Контакту - " + contacts[updateIndex].getPhone() + " присвоена новая фамилия - " + contacts[updateIndex].getLastName());
        }
        if (field == 3) {
            System.out.println(" Введите новое место работы ");
            String name = scanner.next();
            contacts[updateIndex].setFeature(name);
            System.out.println(" Контакту - " + contacts[updateIndex].getPhone() + " присвоено новое место работы - " + contacts[updateIndex].getFeature());
        }
        if (field == 4) {
            System.out.println(" Введите новый email ");
            String name = scanner.next();
            contacts[updateIndex].setEmail(name);
            System.out.println(" Контакту - " + contacts[updateIndex].getPhone() + " присвоено новое email - " + contacts[updateIndex].getEmail());
        }


//        if (a != 2) {
//            System.out.println(" Введите новое имя ");
//            String name = scanner.next();
//            contacts[updateIndex].setName(name);
//            System.out.println(" Контакту - " + contacts[updateIndex].getPhone() + " присвоено новое имя - " + contacts[updateIndex].getName());
//        }
//        System.out.println(" Хотите обновить фамилию контакта? 1-Yes, 2-No ");
//        a = scanner.nextInt();
//        if (a != 2) {
//            System.out.println(" Введи новую фамилию ");
//            String name = scanner.next();
//            contacts[updateIndex].setLastName(name);
//            System.out.println(" Контакту - " + contacts[updateIndex].getPhone() + " присвоена новая фамилия - " + contacts[updateIndex].getLastName());
//        }
//        System.out.println(" Хотите обновить место работы контакта? 1-Yes, 2-No ");
//        a = scanner.nextInt();
//        if (a != 2) {
//            System.out.println(" Введите новое место работы ");
//            String name = scanner.next();
//            contacts[updateIndex].setFeature(name);
//            System.out.println(" Контакту - " + contacts[updateIndex].getPhone() + " присвоено новое место работы - " + contacts[updateIndex].getFeature());
//        }
//        System.out.println(" Хотите обновить email контакта? 1-Yes, 2-No ");
//        a = scanner.nextInt();
//        if (a != 2) {
//            System.out.println(" Введите новый email ");
//            String name = scanner.next();
//            contacts[updateIndex].setEmail(name);
//            System.out.println(" Контакту - " + contacts[updateIndex].getPhone() + " присвоено новое email - " + contacts[updateIndex].getEmail());
//        }
//    }
//        private void updateEmail() {
//        Contact toUpdate = findByPhoneNumber();
//        if (toUpdate == null) {
//            return;
//        }
//        System.out.println(" Введи новый email ");
//        String email = scanner.next();
//        toUpdate.setEmail(email);
//        System.out.println(" Контакту - " + toUpdate.getPhone() + " присвоено новый email - " + toUpdate.getEmail());
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

    private void deleteContact() {
        int[] delete = findContact();
        for (int i = 0; i < delete.length; i++) {
            System.out.print(i + " ");
            contacts[i].info();
        }
        System.out.println(" Введите номер контакта который хотите удалить ");
        int a = scanner.nextInt();
        System.arraycopy(contacts, a + 1, contacts, a, freeIndex - a - 1);
        freeIndex--;
    }
}






