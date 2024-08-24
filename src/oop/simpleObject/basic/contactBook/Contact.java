package oop.simpleObject.basic.contactBook;

public class Contact {
    private String name;
    private String lastName;
    private String phone;
    private String feature;
    private String email;

    public Contact(String name, String lastName, String phone, String feature, String email) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.feature = feature;
        this.email = email;
    }

    public void info() {
        System.out.println("**************");
        System.out.println(" Name - " + name);
        System.out.println(" lastName - " + lastName);
        System.out.println(" phone - " + phone);
        System.out.println(" feature - " + feature);
        System.out.println(" email - " + email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
