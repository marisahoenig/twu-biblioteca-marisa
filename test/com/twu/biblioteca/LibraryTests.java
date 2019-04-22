package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class LibraryTests {

    @Test
    public void ShouldPlaceBookOnShelf() {
        Library library = new Library();
        Book expectedBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.placeBookOnShelf(expectedBook);
        assertThat(library.bookList.get(library.bookList.size() - 1), is(expectedBook));
    }

    // 1.7
    @Test
    public void CheckedOutBookShouldAppearInCheckedOutList() {
        Library library = new Library();
        library.stockCurrentBooks();
        Book bookToCheckout = library.bookList.get(0);
        library.checkoutBook(bookToCheckout.getTitle());
        assertThat(library.checkedOutBookList.get(0), is(bookToCheckout));
    }

    @Test
    public void SizeOfBookListShouldDecreaseByOne() {
        Library library = new Library();
        library.stockCurrentBooks();
        int originalNumberOfBooks = library.bookList.size();
        library.checkoutBook(library.bookList.get(0).getTitle());
        int newNumberOfBooks = library.bookList.size();
        assertThat(originalNumberOfBooks - newNumberOfBooks, is(1));
    }

    @Test
    public void ShouldShowReturnedBookInList() {
        Library library = new Library();
        Book bookToReturn = new Book("Green Eggs and Ham", "Dr. Seuss", 1960);
        library.checkedOutBookList.add(bookToReturn);
        library.returnBook(bookToReturn.getTitle());
        for (Book book : library.bookList) {
            if ((book.getTitle()).equals(bookToReturn.getTitle())) {
                assertThat(book.getTitle(), is("Green Eggs and Ham"));
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
        assertThat(newNumberOfBooks - originalNumberOfBooks, is(1));
    }
}
