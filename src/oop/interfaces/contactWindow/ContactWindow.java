package oop.interfaces.contactWindow;

import java.util.ArrayList;


public class ContactWindow {
    private ArrayList<Contact> contacts;
    private int currentIndex;

    public ContactWindow() {
        contacts = new ArrayList<>();
        currentIndex = -1;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        currentIndex++;
        System.out.println(contact.getClass().getSimpleName() + " added to contacts ");
    }

    public void info(Contact contact) {
        System.out.println("name: " + contact.getName()
                           + "\nsurname: " + contact.getSurname()
                           + "\nphone: " + contact.getPhone()
                           + "\nemail: " + contact.getEmail()
                           + "\naddress: " + contact.getAddress()
                           + "\ntype: " + contact.getType()
                           + "\nphoto: " + contact.getPhoto());
    }

    public void left() {
        System.out.println("\n previous contact\n");
        if (currentIndex == -1) {
            System.out.println(" not found contact ");
            return;
        }
        currentIndex = currentIndex > 0 ? currentIndex - 1 : contacts.size() - 1;
        info(contacts.get(currentIndex));

//        if (currentIndex > 0) {
//            currentIndex--;
//            info(contacts.get(currentIndex));
//            return;
//        }
//        if (currentIndex == 0) {
//            currentIndex = contacts.size() - 1;
//            info(contacts.get(currentIndex));
//        }
    }

    public void right() {
        System.out.println("\n next Contact \n ");
        if (currentIndex == -1) {
            System.out.println(" not found contact ");
            return;
        }
        currentIndex = currentIndex == contacts.size() - 1 ? 0 : currentIndex + 1;
        info(contacts.get(currentIndex));

//        if (currentIndex < contacts.size() - 1) {
//            currentIndex++;
//            info(contacts.get(currentIndex));
//        }
//        if (currentIndex == contacts.size() - 1) {
//            currentIndex = 0;
//            info(contacts.get(currentIndex));
//        }
    }

    public void delete() {
        if (currentIndex == -1) {
            System.out.println(" not found contact ");
            return;
        }
        Object old = contacts.remove(currentIndex);
        System.out.println("contact: " + old.getClass().getSimpleName() + " removed from contacts ");
        if (currentIndex == contacts.size() - 1) {
            currentIndex--;
        }
        if (contacts.isEmpty()) {
            currentIndex = -1;
        }

    }

    public void update(String fieldToUpdate, String newValue) {
        if (currentIndex == -1) {
            System.out.println(" not found contact  ");
            return;
        }
        if (fieldToUpdate.equals("name")) contacts.get(currentIndex).setName(newValue);
        if (fieldToUpdate.equals("surname")) contacts.get(currentIndex).setSurname(newValue);
        if (fieldToUpdate.equals("phone")) contacts.get(currentIndex).setPhone(newValue);
        if (fieldToUpdate.equals("email")) contacts.get(currentIndex).setEmail(newValue);
        if (fieldToUpdate.equals("address")) contacts.get(currentIndex).setAddress(newValue);
        if (fieldToUpdate.equals("photo")) contacts.get(currentIndex).setPhoto(Boolean.parseBoolean(newValue));
        info(contacts.get(currentIndex));

    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        t = t.append("[ Contacts ]\n");
        int i = 1;
        for (Contact contact : contacts) {
            t = t.append(i).append(") ").append(contact.getClass().getSimpleName()).append(";\n");
            i++;
        }
        return t.toString();
    }
}
