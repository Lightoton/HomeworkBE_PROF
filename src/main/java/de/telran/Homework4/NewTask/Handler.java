package de.telran.Homework4.NewTask;

import java.util.*;

public class Handler {
    // Вывести все адреса библиотек
    public static void printAllAddresses(List<Library> libraries) {
        for (Library library : libraries) {
            System.out.println(library.getAddress());
        }
    }

    //
//    //2. Подсчитать общее количество книг во всех библиотеках
    public static void printTotalBookCount(List<Library> libraries) {
        int bookCount = 0;
        for (Library library : libraries) {
            bookCount += library.getBooks().size();
        }
        System.out.println("Number of all books: " + bookCount);
    }

    //
//
//    // //* 3. Вывести названия всех книг в библиотеке
    public static void printAllBookNames(List<Library> libraries) {
        for (int i = 0; i < libraries.size(); i++) {
            for (int j = 0; j < libraries.get(i).getBooks().size(); j++) {
                System.out.println("Book title " + (j + 1) + " in " + (i + 1) + " library " + " : " + libraries.get(i).getBooks().get(j).getName());
            }
        }
    }

    //
//    // * 4. Найти библиотеки, где есть электронные книги
    public static void printLibrariesWithEBooks(List<Library> libraries) {
        for (int i = 0; i < libraries.size(); i++) {
            for (Book book : libraries.get(i).getBooks()) {
                if (book.isEbook()) {
                    System.out.println("E-book(s) found in library № " + (i + 1));
                }
            }
        }
    }

    //
//
//    // * 5. Вывести книги в заданном состоянии
    public static void printBooksByCondition(List<Library> libraries, Condition condition) {
        for (Library library : libraries) {
            for (Book book : library.getBooks()) {
                if (book.getCondition() == condition) {
                    System.out.println(Arrays.toString(new Book[]{book}));
                }
            }
        }
    }

    //
//    // * 6. Вывести список библиотек с количеством книг больше заданного
    public static void printLibrariesWithMoreThanXBooks(List<Library> libraries, long count) {
        for (Library library : libraries) {
            if (library.getBookNumbers() > count) {
                System.out.println(Arrays.toString(new Library[]{library}));
            }
        }
    }

    //
//    // * 7. Вывести книги, изданные до заданного года
    public static void printBooksIssuedBeforeYear(List<Library> libraries, int year) {
        for (Library library : libraries) {
            for (Book book : library.getBooks()) {
                if (book.getYear() < year) {
                    System.out.println(Arrays.toString(new Book[]{book}));
                }
            }
        }
    }

    //
//    // * 8. Вывести авторов книг в алфавитном порядке
    public static void printAuthorsAlphabetically(List<Library> libraries) {
        for (Library library : libraries) {
            List<Book> books = library.getBooks();
            books.sort(Comparator.comparing(Book::getAuthor));
            for (Book book : books) {
                System.out.println(book.getAuthor());
            }
        }
    }

    //
//    // * 9. Вывести библиотеки, которые не имеют книг
    public static void printLibrariesWithoutBooks(List<Library> libraries) {
        for (Library library : libraries) {
            if (library.getBookNumbers() == 0) {
                System.out.println(Arrays.toString(new Library[]{library}));
            }
        }
    }

    //
//    // * 10. Вывести книги, названия которых начинаются на заданную букву
    public static void printBooksStartingWithLetter(List<Library> libraries, char letter) {
        for (Library library : libraries) {
            for (Book book : library.getBooks()) {
                if (book.getName().charAt(0) == letter) {
                    System.out.println(book);
                }
            }
        }
    }

    //
//    // * 11. Вывести библиотеки по убыванию количества книг
    public static void printLibrariesByDescendingBookCount(List<Library> libraries) {
        libraries.sort(Comparator.comparing(Library::getBookNumbers));
        for (Library library : libraries) {
            System.out.println(library);
//            System.out.println(library.getBookNumbers()); //проверка что сортирует всё правильно
        }
    }

