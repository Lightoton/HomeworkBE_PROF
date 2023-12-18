package de.telran.Homework4.NewTask;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    private static final Faker FAKER = new Faker();

    private static final Random RANDOM = new Random();

    private static Condition randomConditionGen() {
        Condition[] conditions = Condition.values();
        int index = RANDOM.nextInt(3);
        return conditions[index];
    }

    private static boolean isEBOOKRandomGen() {
        boolean[] isEbook = {true, false};
        int index = RANDOM.nextInt(2);
        return isEbook[index];
    }

    public static List<Book> bookGenerator(int bookNumbers) {
        List<Book> books = new ArrayList<>(bookNumbers);
        for (int i = 0; i <bookNumbers ; i++) {
            boolean isEB = isEBOOKRandomGen();
            books.add(new Book(FAKER.book().author(),
                    FAKER.book().title(),
                    bookIssueDate(),
                    randomConditionGen(),
                    isEB));

        }
        return books;

    }

    private static int bookIssueDate() {
        return RANDOM.nextInt(2022 - 1900) + 1900;
    }

    public static List<Library> libraryGen(int numLib){
        List<Library> libraries = new ArrayList<>(numLib);
        for (int i = 0; i < numLib; i++) {
            int bookNum = RANDOM.nextInt(21);
            libraries.add(new Library(FAKER.address().streetAddress(),bookNum,bookGenerator(bookNum))) ;
        }
        return libraries;
    }
}
