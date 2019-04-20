package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int publicationDate;

    public Book(String name, String author, int publicationDate) {
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

}
