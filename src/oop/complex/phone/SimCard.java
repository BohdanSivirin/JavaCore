package oop.complex.phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SimCard {
    private String number;
    private String provider;
    private double tarifSame;
    private double tarifOther;
    private double tarifRouming;
    private double balance;

    public SimCard(String number, double tarifSame, double balance) {
        this.number = number;
        this.tarifSame = tarifSame;
        tarifOther = tarifSame * 1.25;
        tarifRouming = tarifSame * 24.33;
        this.balance = balance;
        this.provider = identifyProvider(number);
    }

    public String identifyProvider(String number) {
        HashMap<String, ArrayList<String>> providers = new HashMap<>();
        ArrayList<String> vodafon = new ArrayList<>();
        Collections.addAll(vodafon, "+38066", "+38099", "+38050");
        providers.put("Vodafon", vodafon);
        ArrayList<String> kyivstar = new ArrayList<>();
        Collections.addAll(kyivstar, "+38067", "+38097", "+38068");
        providers.put("Kyivstar", kyivstar);
        ArrayList<String> life = new ArrayList<>();
        Collections.addAll(life, "+38063", "+38093", "+38073");
        providers.put("Life", life);
        for (String provider : providers.keySet()) {
            ArrayList<String> numbers = providers.get(provider);
            for (String numb : numbers) {
                if (number.startsWith(numb)) {
                    return provider;
                }
            }
        }
        return "Rouming";

    }

    public String info() {
        return "number " + number + "provider " + provider + " tarifSame " + tarifSame + " balance " + balance;
    }

    public void topUpBalance(double value) {
        balance = balance + value;
    }

    public void reduceBalance(double value) {
        if (balance >= 0) {
            balance = balance - value;
        }
    }

    public String getNumber() {
        return number;
    }

    public String getProvider() {
        return provider;
    }

    public double getTarifSame() {
        return tarifSame;
    }

    public double getTarifOther() {
        return tarifOther;
    }

    public double getTarifRouming() {
        return tarifRouming;
    }

    public double getBalance() {
        balance = Math.round(balance);
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
