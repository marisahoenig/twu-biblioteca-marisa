package com.twu.biblioteca;
import java.util.ArrayList;

public class Library {

    public static ArrayList<Book> bookList = new ArrayList<Book>();
    public static ArrayList<Book> checkedOutBookList = new ArrayList<Book>();

    public static void main(String[] args) {
        stockCurrentBooks();
        Printer.printWelcome();
        Menu.returnToMenu();
    }

    public static void placeBookOnShelf(Book book) {
        bookList.add(book);
    }

    public static void stockCurrentBooks() {
        placeBookOnShelf(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        placeBookOnShelf(new Book("The Hunger Games", "Suzanne Collins", 2008));
        placeBookOnShelf(new Book("Becoming", "Michelle Obama", 2018));
    }

    public static boolean checkedoutBook(String bookTitle) {
        for (Book b : bookList) {
            if (b.getTitle().equals(bookTitle)) {
                bookList.remove(b);
                checkedOutBookList.add(b);
                return true;
            }
        }
        return false;
    }

    public static boolean returnedBook(String bookTitle) {
        for (Book b : checkedOutBookList) {
            if (b.getTitle().equals(bookTitle)) {
                checkedOutBookList.remove(b);
                bookList.add(b);
                return true;
            }
        }
        return false;
    }

}