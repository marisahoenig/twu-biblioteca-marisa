package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTests {

    // 1.1
    @Test
    public void ShouldReturnWelcomeStatementWhenProgramRuns() {
        Library library = new Library();
        assertEquals("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!", library.Welcome());
    }

    // 1.2
    @Test
    public void ShouldReturnListOfBooks() {
        Library library = new Library();
        ArrayList<Book> bookArr = new ArrayList<Book>();
        bookArr.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        bookArr.add(new Book("The Hunger Games", "Suzanne Collins", 2008));
        bookArr.add(new Book("Becoming", "Michelle Obama", 2018));
        String booksInOrder = "";
        for (Book book : bookArr) {
            booksInOrder += book.toString() + "\n";
        }
        assertEquals(booksInOrder, library.printBooksList(bookArr));
    }

//    @Test
//    public void ShouldPlaceBookOnShelf() {
//        Library library = new Library();
//        assertEquals(library.bookList, library.placeBookOnShelf(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925)));
//    }

    // 1.4
//    @Test
//    public void ShouldReturnValidMenuInput() {
//        int input = 1;
//        String inputString = String.valueOf(input);
//        Library library = new Library();
//        library.validateInput(inputString);
//    }

    @Test (expected = IllegalArgumentException.class)
    public void ShouldThrowIllegalArgWhenInvalidNumberEntered() {
        int input = 100000;
        String inputString = String.valueOf(input);
        Library library = new Library();
        library.validateInput(inputString);
    }

    // 1.7

    @Test
    public void ShouldCheckOutBook() {
        Library library = new Library();
        library.stockCurrentBooks();

    }

    @Test
    public void SizeOfBookListShouldDecreaseByOne() {
        Library library = new Library();
        library.stockCurrentBooks();
        int originalNumberOfBooks = library.bookList.size();
        library.checkoutBook("The Hobbit");
        int newNumberOfBooks = library.bookList.size();
        assertEquals(1, originalNumberOfBooks - newNumberOfBooks);
    }

    @Test
    public void ShouldShowReturnedBookInList() {
        Library library = new Library();
        library.stockCurrentBooks();
        Book bookToReturn = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        library.returnBook(bookToReturn.getName());
        for (Book book : library.bookList) {
            if ((book.getName()).equals(bookToReturn.getName())) {
                assertEquals("The Hobbit", book.getName());
            }
        }

    }

    @Test
    public void SizeOfBookListShouldIncreaseByOne() {
        Library library = new Library();
        library.stockCurrentBooks();
        library.checkoutBook("The Hobbit");
        int originalNumberOfBooks = library.bookList.size();
        library.returnBook("The Hobbit");
        int newNumberOfBooks = library.bookList.size();
        assertEquals(1, newNumberOfBooks - originalNumberOfBooks);
    }
}
