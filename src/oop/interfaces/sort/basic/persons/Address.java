package oop.interfaces.sort.basic.persons;

public class Address implements Comparable<Address> {
    private String city;
    private String street;
    private int house;
    private int zip;

    public Address(String city, String street, int house, int zip) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.zip = zip;
    }

    public String toString() {
        return " city= " + city + " street= " + street + " house= " + house + " zip= " + zip;
    }

    @Override
    public int compareTo(Address o) {
        return o.city.compareTo(city);
    }
}
