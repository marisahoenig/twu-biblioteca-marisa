package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTests {

    // 1.1
    @Test
    public void ShouldReturnWelcomeStatementWhenProgramRuns() {
        Library biblioapp = new Library();
        assertEquals("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!", biblioapp.Welcome());
    }

    // 1.2
    @Test
    public void ShouldReturnListOfBooks() {
        Library biblioapp = new Library();
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

//    @Test
//    public void ShouldPlaceBookOnShelf() {
//        Library biblioapp = new Library();
//        assertEquals(biblioapp.bookList, biblioapp.placeBookOnShelf(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925)));
//    }

    // 1.4
    @Test
    public void ShouldReturnValidMenuInput() {
        int input = 1;
        String inputString = String.valueOf(input);
        Library biblioapp = new Library();
        biblioapp.validateInput(inputString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ShouldThrowIllegalArgWhenInvalidNumberEntered() {
        int input = 100000;
        String inputString = String.valueOf(input);
        Library biblioapp = new Library();
        biblioapp.validateInput(inputString);
    }

    // 1.7

    @Test
    public void ShouldCheckOutBook() {
        Library biblioapp = new Library();
        biblioapp.stockBooks();

    }

    @Test
    public void SizeOfBookListShouldDecreaseByOne() {
        Library biblioapp = new Library();
        biblioapp.stockBooks();
        int originalNumberOfBooks = biblioapp.bookList.size();
        biblioapp.checkoutBook("The Hobbit");
        int newNumberOfBooks = biblioapp.bookList.size();
        assertEquals(1, originalNumberOfBooks - newNumberOfBooks);
    }

    @Test
    public void ShouldShowReturnedBookInList() {
        Library biblioapp = new Library();
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
        Library biblioapp = new Library();
        biblioapp.stockBooks();
        biblioapp.checkoutBook("The Hobbit");
        int originalNumberOfBooks = biblioapp.bookList.size();
        biblioapp.returnBook("The Hobbit");
        int newNumberOfBooks = biblioapp.bookList.size();
        assertEquals(1, newNumberOfBooks - originalNumberOfBooks);
    }
}
