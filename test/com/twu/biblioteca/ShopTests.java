package com.twu.biblioteca;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import org.junit.Test;
import java.util.ArrayList;
import java.util.InputMismatchException;
import org.junit.Assert;

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

    // 1.7

    @Test
    public void ShouldCheckOutBook() {
        BibliotecaApp biblioapp = new BibliotecaApp();
        biblioapp.stockBooks();
        Assert.assertTrue(biblioapp.checkoutBook("The Hobbit"));
    }

    @Test
    public void SizeOfBookListShouldDecreaseByOne() {
        BibliotecaApp biblioapp = new BibliotecaApp();
        biblioapp.stockBooks();
        int originalNumberOfBooks = biblioapp.bookList.size();
        biblioapp.checkoutBook("The Hobbit");
        int newNumberOfBooks = biblioapp.bookList.size();
        assertEquals(1, originalNumberOfBooks - newNumberOfBooks);
    }

    @Test
    public void ShouldShowReturnedBookInList() {
        BibliotecaApp biblioapp = new BibliotecaApp();
        biblioapp.stockBooks();
        Book bookToReturn = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        biblioapp.returnBook(bookToReturn.getName());
        for (Book book : biblioapp.bookList) {
            if ((book.getName()).equals(bookToReturn.getName())) {
                assertEquals("The Hobbit", book.getName());
            }
        }

    }

    @Test
    public void SizeOfBookListShouldIncreaseByOne() {
        BibliotecaApp biblioapp = new BibliotecaApp();
        biblioapp.stockBooks();
        biblioapp.checkoutBook("The Hobbit");
        int originalNumberOfBooks = biblioapp.bookList.size();
        biblioapp.returnBook("The Hobbit");
        int newNumberOfBooks = biblioapp.bookList.size();
        assertEquals(1, newNumberOfBooks - originalNumberOfBooks);
    }
}
