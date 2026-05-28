package oop.generic_wildCard;

public abstract class Document {
    private String title;

    public Document(String title) {
        this.title = title;
    }

    abstract void print();

    public String toString() {
        return "class: " + getClass().getSimpleName() + "\ntitle: " + title + "\n";
    }
}
