package oop.generic_wildCard;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main_1 {
    public static void main(String[] args) {
        PdfDocument pdf = new PdfDocument("PDF");
        WordDocument word = new WordDocument("Word");
        ExcelDocument excel = new ExcelDocument("Excel");
        Contract contract = new Contract(11);
        Invoice invoice = new Invoice(22);
        Book book = new Book(378);

        List<Document> documentList = Arrays.asList(pdf, word, excel, contract, invoice, book);
        List<ElectronicDocument> electronicDocumentList = Arrays.asList(pdf, word, excel);
        List<PaperDocument> paperDocumentList = Arrays.asList(contract, invoice, book);
        List<WordDocument> wordDocumentList = Arrays.asList(
                new WordDocument("Instruction"),
                new WordDocument("SalaryList"),
                new WordDocument("PersonsList"));
        ElectronicDocument newDocument = new WordDocument("newDocument");
        Object newBook = new Book(499);
        Document docs = contract;
        //documentList = electronicDocumentList; //invariants
        //electronicDocumentList = wordDocumentList;
    }
}
