package de.telran.homework2.NewTask;

import lombok.*;

@Getter
@Setter
@ToString

public class Book {
    private String author;
    private String name;
    private int year;
    private Condition condition;
    private boolean isEbook;

    public Book(String author, String name, int year, Condition condition, boolean isEbook) {
        this.author = author;
        this.name = name;
        this.year = year;
        this.condition = condition;
        this.isEbook = isEbook;
    }
}
