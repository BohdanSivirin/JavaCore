package oop.io.bytes.objects.employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Employee implements Serializable {
    private long id;
    private String name;
    private Date date;
    private ArrayList<String> phones;
    private Address address;
    private ArrayList<Document> docs;
    private String position;
    private int exp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Employee(long id, String name, Date date, Address address, ArrayList<Document> docs, String position, int exp, ArrayList<String> phones) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
        this.docs = docs;
        this.position = position;
        this.exp = exp;
        this.phones = phones;
    }

    public String toString() {
        return "name " + name + " id " + id + " position " + position + " exp " + exp;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Employee employee)) {
            return false;
        }
        return employee.id == id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 17 * hashCode + Long.hashCode(id);
        return hashCode;
    }

}
