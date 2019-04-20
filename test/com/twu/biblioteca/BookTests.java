package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTests {

    // 1.3
    @Test
    public void CheckBookName() {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        assertEquals("The Hobbit", book1.getTitle());
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
