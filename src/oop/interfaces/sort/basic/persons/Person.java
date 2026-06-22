package oop.interfaces.sort.basic.persons;

import java.util.Date;

public class Person implements Comparable<Person> {
    private final long idCode;
    private final String name;
    private final String surname;
    private final Date dateOfBirth;
    private final double weight;
    private final int height;
    private Address address;

    public Person(long idCode, String name, String surname, Date dateOfBirth, double weight, int height, Address address) {
        this.idCode = idCode;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
        this.address = address;
    }

    public String toString() {
        return "\n * * * * \nidCode " + idCode + "\nname " + name + "\nsurname " + surname + "\ndate Of Birth " + dateOfBirth + "\nweight " + weight + "\nheight " + height + "\naddress = " + address;
    }

    @Override
    public int compareTo(Person person) {
        return address.compareTo(person.address);
//         > 0) return 1;
//        if (dateOfBirth.compareTo(person.dateOfBirth) < 0) return -1;
//        return 0;

//        if (idCode > person.idCode) return 1;
//        if (idCode < person.idCode) return -1;
//        else return 0;

//        return height- person.height;
//        if (height > person.height) return 1;
//        if (height < person.height) return -1;
//        else return 0;
    }
}
