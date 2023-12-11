package de.telran.homework2.Task2;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Harry Potter", "Johana", 1997),
                new Book("The Great Gatsby", "Scott Fitzgerald", 1925)
        };
        books = new FictionBook().addToCatalog(books);
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", " + "Author: " + book.author + ", " + "year: " + book.year);
        }
        books = new FictionBook().removeFromCatalog(books);
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", " + "Author: " + book.author + ", " + "year: " + book.year);
        }

    }
}
