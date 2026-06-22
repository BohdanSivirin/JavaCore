package oop.generic_wildCard;

public class Contract extends PaperDocument{

    public Contract(int pages) {
        super("Contract", pages);
    }

    @Override
    void print() {
        System.out.println("This is Contract class ");
    }
}
