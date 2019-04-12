package com.twu.biblioteca;


import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class Tests {

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

    // 1.3
    @Test
    public void CheckBookName() {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        assertEquals("The Hobbit", book1.getName());
    }

    @Test
    public void CheckBookAuthor() {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        assertEquals("J.R.R. Tolkien", book1.getAuthor());
    }

    @Test
    public void CheckBookPublicationDate() {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        assertEquals(1937, book1.getPublicationDate());
    }
}
