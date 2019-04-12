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
        ArrayList<String> bookArr = new ArrayList<String>();
        bookArr.add("The Hobbit");
        bookArr.add("The Hunger Games");
        bookArr.add("Becoming");
        assertEquals(bookArr, biblioapp.listBooks(bookArr));
    }

    @Test
    public void ShouldPlaceBookOnShelf() {
        BibliotecaApp biblioapp = new BibliotecaApp();
        ArrayList<String> bookArr = new ArrayList<String>();
        assertEquals(bookArr, biblioapp.placeBookOnShelf("The Great Gatsby", bookArr));
    }
}
