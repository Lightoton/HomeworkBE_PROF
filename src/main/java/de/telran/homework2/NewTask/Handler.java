package de.telran.homework2.NewTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Handler {
    // Вывести все адреса библиотек
    public static void printAllAddresses(Library[] libraries) {
        for (Library library : libraries) {
            System.out.println(library.getAddress());
        }
    }

    //2. Подсчитать общее количество книг во всех библиотеках
    public static void printTotalBookCount(Library[] libraries) {
        int bookCount = 0;
        for (Library library : libraries) {
            bookCount += library.getBooks().length;
        }
        System.out.println("Number of all books: " + bookCount);
    }


    // //* 3. Вывести названия всех книг в библиотеке
    public static void printAllBookNames(Library[] libraries) {
        for (int i = 0; i < libraries.length; i++) {
            for (int j = 0; j < libraries[i].getBooks().length; j++) {
                System.out.println("Book title " + (j + 1) + " in " + (i + 1) + " library " + " : " + libraries[i].getBooks()[j].getName());
            }

        }
    }

    // * 4. Найти библиотеки, где есть электронные книги
    public static void printLibrariesWithEBooks(Library[] libraries) {
        for (int i = 0; i < libraries.length; i++) {
            for (Book book : libraries[i].getBooks()) {
                if (book.isEbook()) {
                    System.out.println("E-book(s) found in library № " + (i + 1));
                }
            }
        }

    }

    // * 5. Вывести книги в заданном состоянии
    public static void printBooksByCondition(Library[] libraries, Condition condition) {
        for (Library library : libraries) {
            for (Book book : library.getBooks()) {
                if (book.getCondition() == condition) {
                    System.out.println(Arrays.toString(new Book[]{book}));
                }
            }
        }
    }

    // * 6. Вывести список библиотек с количеством книг больше заданного
    public static void printLibrariesWithMoreThanXBooks(Library[] libraries, long count) {
        for (Library library : libraries) {
            if (library.getBookNumbers() > count) {
                System.out.println(Arrays.toString(new Library[]{library}));
            }
        }
    }

    // * 7. Вывести книги, изданные до заданного года
    public static void printBooksIssuedBeforeYear(Library[] libraries, int year) {
        for (Library library : libraries) {
            for (Book book : library.getBooks()) {
                if (book.getYear() < year) {
                    System.out.println(Arrays.toString(new Book[]{book}));
                }
            }
        }
    }

    // * 8. Вывести авторов книг в алфавитном порядке
    public static void printAuthorsAlphabetically(Library[] libraries) {
        for (Library library : libraries) {
            Arrays.sort(library.getBooks(), Comparator.comparing(Book::getAuthor));
            System.out.println(Arrays.toString(library.getBooks()));
        }
    }

    // * 9. Вывести библиотеки, которые не имеют книг
    public static void printLibrariesWithoutBooks(Library[] libraries) {
        for (Library library : libraries) {
            if (library.getBookNumbers() == 0) {
                System.out.println(Arrays.toString(new Library[]{library}));
            }
        }
    }

    // * 10. Вывести книги, названия которых начинаются на заданную букву
    public static void printBooksStartingWithLetter(Library[] libraries, char letter) {
        for (Library library : libraries) {
            for (Book book : library.getBooks()) {
                if (book.getName().charAt(0) == letter) {
                    System.out.println(Arrays.toString(new Book[]{book}));
                }
            }
        }
    }

    // * 11. Вывести библиотеки по убыванию количества книг
    public static void printLibrariesByDescendingBookCount(Library[] libraries) {
        Arrays.sort(libraries, Comparator.comparing(Library::getBookNumbers));
        for (int i = libraries.length - 1; i > 0; i--) {
            System.out.println(libraries[i].getBookNumbers());
            System.out.println(Arrays.toString(new Library[]{libraries[i]}));
        }
    }

    // * 12. Вывести авторов и количество их книг в каждой библиотеке // Увы пока что не разобрался как до конца
    // доделать эту задачу...
    public static void printAuthorsAndTheirBookCounts(Library[] libraries) {
        for (Library library : libraries) {
            int libraryNumBook = (int) library.getBookNumbers();
            int countBook = 1;
            while (libraryNumBook > 0) {
                Arrays.sort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                for (int i = 0; i < library.getBooks().length - 1; i++) {
                    if (library.getBooks()[i].getAuthor().equals(library.getBooks()[i + 1].getAuthor())) {
                        countBook += 1;
                    } else {
                        System.out.println(library.getBooks()[i].getAuthor() + " " + countBook);
                        countBook = 1;
                    }
                    libraryNumBook--;
                }
                if (libraryNumBook == 0) {
                    System.out.println(library.getBooks()[library.getBooks().length - 1].getAuthor() + " " + countBook);
                }
            }
        }
    }

    // * 13. Вывести наиболее часто встречающееся состояние книг
    public static void printMostCommonBookCondition(Library[] libraries) {
        int countNew = 0;
        int countOld = 0;
        int countDam = 0;
        for (Library library : libraries) {
            for (Book book : library.getBooks()) {
                switch (book.getCondition()) {
                    case NEW -> countNew += 1;
                    case OLD -> countOld += 1;
                    case DAMAGE -> countDam += 1;
                }
            }
        }
        if (countNew > countOld && countNew > countDam) {
            System.out.println("Most common condition of books: NEW");
        } else if (countOld > countNew && countOld > countDam) {
            System.out.println("Most common condition of books: OLD");
        } else {
            System.out.println("Most common condition of books: DAMAGE");
        }
    }

    // * 14. Вывести библиотеки, где нет поврежденных книг
    public static void printLibrariesWithoutDamagedBooks(Library[] libraries) {
        for (Library library : libraries) {
            boolean isNotDamaged = true;
            for (Book book : library.getBooks()) {
                if (book.getCondition() == Condition.DAMAGE) {
                    isNotDamaged = false;
                    break;
                }
            }
            if (isNotDamaged) {
                System.out.println(Arrays.toString(new Library[]{library}));
            }
        }
    }

    // * 15. Вывести все уникальные года издания книг //отрабатывет, но ещё не до конца корректно...
    public static void printUniqueIssueYears(Library[] libraries) {
        int bookCount = 0;
        for (Library library : libraries) {
            bookCount += library.getBooks().length;
        }
        int[] uniqueYear = new int[bookCount];
        int count = 0;
        for (Library library : libraries) {
            int i = 0;
            for (int j = 0; j < library.getBooks().length; j++) {
                int currentYear = library.getBooks()[j].getYear();
                boolean isUnique = true;

                for (int e = 0; e < library.getBooks().length - 1; e++) {
                    if (currentYear == library.getBooks()[e + 1].getYear()) {
                        isUnique = false;
                    }
                }

                if (isUnique) {
                    uniqueYear[count++] = currentYear;
                }
            }
        }

        int[] resArrYear = Arrays.copyOf(uniqueYear, count);
        System.out.println(Arrays.toString(resArrYear));

    }

    // * 16. Вывести книги сортированные по году издания в каждой библиотеке
    public static void printBooksSortedByIssueYear(Library[] libraries) {
        int countLibrary = 1;
        for (Library library : libraries) {
            Arrays.sort(library.getBooks(), Comparator.comparing(Book::getYear));
            System.out.println("Library № " + countLibrary + " " + Arrays.toString(library.getBooks()));
            countLibrary += 1;
        }
    }

    // * 17. Вывести количество библиотек, где есть хотя бы одна электронная книга
    public static void printCountOfLibrariesWithAtLeastOneEBook(Library[] libraries) {
        int countLibraryHasEBook = 0;
        for (Library library : libraries) {
            for (Book book : library.getBooks()) {
                if (book.isEbook()) {
                    countLibraryHasEBook += 1;
                    break;
                }
            }
        }
        System.out.println("Number of libraries with at least one e-book: " + countLibraryHasEBook);
    }

    // * 18. Вывести книги, чьё название содержит определённое слово
    public static void printBooksContainingWord(Library[] libraries, String word) {
        for (Library library : libraries) {
            for (Book book : library.getBooks()) {
                if (book.getName().toLowerCase().contains(word.toLowerCase())) {
                    System.out.println(Arrays.toString(new Book[]{book}));
                }
            }

        }
    }


    // * 19. Вывести пары "Автор - Самая старая книга"
    public static void printAuthorsWithOldestBooks(Library[] libraries) {
        for (Library library : libraries) {
            Arrays.sort(library.getBooks(), Comparator.comparing(Book::getYear));
            System.out.println(library.getBooks()[0].getAuthor() + " " + library.getBooks()[0].getYear());
        }
    }

// * 20. Вывести библиотеки, в которых каждая книга - электронная
    public static void printLibrariesWithAllEBooks(Library[] libraries) {
        boolean isEbook = true;
        for (Library library: libraries) {
            for (Book book: library.getBooks()) {
                if (!book.isEbook()){
                    isEbook = false;
                    break;
                }
            }
            if (isEbook){
                System.out.println(Arrays.toString(new Library[]{library}));
            }
        }
    }
// */
}
