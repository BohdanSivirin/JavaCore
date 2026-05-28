package oop.generic_wildCard;

public class Invoice extends PaperDocument{
    public Invoice(int pages) {
        super("Invoice", pages);
    }

    @Override
    void print() {
        System.out.println("This is Invoice class ");
    }

}
