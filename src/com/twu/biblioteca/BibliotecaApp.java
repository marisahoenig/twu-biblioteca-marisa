package com.twu.biblioteca;
import java.util.ArrayList;

public class BibliotecaApp {

    public static ArrayList<Book> bookList = new ArrayList<Book>();

    public static void main(String[] args) {
        System.out.println(Welcome() + "\n");

        placeBookOnShelf(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        placeBookOnShelf(new Book("The Hunger Games", "Suzanne Collins", 2008));
        placeBookOnShelf(new Book("Becoming", "Michelle Obama", 2018));

        System.out.println(String.format("%-20s", "Book Title") + String.format("%-20s", "Author") + String.format("%-20s", "Publication Date"));
        System.out.println(listBooks(bookList));

    }

    public static String Welcome() {
        return "Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!";
    }

    public static String listBooks(ArrayList<Book> bookArr) {
        String bookString = "";
        for (Book book : bookArr) {
            bookString += book.toString() + "\n";

//            String bookDetails = String.format("|%20s|", book.toString());
//            bookString += bookDetails + "\n";
        }
        return bookString;
    }

    public static ArrayList<Book> placeBookOnShelf(Book book) {
        bookList.add(book);
        return bookList;
    }

}