    //
//    // * 12. Вывести авторов и количество их книг в каждой библиотеке //
    public static void printAuthorsAndTheirBookCounts(List<Library> libraries) {
        List<Book> books = new ArrayList<>(100);
        for (Library library : libraries) {
            books.addAll(library.getBooks());
            books.sort(Comparator.comparing(Book::getAuthor));
            int countBook = 1;
            for (int i = 0; i < books.size() - 1; i++) {
                if (books.get(i).getAuthor().equals(books.get(i + 1).getAuthor())) {
                    countBook += 1;
                } else {
                    System.out.println(books.get(i).getAuthor() + " " + countBook);
                    countBook = 1;
                }
            }
            System.out.println(books.get(books.size() - 1).getAuthor() + " " + countBook);
        }

    }

    //
//    // * 13. Вывести наиболее часто встречающееся состояние книг
    public static void printMostCommonBookCondition(List<Library> libraries) {
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

    //    // * 14. Вывести библиотеки, где нет поврежденных книг
    public static void printLibrariesWithoutDamagedBooks(List<Library> libraries) {
        for (Library library : libraries) {
            boolean isNotDamaged = true;
            for (Book book : library.getBooks()) {
                if (book.getCondition() == Condition.DAMAGE) {
                    isNotDamaged = false;
                    break;
                }
            }
            if (isNotDamaged) {
                if (library.getBookNumbers() == 0) {
                    System.out.println("The library is empty");
                }
                System.out.println(library);

            }
        }
    }

    //
//    // * 15. Вывести все уникальные года издания книг //
    public static void printUniqueIssueYears(List<Library> libraries) {
        List<Integer> uniqueYear = new ArrayList<>();
        for (Library library : libraries) {
            for (int j = 0; j < library.getBooks().size(); j++) {
                int currentYear = library.getBooks().get(j).getYear();
                boolean isUnique = true;
                for (int e = 0; e < library.getBooks().size() - 1; e++) {
                    if (currentYear == library.getBooks().get(e + 1).getYear()) {
                        isUnique = false;
                    }
                }
                if (isUnique) {
                    uniqueYear.add(currentYear);
                }
            }
        }


        System.out.println(uniqueYear);

    }

    //
//    // * 16. Вывести книги сортированные по году издания в каждой библиотеке
    public static void printBooksSortedByIssueYear(List<Library> libraries) {
        int countLibrary = 1;
        for (Library library : libraries) {
            library.getBooks().sort(Comparator.comparing(Book::getYear));
            System.out.println("Library № " + countLibrary + " " + library);
            countLibrary += 1;
        }
    }

    //
//    // * 17. Вывести количество библиотек, где есть хотя бы одна электронная книга
    public static void printCountOfLibrariesWithAtLeastOneEBook(List<Library> libraries) {
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

    //
//    // * 18. Вывести книги, чьё название содержит определённое слово
    public static void printBooksContainingWord(List<Library> libraries, String word) {
        for (Library library : libraries) {
            for (Book book : library.getBooks()) {
                if (book.getName().toLowerCase().contains(word.toLowerCase())) {
                    System.out.println(book);
                }
            }

        }
    }

    //
//
//    // * 19. Вывести пары "Автор - Самая старая книга"
    public static void printAuthorsWithOldestBooks(List<Library> libraries) {
        List<Book> books = new ArrayList<>(100);
        for (Library library : libraries) {
            books.addAll(library.getBooks());
            books.sort(Comparator.comparing(Book::getAuthor));
        }
        System.out.println("Author: " + books.get(0).getAuthor() + ". Title: " + books.get(0).getName());
    }
//
//// * 20. Вывести библиотеки, в которых каждая книга - электронная
    public static void printLibrariesWithAllEBooks(List<Library> libraries) {
        boolean isEbook = true;
        for (Library library: libraries) {
            for (Book book: library.getBooks()) {
                if (!book.isEbook()){
                    isEbook = false;
                    break;
                }
            }
            if (isEbook){
                System.out.println(library);
            }
        }
    }


}
