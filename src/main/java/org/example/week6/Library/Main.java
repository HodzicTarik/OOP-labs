package org.example.week6.Library;

public class Main {
    public static void main(String[] args) {
        /*
        Book cheese = new Book("Cheese Problems Solved", "Woodhead Publishing", 2007);
        System.out.println(cheese.title());
        System.out.println(cheese.publisher());
        System.out.println(cheese.year());
        System.out.println(cheese);*/

        /*
        Library library = new Library();
        Book cheese = new Book("Cheese Problems Solved", "Woodhead Publishing", 2007);
        library.addBook(cheese);
        Book nhl = new Book("NHL Hockey", "Stanley Kupp", 1952);
        library.addBook(nhl);
        library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));
        library.printBooks();*/


        Library library = new Library();

        library.addBook(new Book("Cheese Problems Solved", "Woodhead Publishing", 2007));
        library.addBook(new Book("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        library.addBook(new Book("NHL Hockey", "Stanley Kupp", 1952));
        library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));

        System.out.println("Search by Title 'CHEESE':");
        for (Book book : library.searchByTitle("CHEESE")) {
            System.out.println(book);
        }

        System.out.println("---");

        System.out.println("Search by Publisher 'PENGUIN  ':");
        for (Book book : library.searchByPublisher("PENGUIN  ")) {
            System.out.println(book);
        }

        System.out.println("---");

        System.out.println("Search by Year 1851:");
        for (Book book : library.searchByYear(1851)) {
            System.out.println(book);
        }
    }
}
