package oop.inheritance.equalsHashcode;

public class Gearbox {
    private String type;
    private int speed;

    public Gearbox(String type, int speed) {
        this.type = type;
        this.speed = speed;
    }

    public String toString() {
        return "Type: " + type + "\nSpeed: " + speed;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Gearbox)) {
            return false;
        }
        Gearbox gearbox = (Gearbox) object;
        return gearbox.speed == speed;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 17 * hashCode + Integer.hashCode(speed);
        hashCode = 17 * hashCode + type.hashCode();
        return hashCode;
    }
}
