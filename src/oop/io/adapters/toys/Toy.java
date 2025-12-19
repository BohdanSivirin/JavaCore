package oop.io.adapters.toys;

import java.io.Serializable;
import java.util.Map;

public class Toy implements Serializable {
    private String title;
    private double price;
    private int ageFrom;
    private String material;
    private Map<String, Integer> features;
    private boolean isToxic;
    private long barcode;

    public Toy(String title, double price, int ageFrom, String material, boolean isToxic, long barcode, Map<String, Integer> features) {
        this.title = title;
        this.price = price;
        this.ageFrom = ageFrom;
        this.material = material;
        this.isToxic = isToxic;
        this.barcode = barcode;
        this.features = features;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Map<String, Integer> getFeatures() {
        return features;
    }

    public void setFeatures(Map<String, Integer> features) {
        this.features = features;
    }

    public boolean isToxic() {
        return isToxic;
    }

    public void setToxic(boolean toxic) {
        isToxic = toxic;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("toy - " + title + "\nprice = " + price + " $" + "\nage from " + ageFrom + " years" + "\nmaterial: " + material + "\nfeatures: \n");
        int i = 1;
        for (String key : features.keySet()) {
            stringBuilder.append(i).append(") ").append(key).append(" - ").append(features.get(key)).append("\n");
            i++;
        }
        stringBuilder.append("toxic - ").append(isToxic ? "yes" : "no").append("\nbarcode - ").append(barcode);
        return stringBuilder.toString();
    }
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Toy toy)) {
            return false;
        }
        return toy.barcode == barcode;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 17 * hashCode + Long.hashCode(barcode);
        return hashCode;
    }
}