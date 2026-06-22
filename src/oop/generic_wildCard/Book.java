package oop.generic_wildCard;

public class Book extends PaperDocument{

    public Book(int pages) {
        super("Book", pages);
    }

    @Override
    void print() {
        System.out.println("This is Book class ");
    }
}
