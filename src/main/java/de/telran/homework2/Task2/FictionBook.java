package de.telran.homework2.Task2;

import java.util.Arrays;
import java.util.Scanner;

public class  FictionBook extends AbstractBook {



    public static Book[] addToCatalog1(Book... books) {
        Scanner scanner = new Scanner(System.in);
        Book[] newBookArr = Arrays.copyOf(books, books.length + 1);
        books = newBookArr;
        System.out.println(books.length);
        System.out.println(Arrays.toString(books));
        System.out.print("Укажите название книги: ");
        String title = scanner.next();
        System.out.print("Укажите автора книги: ");
        String author = scanner.next();
        System.out.print("Укажите год выпуска книги: ");
        int year = scanner.nextInt();
        books[books.length - 1] = new Book(title, author, year);
        return books;
    }
    @Override
    Book[] addToCatalog(Book[] books) {

        boolean condition = false;
        do {
            Scanner scanner = new Scanner(System.in);
            Book[] newBookArr = Arrays.copyOf(books, books.length + 1);
            books = newBookArr;
            System.out.println(books.length);
            System.out.println(Arrays.toString(books));
            System.out.print("Укажите название книги: ");
            String title = scanner.next();
            System.out.print("Укажите автора книги: ");
            String author = scanner.next();
            System.out.print("Укажите год выпуска книги: ");
            int year = scanner.nextInt();
            books[books.length - 1] = new Book(title, author, year);

            System.out.print("Хотите добавить ещё книги? Y or N");
            String answer = scanner.next();
            if (answer.equals("Y")){
                condition = true;
            }else {
                condition = false;
            }

        }while (condition);
        return books;
    }

    @Override
    Book[] removeFromCatalog(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        for (Book book : books) {
            System.out.println("Title: " + book.title + ", " + "Author: " + book.author + ", " + "year: " + book.year);
        }
        System.out.println("Какую по счёту книгу вы хотите удалить: ");
        int indexBook = scanner.nextInt()-1;
        Book[] newBookRemoveArr = new Book[books.length-1];
        System.arraycopy(books,0,newBookRemoveArr,0,indexBook);
        System.arraycopy(books,indexBook+1,newBookRemoveArr,indexBook,books.length-indexBook-1);
        return newBookRemoveArr;
    }

    void calculatePopularity(Book[] books) {

    }

    void applyDiscount(Book[] books, double discount) {

    }
}
