package oop.io.bytes.objects.person;

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

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Address)) {
            return false;
        }
        Address address = (Address) object;
        return address.city.equals(city)
               && address.street.equals(street)
               && address.house == house;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 17 * hashCode + city.hashCode();
        hashCode = 17 * hashCode + street.hashCode();
        hashCode = 17 * hashCode + Integer.hashCode(house);
        return hashCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }
}
