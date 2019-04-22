package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookTests {

    // 1.3
    @Test
    public void CheckBookName() {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        assertThat(book1.getTitle(), is("The Hobbit"));
    }

    @Test
    public void CheckBookAuthor() {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        assertThat(book1.getAuthor(), is("J.R.R. Tolkien"));
    }

    @Test
    public void CheckBookPublicationDate() {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        assertThat(book1.getPublicationDate(), is(1937));
    }
}
