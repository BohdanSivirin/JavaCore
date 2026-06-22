package oop.io.bytes.objects.employee;

import java.io.Serializable;

public class Address implements Serializable {
    private String city;
    private String street;
    private int house;

    public Address(String city, String street, int house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }
}
