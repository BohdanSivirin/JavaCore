package oop.generic_wildCard;

public class WordDocument extends ElectronicDocument{

    public WordDocument(String title) {
        super("docx", title);
    }

    @Override
    void print() {
        System.out.println("This is WordDocument class ");

    }
}
