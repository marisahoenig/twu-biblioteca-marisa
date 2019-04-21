package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {

    public static Scanner keyboard = new Scanner(System.in);
    public static String bookChoice;

    public static String askForUserInput() {
        String userInput = keyboard.nextLine();
        return userInput;
    }

    public static void returnToMenu() {
        Printer.printMenu();
        Menu.selectMenuOption(Menu.askForUserInput());
    }

    public static void selectMenuOption(String menuOption) {
        try {
            validateInput(menuOption);
        } catch (IllegalArgumentException e) {
            Printer.print(e.getMessage());
            askForUserInput();
        }
    }

    public static void validateInput(String menuOption) throws IllegalArgumentException {
        if (menuOption.equals("1")) {
            Printer.printBooksList(Library.bookList);
            Printer.print("Type '9' to return to menu.");
            Menu.selectMenuOption(Menu.askForUserInput());
        } else if (menuOption.equals("2")) {
            promptForCheckoutBook();
            Printer.printCheckoutMessage(Library.checkedoutBook(bookChoice));
        } else if (menuOption.equals("3")) {
            promptForReturnBook();
            Printer.printReturnMessage(Library.returnedBook(bookChoice));
        } else if (menuOption.equals("0")) {
            Printer.printExit();
            System.exit(0);
        } else if (menuOption.equals("9")) {
            returnToMenu();
        } else {
            throw new IllegalArgumentException("Please select a valid option!");
        }
    }

    public static void askForBookInput() {
        bookChoice = keyboard.nextLine();
        if (bookChoice.equals("9")) {
            returnToMenu();
        } else if (bookChoice.equals("0")) {
            Printer.printExit();
            System.exit(0);
        }
    }

    public static void promptForCheckoutBook() {
        Printer.printBooksList(Library.bookList);
        System.out.println("Which book would you like to checkout?");
        askForBookInput();
    }

    public static void promptForReturnBook() {
        Printer.printBooksList(Library.bookList);
        System.out.println("Which book would you like to return?");
        askForBookInput();
    }
}
