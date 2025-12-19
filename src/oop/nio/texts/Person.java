package oop.nio.texts;

import oop.io.texts.toy.Toy;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

enum Gender {
    MALE,
    FEMALE
}

public class Person implements Serializable {
    private final long id;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private Date date;
    private Gender gender;

    public Person(long id, String name, String surname, String address, String phone, Date date, Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.gender = gender;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return  "id - " + id + "\nname - " + name + "\nsurname - " + surname + "\naddress - " + address
               + "\nphone - " + phone + "\ndate - " + format.format(date) + "\ngender - " + gender;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Person person)) {
            return false;
        }
        return person.id == id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 17 * hashCode + Long.hashCode(id);
        return hashCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
