package oop.io.person;

import java.util.Date;

public class Person {
    private String name;
    private String surname;
    private double weight;
    private boolean isMarried;
    private final long inn;
    private Date date;
    private Address address;
    private byte[] photo;

    public Person(String name, String surname, double weight, boolean isMarried, long inn, Date date, Address address, byte[] photo) {
        this.name = name;
        this.surname = surname;
        this.weight = weight;
        this.isMarried = isMarried;
        this.inn = inn;
        this.date = date;
        this.address = address;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    public long getInn() {
        return inn;
    }
}
