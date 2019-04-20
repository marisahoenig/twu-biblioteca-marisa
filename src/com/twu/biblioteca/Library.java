package com.twu.biblioteca;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    public static Scanner keyboard = new Scanner(System.in);

    public static ArrayList<Book> bookList = new ArrayList<Book>();
    public static ArrayList<Book> checkedOutBookList = new ArrayList<Book>();

    public static String checkoutReturnToggle = ""; //empty string when neither

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
            populateMenu();
        } else if (menuOption.equals("2")) {
            promptForCheckoutBook();
        } else if (menuOption.equals("3")) {
            promptForReturnBook();
        } else if (menuOption.equals("0")) {
            keyboard.close();
        } else {
            throw new IllegalArgumentException("Please select a valid option!");
        }
    }

    public static String listBooks(ArrayList<Book> bookArr) {
        String bookString = "";
        for (Book book : bookArr) {
            bookString += Printer.printBook(book) + "\n";
        }
        System.out.println(Printer.print("Book Title", "Author", "Publication Date"));
        System.out.println(bookString);
        return bookString;
    }

    public static void placeBookOnShelf(Book book) {
        bookList.add(book);
    }

    public static void stockBooks() {
        placeBookOnShelf(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        placeBookOnShelf(new Book("The Hunger Games", "Suzanne Collins", 2008));
        placeBookOnShelf(new Book("Becoming", "Michelle Obama", 2018));
    }

    public static void promptForCheckoutBook() {
        checkoutReturnToggle = "checkout";
        listBooks(bookList);
        System.out.println("Which book would you like to checkout?");
        String bookChoice = askForBookInput();

        boolean validBook = checkoutBook(bookChoice);
        if (validBook) {
            System.out.println("Thank you for checking out " + bookChoice + "! Enjoy the book!");
            populateMenu();
        } else {
            System.out.println("Sorry, that book is not available. Please try a different title or type '0' to return to the menu");
            promptForCheckoutBook();
        }
    }

    // return whether or not the requested book can be checked out
    public static boolean checkoutBook(String bookName) {
        for (Book b : bookList) {
            if (b.getName().equals(bookName)) {
                bookList.remove(b);
                checkedOutBookList.add(b);
                return true;
            }
        }
        return false;
    }

    public static String askForBookInput() {
        String bookChoice = keyboard.nextLine();
        if (bookChoice.equals("0")) {
            populateMenu();
        }
        return bookChoice;
    }

    public static void promptForReturnBook() {
        listBooks(bookList);
        System.out.println("Which book would you like to return?");
        String bookChoice = askForBookInput();

        boolean validBook = returnBook(bookChoice);
        if (validBook) {
            System.out.println("Thank you for returning " + bookChoice + "!");
            populateMenu();
        } else {
            System.out.println("Sorry, that is not a valid book to return. Please try a different title or type '0' to return to the menu.");
            promptForReturnBook();
        }

    }

    public static boolean returnBook(String bookName) {
        for (Book b : checkedOutBookList) {
            if (b.getName().equals(bookName)) {
                checkedOutBookList.remove(b);
                bookList.add(b);
                return true;
            }
        }
        return false;
    }

}
