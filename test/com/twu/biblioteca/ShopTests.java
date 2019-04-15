package com.twu.biblioteca;


import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import org.junit.Test;
import java.util.ArrayList;
import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;

public class ShopTests {

    // 1.1
    @Test
    public void ShouldReturnWelcomeStatementWhenProgramRuns() {
        BibliotecaApp biblioapp = new BibliotecaApp();
        assertEquals("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!", biblioapp.Welcome());
    }

    // 1.2
    @Test
    public void ShouldReturnListOfBooks() {
        BibliotecaApp biblioapp = new BibliotecaApp();
        ArrayList<Book> bookArr = new ArrayList<Book>();
        bookArr.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        bookArr.add(new Book("The Hunger Games", "Suzanne Collins", 2008));
        bookArr.add(new Book("Becoming", "Michelle Obama", 2018));
        String booksInOrder = "";
        for (Book book : bookArr) {
            booksInOrder += book.toString() + "\n";
        }
        assertEquals(booksInOrder, biblioapp.listBooks(bookArr));
    }

    @Test
    public void ShouldPlaceBookOnShelf() {
        BibliotecaApp biblioapp = new BibliotecaApp();
        assertEquals(biblioapp.bookList, biblioapp.placeBookOnShelf(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925)));
    }

    // 1.4
    @Test
    public void ShouldReturnValidMenuInput() {
        int input = 1;
        String inputString = String.valueOf(input);
        BibliotecaApp biblioapp = new BibliotecaApp();
        biblioapp.validateInput(inputString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ShouldThrowIllegalArgWhenInvalidNumberEntered() {
        int input = 100000;
        String inputString = String.valueOf(input);
        BibliotecaApp biblioapp = new BibliotecaApp();
        biblioapp.validateInput(inputString);
    }

    @Test (expected = InputMismatchException.class)
        public void ShouldThrowInputMismatchWhenInvalidTypeEntered() {
        String input = "book";
        BibliotecaApp biblioapp = new BibliotecaApp();
        biblioapp.validateInput(input);
    }
}