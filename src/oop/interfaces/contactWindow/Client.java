package oop.interfaces.contactWindow;

public class Client implements Contact {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String address;

    public Client(String name, String surname, String phone, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.address = address;
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
        return "";
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

    }
}
