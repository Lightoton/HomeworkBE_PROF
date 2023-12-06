package de.telran.homeworkTest;

import java.util.Arrays;

public class Books {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Harry Potter", "Johana", 1997),
                new Book("The Great Gatsby", "Scott Fitzgerald", 1925)
        };
        printInfoBooks(books);
    }

    public static void printInfoBooks(Book[] books) {
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", " + "Author: " + book.author + ", " + "year: " + book.year);
        }
    }
}
//Создайте класс Book с полями title, author и year.
// Затем создайте массив объектов типа Book и заполните его
// несколькими книгами. Напишите метод, который принимает
// массив книг в качестве параметра и выводит информацию о каждой книге.