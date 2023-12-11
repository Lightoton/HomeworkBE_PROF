package de.telran.homework2.Task2;

abstract class AbstractBook {
    abstract  Book[] addToCatalog(Book[] books);
    abstract Book[] removeFromCatalog(Book[] books);

}
abstract class AbstractUser{
   abstract void borrowBook(Book[] books);
   abstract void returnBook(Book[] books);

}
interface ICatalogManagement{
   void sortBooksByTitle(Book[] books);
   void findBooksByAuthor(Book[] books, String author);

}
interface IUserManagement{
    void registerUser(User user);
    void deleteUser(User user);
}
//Абстрактные Классы:
//AbstractBook:
//Методы:
//addToCatalog(Book[] books): Добавление книги в каталог.
//removeFromCatalog(Book[] books): Удаление книги из каталога.
//
//AbstractUser:
//Методы:
//borrowBook(Book[] books): Взятие книги на время.
//returnBook(Book[] books): Возврат книги.
//
//Интерфейсы:
//ICatalogManagement:
//Методы:
//sortBooksByTitle(Book[] books): Сортировка книг по названию.
//findBooksByAuthor(Book[] books, String author): Поиск книг по автору.
//
//IUserManagement:
//Методы:
//registerUser(User user): Регистрация пользователя.
//deleteUser(User user): Удаление пользователя.


class NonFictionBook extends AbstractBook{

    @Override
    Book[] addToCatalog(Book[] books) {

        return books;
    }

    @Override
    Book[] removeFromCatalog(Book[] books) {

        return books;
    }
    void updateInformation(Book[] books, String newInfo){

    }
    void listRelatedBooks(Book[] books, String topic){

    }
}
class BookCatalog implements ICatalogManagement{

    @Override
    public void sortBooksByTitle(Book[] books) {

    }

    @Override
    public void findBooksByAuthor(Book[] books, String author) {

    }
    void listNewArrivals(Book[] books){

    }
    void listMostBorrowedBooks(Book[] books){

    }
}
class UserAccounts extends AbstractUser implements IUserManagement{

    @Override
    void borrowBook(Book[] books) {

    }

    @Override
    void returnBook(Book[] books) {

    }

    @Override
    public void registerUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
    void updateAccount(User user, AccountDetails details){

    }
    void trackUserHistory(User user){

    }

}
class BookReview extends FictionBook{
    void addReview(Book[] books, Review review){

    }
    void listReviews(Book[] books){

    }
}
class ReferenceBook extends NonFictionBook{
    void listReferences(Book[] books){

    }
    void updateReferences(Book[] books, Reference[] newReferences){

    }
}
class LibraryAnalytics implements ICatalogManagement{

    @Override
    public void sortBooksByTitle(Book[] books) {

    }

    @Override
    public void findBooksByAuthor(Book[] books, String author) {

    }
    void calculateAverageRating(Book[] books){

    }
    void findLeastReadBooks(Book[] books){

    }

}
class Ebook extends FictionBook{
    void downloadBook(Book[] books){

    }
    void updateEbookFormat(Book[] books, String format){

    }
}
//Классы:
//FictionBook (наследует AbstractBook):
//Методы:
//calculatePopularity(Book[] books): Вычисление популярности.
//applyDiscount(Book[] books, double discount): Применение скидки.
//
//NonFictionBook (наследует AbstractBook):
//Методы:
//updateInformation(Book[] books, String newInfo): Обновление информации о книге.
//listRelatedBooks(Book[] books, String topic): Список книг по теме.
//
//BookCatalog (реализует ICatalogManagement):
//Методы:
//listNewArrivals(Book[] books): Список новых поступлений.
//listMostBorrowedBooks(Book[] books): Список наиболее взятых книг.
//
//UserAccounts (наследует AbstractUser, реализует IUserManagement):
//Методы:
//updateAccount(User user, AccountDetails details): Обновление учетной записи.
//trackUserHistory(User user): Отслеживание истории пользователя.
//
//BookReview (наследует FictionBook):
//Методы:
//addReview(Book[] books, Review review): Добавление отзыва.
//listReviews(Book[] books): Список отзывов.
//
//ReferenceBook (наследует NonFictionBook):
//Методы:
//listReferences(Book[] books): Список ссылок.
//updateReferences(Book[] books, Reference[] newReferences): Обновление списка ссылок.
//
//LibraryAnalytics (реализует ICatalogManagement):
//Методы:
//calculateAverageRating(Book[] books): Вычисление средней оценки книг.
//findLeastReadBooks(Book[] books): Поиск наименее читаемых книг.
//
//Ebook (наследует FictionBook):
//Методы:
//downloadBook(Book[] books): Скачивание книги.
//updateEbookFormat(Book[] books, String format): Обновление формата электронной книги.