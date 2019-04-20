package com.twu.biblioteca;

import java.util.ArrayList;

public class Printer {

    public static void print(String s) {
        System.out.println(s);
    }

    public static String returnColumns(String name, String author, String date) {
        return String.format("%-20s", name) + String.format("%-20s", author) + String.format("%-20s", date);
    }

    public static String returnBookInfo(Book book) {
        return returnColumns(book.getName(), book.getAuthor(), String.valueOf(book.getPublicationDate()));
    }

    public static void printBooksList(ArrayList<Book> bookArr) {
        String bookString = "";
        for (Book book : bookArr) {
            bookString += returnBookInfo(book) + "\n";
        }
        print(returnColumns("Book Title", "Author", "Publication Date"));
        print(bookString);
    }
}
