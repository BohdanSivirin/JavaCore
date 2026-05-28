package oop.stream.invoices;

public class Customer {
    private String name;
    private String address;
    private String phone;
    private String email;
    private boolean isVip;

    public Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer c)) return false;
        if (email!=null){
            return name.equals(c.name) && address.equals(c.address) && phone.equals(c.phone) && email.equals(c.email);
        }
      return name.equals(c.name) && address.equals(c.address) && phone.equals(c.phone);
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        if (email != null) {
            return 17 * hashCode + name.hashCode() + address.hashCode() + phone.hashCode() + email.hashCode();
        }
        return 17 * hashCode + name.hashCode() + address.hashCode() + phone.hashCode();
    }

    public Customer clone() {
        return new Customer(this.name, this.address, this.phone, this.email);
    }

    public String toString() {
        return "{name: " + name + ", address: " + address + ", phone: " + phone + ", email: " + email + ", isVip: " + isVip + "}";
    }

    public char getFirstLetter() {
        return name.charAt(0);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setVipValue(boolean condition) {
        isVip = condition;
    }
}
