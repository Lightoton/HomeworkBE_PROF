package de.telran.Homework4.NewTask;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString

public class Library {
    private  String address;
    private long bookNumbers;
    private List<Book> books;

    public Library(String address, long bookNumbers,List<Book> books) {
        this.address = address;
        this.bookNumbers = bookNumbers;
        this.books = books;
    }
}
