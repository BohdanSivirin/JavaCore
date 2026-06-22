package oop.generic_wildCard;

public abstract class ElectronicDocument extends Document {
    private String format;

    public ElectronicDocument(String format, String title) {
        super(title);
        this.format = format;
    }

    public String toString() {
        return "class: " + getClass().getSimpleName() + "\nformat: " + format + "\n";
    }
}
