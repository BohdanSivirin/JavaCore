package oop.collections.hashMap.library;

import java.util.Scanner;

public class Book {
    private String author;
    private String title;
    private String genre;
    private String year;
    private String pages;


    public Book() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Введите данные книги -> \n Автор : ");
        this.author = scanner.next();
        System.out.println(" Название : ");
        this.title = scanner.next();
        System.out.println(" Жанр : ");
        this.genre = scanner.next();
        System.out.println(" Год : ");
        this.year = scanner.next();
        System.out.println(" Кол-во страниц : ");
        this.pages = scanner.next();
    }

    public void info() {
        System.out.println(" Автор : " + author);
        System.out.println(" Название : " + title);
        System.out.println(" Жанр : " + genre);
        System.out.println(" Год : " + year);
        System.out.println(" Кол-во страниц : " + pages);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }
}
