package oop.inheritance.equalsHashcode;

public class Engine {
    private int power;
    private String type;
    private double volume;

    public Engine(int power, double volume, String type) {
        this.type = type;
        this.power = power;
        this.volume = volume;

    }

    public String toString() {
        return "Type: " + type + "\nPower: " + power + "\nVolume: " + volume;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Engine)) {
            return false;
        }
        Engine engine = (Engine) object;
        return engine.power == power && engine.volume == volume;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 17 * hashCode + Integer.hashCode(power);
        hashCode = 17 * hashCode + Double.hashCode(volume);
        hashCode = 17 * hashCode + type.hashCode();
        return hashCode;
    }
}
