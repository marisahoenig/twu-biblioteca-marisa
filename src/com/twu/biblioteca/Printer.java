package com.twu.biblioteca;

public class Printer {

    public static String print(String name, String author, String date) {
        return String.format("%-20s", name) + String.format("%-20s", author) + String.format("%-20s", date);

    }

    public static String printBook(Book book) {
        return print(book.getName(), book.getAuthor(), String.valueOf(book.getPublicationDate()));
    }
}
