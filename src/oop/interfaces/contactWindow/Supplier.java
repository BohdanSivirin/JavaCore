package oop.interfaces.contactWindow;

public class Supplier implements Contact {
    private String name;
    private String phone;
    private String email;
    private final String contactPerson;
    private boolean isHasPhoto;

    public Supplier(String name, String phone, String email, String contactPerson, boolean isHasPhoto) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.contactPerson = contactPerson;
        this.isHasPhoto = isHasPhoto;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return "-";
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
        return "-";
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

    }

    @Override
    public void setPhoto(boolean newValue) {
        isHasPhoto = newValue;
    }
}
