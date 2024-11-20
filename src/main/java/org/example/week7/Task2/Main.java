package org.example.week7.Task2;

import java.util.*;

class Book {
    private final String title;
    private final String author;
    private final String ISBN;
    private final String status;

    public Book(String title, String author, String ISBN, String status) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.status = status;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Optional<Book> findBookByISBN(String ISBN) {
        return books.stream().filter(book -> book.getISBN().equals(ISBN)).findFirst();
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell", "1234567890", "Available"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "1234567891", "Checked Out"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567892", "Reserved"));

        String searchISBN = "1234567890";
        Optional<Book> foundBook = library.findBookByISBN(searchISBN);
        Book defaultBook = new Book("Default Title", "Default Author", "0000000000", "Unavailable");

        System.out.println("Using orElse: " + foundBook.orElse(defaultBook));
        System.out.println("Using orElseGet: " +
                foundBook.orElseGet(() -> new Book("Lazy Default Title", "Lazy Default Author", "1111111111", "Unavailable")));

        String missingISBN = "9999999999";
        Optional<Book> missingBook = library.findBookByISBN(missingISBN);

        System.out.println("Using orElse for missing book: " + missingBook.orElse(defaultBook));
        System.out.println("Using orElseGet for missing book: " +
                missingBook.orElseGet(() -> new Book("Lazy Default Title", "Lazy Default Author", "1111111111", "Unavailable")));
    }
}
