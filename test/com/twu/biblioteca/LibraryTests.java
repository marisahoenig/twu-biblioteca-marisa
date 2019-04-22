package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class LibraryTests {

    @Test
    public void ShouldPlaceBookOnShelf() {
        Library library = new Library();
        Book expectedBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.placeBookOnShelf(expectedBook);
        assertThat(library.bookList.get(0), is(expectedBook));
    }

    // 1.7
//    @Test
//    public void ShouldCheckOutBook() {
//        Library library = new Library();
//        library.stockCurrentBooks();
//
//    }

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
        library.returnBook(bookToReturn.getTitle());
        for (Book book : library.bookList) {
            if ((book.getTitle()).equals(bookToReturn.getTitle())) {
                assertEquals("The Hobbit", book.getTitle());
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
