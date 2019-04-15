package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static Scanner keyboard = new Scanner(System.in);

    public static ArrayList<Book> bookList = new ArrayList<Book>();

    public static void main(String[] args) {
        System.out.println(Welcome() + "\n");

        System.out.println("Menu" + "\n");

        System.out.println("1 - List of Books");
        System.out.println("2 - Checkout a Book");
        askForInput();
    }

    public static void askForInput() {
        String menuOption = keyboard.next();
        selectOption(menuOption);
    }

    public static void selectOption(String menuOption) {
        try {
            validateInput(menuOption);
            if (Integer.parseInt(menuOption) == 1) {
                stockBooks();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askForInput();
        }
    }

    public static void validateInput(String menuOption) throws IllegalArgumentException {
        if (menuOption.equals("1")) {
        } else if (menuOption.equals("2")) {
            askForInput();
        } else if (menuOption.equals("0")) {
            keyboard.close();
        } else {
            throw new IllegalArgumentException("Please select a valid option!");
        }
    }

    public static String Welcome() {
        return "Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!";
    }

    public static String listBooks(ArrayList<Book> bookArr) {
        String bookString = "";
        for (Book book : bookArr) {
            bookString += book.toString() + "\n";
        }
        return bookString;
    }

    public static ArrayList<Book> placeBookOnShelf(Book book) {
        bookList.add(book);
        return bookList;
    }

    public static void stockBooks() {
        placeBookOnShelf(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        placeBookOnShelf(new Book("The Hunger Games", "Suzanne Collins", 2008));
        placeBookOnShelf(new Book("Becoming", "Michelle Obama", 2018));

        System.out.println(String.format("%-20s", "Book Title") + String.format("%-20s", "Author") + String.format("%-20s", "Publication Date"));
        System.out.println(listBooks(bookList));
    }

    // return whether or not the requested book can be checked out
    public static boolean checkoutBook(String bookName) {
        for (Book b : bookList) {
            if (b.getName() == bookName) {
                bookList.remove(b);
                return true;
            }
        }
        return false;
    }

}
