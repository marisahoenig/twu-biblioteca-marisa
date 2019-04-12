package com.twu.biblioteca;
import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Welcome());

        ArrayList<String> bookArr = new ArrayList<String>();
        placeBookOnShelf("The Hobbit", bookArr);
        placeBookOnShelf("The Hunger Games", bookArr);
        placeBookOnShelf("Becoming", bookArr);
        System.out.println(listBooks(bookArr));

    }

    public static String Welcome() {
        return "Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!";
    }

    public static ArrayList<String> listBooks(ArrayList<String> bookArr) {
        return bookArr;
    }

    public static ArrayList<String> placeBookOnShelf(String book, ArrayList<String> bookArr) {
        bookArr.add(book);
        return bookArr;
    }
}
