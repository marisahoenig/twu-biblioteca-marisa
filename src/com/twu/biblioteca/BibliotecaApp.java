package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static Scanner keyboard = new Scanner(System.in);

    public static ArrayList<Book> bookList = new ArrayList<Book>();

    public static void main(String[] args) {
        System.out.println(Welcome() + "\n");
        stockBooks();
        populateMenu();
    }

    public static String Welcome() {
        return "Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!";
    }

    public static void populateMenu() {
        System.out.println("Menu" + "\n");
        System.out.println("Please type the number associated with the option you'd like to select.");

        System.out.println("1 - List of Books");
        System.out.println("2 - Checkout a Book");
        System.out.println("3 - Return a Book");
        askForInput();
    }

    public static void askForInput() {
        String menuOption = keyboard.nextLine();
        selectOption(menuOption);
    }

    public static void selectOption(String menuOption) {
        try {
            validateInput(menuOption);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askForInput();
        }
    }

    public static void validateInput(String menuOption) throws IllegalArgumentException {
        if (menuOption.equals("1")) {
            listBooks(bookList);
        } else if (menuOption.equals("2")) {
            promptForCheckoutBook();
        } else if (menuOption.equals("0")) {
            keyboard.close();
        } else {
            throw new IllegalArgumentException("Please select a valid option!");
        }
    }

    public static void promptForCheckoutBook() {
        listBooks(bookList);
        System.out.println("Which book would you like to checkout?");
        askForBookInput();
    }

    public static void askForBookInput() {
        String bookChoice = keyboard.nextLine();
        if (bookChoice.equals("0")) {
            populateMenu();
        } else {
            boolean validBook = checkoutBook(bookChoice);
            if (validBook) {
                System.out.println("Thank you for checking out " + bookChoice + "! Enjoy the book!");
                listBooks(bookList);
            } else {
                System.out.println("Sorry, that book is not available. Please try a different title or type '0' to return to the menu.");
                askForBookInput();
            }
        }
    }

    public static String listBooks(ArrayList<Book> bookArr) {
        String bookString = "";
        for (Book book : bookArr) {
            bookString += book.toString() + "\n";
        }
        System.out.println(String.format("%-20s", "Book Title") + String.format("%-20s", "Author") + String.format("%-20s", "Publication Date"));
        System.out.println(bookString);
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
    }

    // return whether or not the requested book can be checked out
    public static boolean checkoutBook(String bookName) {
        for (Book b : bookList) {
            if (b.getName().equals(bookName)) {
                bookList.remove(b);
                return true;
            }
        }
        return false;
    }

}
