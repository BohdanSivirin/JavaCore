package oop.stream.invoices;

public class Employee {
    private long staffId;
    private String name;
    private String phone;

    public Employee(long staffId, String name, String phone) {
        this.staffId = staffId;
        this.name = name;
        this.phone = phone;
    }

    public Employee clone() {
        return new Employee(this.staffId, this.name, this.phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Employee c)) return false;
        return staffId == c.staffId;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        return 17 * hashCode + Long.hashCode(staffId);
    }

    @Override
    public String toString() {
        return "{staff Id: " + staffId + ", name: " + name + ", phone: " + phone + "}";
    }

    public long getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
