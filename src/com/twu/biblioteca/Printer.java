package com.twu.biblioteca;

import java.util.ArrayList;

public class Printer {

    public static void print(String s) {
        System.out.println(s);
    }

    public static void printWelcome() {
        print("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!");
    }

    public static String returnColumns(String name, String author, String date) {
        return String.format("%-20s", name) + String.format("%-20s", author) + String.format("%-20s", date);
    }

    public static String returnBookInfo(Book book) {
        return returnColumns(book.getTitle(), book.getAuthor(), String.valueOf(book.getPublicationDate()));
    }

    public static void printBooksList(ArrayList<Book> bookArr) {
        String bookString = "";
        for (Book book : bookArr) {
            bookString += returnBookInfo(book) + "\n";
        }
        print(returnColumns("Book Title", "Author", "Publication Date"));
        print(bookString);
    }

    public static void printMenu() {
        print("Menu - Please type the number associated with the option you'd like to select.");
        print("1 - List of Books");
        print("2 - Checkout a Book");
        print("3 - Return a Book");
    }

    public static void printExit() {
        print("Thank you for coming!");
    }

    public static void printCheckoutMessage(boolean validBook) {
        if (validBook) {
            System.out.println("Thank you for checking out " + Menu.bookChoice + "! Enjoy the book!");
            Menu.returnToMenu();
        } else {
            System.out.println("Sorry, that book is not available. Please try a different title or type '9' to return to the menu");
            Menu.promptForCheckoutBook();
        }
    }

    public static void printReturnMessage(boolean validBook) {
        if (validBook) {
            System.out.println("Thank you for returning " + Menu.bookChoice + "!");
            Menu.returnToMenu();
        } else {
            System.out.println("Sorry, that is not a valid book to return. Please try a different title or type '9' to return to the menu.");
            Menu.promptForReturnBook();
        }
    }
}
