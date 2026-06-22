package oop.generic_wildCard;

public class PdfDocument extends ElectronicDocument{

    public PdfDocument(String title) {
        super("pdf", title);
    }

    @Override
    void print() {
        System.out.println("This is PdfDocument class ");
    }
}
