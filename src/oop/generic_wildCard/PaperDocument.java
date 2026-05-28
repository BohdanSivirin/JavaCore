package oop.generic_wildCard;

public abstract class PaperDocument extends Document {
    private int pages;

    public PaperDocument(String title, int pages) {
        super(title);
        this.pages = pages;
    }
    public String toString() {
        return "class: " + getClass().getSimpleName() + "\npages: " + pages + "\n";
    }
}
