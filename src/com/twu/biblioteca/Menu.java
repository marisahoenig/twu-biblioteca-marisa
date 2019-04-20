package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {

    public static Scanner keyboard = new Scanner(System.in);


    public static void populateMenu() {
        Printer.print("Menu - Please type the number associated with the option you'd like to select.");
        Printer.print("1 - List of Books");
        Printer.print("2 - Checkout a Book");
        Printer.print("3 - Return a Book");
    }

    public static String askForUserInput() {
        String userInput = keyboard.nextLine();
        return userInput;
    }

    public static void selectOption(String menuOption) {
        try {
            validateInput(menuOption);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askForUserInput();
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
            keyboard.close(); //system.exit
        } else {
            throw new IllegalArgumentException("Please select a valid option!");
        }
    }

    public static String askForBookInput() {
        String bookChoice = keyboard.nextLine();
        if (bookChoice.equals("0")) {
            populateMenu();
        }
        return bookChoice;
    }

    public static void promptForCheckoutBook() {
        printBooksList(bookList);
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

    public static void promptForReturnBook() {
        printBooksList(bookList);
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

}
