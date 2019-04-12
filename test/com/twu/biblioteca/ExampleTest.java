package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void ShouldReturnWelcomeStatementWhenProgramRuns() {
        BibliotecaApp biblioapp = new BibliotecaApp();
        assertEquals("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!", biblioapp.Welcome());
    }
}
