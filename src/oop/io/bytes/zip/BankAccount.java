package oop.io.bytes.zip;

import oop.io.bytes.objects.person.Person;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private long number;
    private long id;
    private int currency;
    private String holder;
    private String clientName;
    private int sum;

    public BankAccount(long number, long id, int currency, String holder, String clientName, int sum) {
        this.number = number;
        this.id = id;
        this.currency = currency;
        this.holder = holder;
        this.clientName = clientName;
        this.sum = sum;
    }

    public String toString() {
        return "clientName " + clientName + " id " + id + " sum " + sum;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof BankAccount bankAccount)) {
            return false;
        }
        return bankAccount.id == id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 17 * hashCode + Long.hashCode(id);
        return hashCode;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public String getClientName() {
        return clientName;
    }

    public String getHolder() {
        return holder;
    }

    public int getCurrency() {
        return currency;
    }

    public long getId() {
        return id;
    }

    public long getNumber() {
        return number;
    }
}
