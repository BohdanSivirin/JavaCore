package oop.io.texts.toy;


import java.util.HashMap;
import java.util.Map;

public class Toy {
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

    public void addFeature(String key, int value) {
        features.put(key, value);
    }

    public void setFeatures(Map<String,Integer> map) {
        features = map;
    }

    public void setToxic(boolean toxic) {
        isToxic = toxic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
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
