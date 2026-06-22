package oop.generic_wildCard;

public class ExcelDocument extends ElectronicDocument{

    public ExcelDocument(String title) {
        super("excel", title);
    }

    @Override
    void print() {
        System.out.println("This is ExcelDocument class ");

    }
}
