package oop.interfaces.contactWindow;

public class Delivery implements Contact {
    private String title;
    private String phone;
    private String email;
    private String address;
    private boolean isHasPhoto;

    public Delivery(String title, String phone, String email, String address, boolean isHasPhoto) {
        this.title = title;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.isHasPhoto = isHasPhoto;
    }

    @Override
    public String getName() {
        return title;
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
        title = newValue;
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
        address = newValue;
    }

    @Override
    public void setPhoto(boolean newValue) {
        isHasPhoto = newValue;
    }
}
