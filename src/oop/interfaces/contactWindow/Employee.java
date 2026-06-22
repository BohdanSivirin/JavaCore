package oop.interfaces.contactWindow;

public class Employee implements Contact {
    private final int id;
    private String name;
    private String surname;
    private final String position;
    private String phone;
    private String email;
    private String address;
    private final double salary;
    private boolean isHasPhoto;

    public Employee(int id, String name, String surname, String position, String phone, String email, String address, double salary, boolean isHasPhoto) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.isHasPhoto = isHasPhoto;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getType() {
        return getClass().getSimpleName();
    }

    @Override
    public String getPhoto() {
        return Boolean.toString(isHasPhoto);
    }

    @Override
    public void setName(String newValue) {
        name = newValue;
    }

    @Override
    public void setSurname(String newValue) {
        surname = newValue;
    }

    @Override
    public void setPhone(String newValue) {
        phone = newValue;
    }

    @Override
    public void setEmail(String newValue) {
        email = newValue;
    }

    @Override
    public void setAddress(String newValue) {
        address = newValue;
    }

    @Override
    public void setPhoto(boolean newValue) {
        isHasPhoto = newValue;
    }

}
