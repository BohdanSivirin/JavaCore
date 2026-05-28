package oop.generic_wildCard;

import javax.print.Doc;
import java.util.*;

public class Main_2 {
    public static void main(String[] args) {
        Box<Integer> numsBox = new Box<>(34);
        Box<Character> charsBox = new Box<>('n');

        PdfDocument pdf = new PdfDocument("PDF");
        WordDocument word = new WordDocument("Word");
        ExcelDocument excel = new ExcelDocument("Excel");
        Contract contract = new Contract(11);
        Invoice invoice = new Invoice(22);
        Book book = new Book(378);

        List<Invoice> invoices = new ArrayList<>();
        List<Document> documentList = new ArrayList<>(Arrays.asList(pdf, word, excel, contract, invoice, book));
        List<ElectronicDocument> electronicDocumentList = new ArrayList<>(Arrays.asList(pdf, word, excel));
        List<PaperDocument> paperDocumentList = Arrays.asList(contract, invoice, book);
        List<WordDocument> wordDocumentList = new ArrayList<>();
        Collections.addAll(wordDocumentList,
                new WordDocument("Instruction"),
                new WordDocument("SalaryList"),
                new WordDocument("PersonsList"));
//        List<WordDocument> wordDocumentList = Arrays.asList(
//                new WordDocument("Instruction"),
//                new WordDocument("SalaryList"),
//                new WordDocument("PersonsList"));
List<PdfDocument> pdfDocumentList = new ArrayList<>();

        method0(numsBox);
        method0(charsBox);

        // method1(documentList);
        //method1(electronicDocumentList);
//        method1(paperDocumentList);
        //  method1(wordDocumentList);

        List<String> stringList = Arrays.asList("1", "2", "3", "4");
        List<Object> objects = Arrays.asList(new Book(12), new Book(88), "text", 56.77);
//        method2(documentList);
//        method2(electronicDocumentList);
//        method2(paperDocumentList);
//        method2(wordDocumentList);
//        method2(stringList);
//        method2(objects);

        boolean isContains = stringList.containsAll(electronicDocumentList);
        isContains = stringList.containsAll(Set.of(23.34, 56.66, 99.05));
        System.out.println("isContains " + isContains);
        Collections.reverse(stringList);
        System.out.println(stringList);
        isContains = Collections.disjoint(stringList, paperDocumentList);
        System.out.println();


//        method3(documentList);
//        method3(electronicDocumentList);
//        method3(paperDocumentList);
//        method3(invoices);
//        method3(stringList);
//        method3(objects);
//        wordDocumentList.add(new WordDocument("new Word doc"));
//        method3(documentList);
//        System.out.println(" documentList after added new Book  ");
//        for (int i = 0; i < invoices.size(); i++) {
//            invoices.get(i).print();
//        }
//        method3(electronicDocumentList);
//        System.out.println(" documentList after added new Book  ");
//        for (int i = 0; i < electronicDocumentList.size(); i++) {
//            electronicDocumentList.get(i).print();
//        }
//        method4(paperDocumentList);
//        method4(stringList);

//        documentList.addAll(invoices);
//        documentList.addAll(electronicDocumentList);
//        electronicDocumentList.addAll(wordDocumentList);
//
//        wordDocumentList.addAll(wordDocumentList);
//

        method5(documentList, electronicDocumentList);
        System.out.println(" method5 ");
        for (int i = 0; i < electronicDocumentList.size(); i++) {
            electronicDocumentList.get(i).print();
        }
//        method5(documentList,wordDocumentList);
//        method5(documentList,pdfDocumentList);
        method5(documentList,electronicDocumentList);
        method5(documentList,documentList);
        method5(documentList,objects);
        method5(documentList,pdfDocumentList);

        ElectronicDocument wordDoc = new WordDocument("wordDoc");
       Collections.addAll(electronicDocumentList,pdf,word,excel,wordDoc);

    }

    public static void method0(Box<?> box) {

    }

    public static void method1(List<Document> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).print();
        }
    }

    public static <T extends Document> void method3(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).print();
        }
        list.add((T) new Book(45));
    }

    public static void method4(List<? extends Document> list) {
        // если у wild card стоит extends - можно только брать элементы, но нельзя добавить, для безопасности
        for (int i = 0; i < list.size(); i++) {
            Document doc = list.get(i);
            doc.print();
        }
        //list.add((Document) new Book(10));
//        list.add(new Object());
    }

    public static void method2(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            //list.get(i).print();
            Object someValue = list.get(i);
            if (someValue instanceof Document) {
                Document document = (Document) someValue;
                document.print();
            }
        }
        // нельзя добавить еэелементы в лист параметра ? из за безопасности
        // вынимать с листа параметра ? только тип Object
        // list.add((Object) new Book(1000));
    }

    public static void method5(List<? extends Document> source, List<? super PdfDocument> destination) {
        for (int i = 0; i < source.size(); i++) {
            Document document = source.get(i);
            if (document instanceof PdfDocument) {
                destination.add((PdfDocument) document);
            }
        }
    }

}
