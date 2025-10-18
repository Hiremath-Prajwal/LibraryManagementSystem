package com.library.main;

import com.library.management.Library;
import com.library.model.Book;
import com.library.model.Patron;

public class LibraryApp {

	public static void main(String[] args) {

        Library library = new Library();

        // ------------------ Add Books ------------------
        Book book1 = new Book("ISBN001", "Clean Code", "Robert C. Martin", 2008);
        Book book2 = new Book("ISBN002", "Effective Java", "Joshua Bloch", 2018);
        Book book3 = new Book("ISBN003", "Design Patterns", "Erich Gamma", 1994);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // ------------------ Add Patrons ------------------
        Patron patron1 = new Patron("P001", "Alice", "alice@example.com");
        Patron patron2 = new Patron("P002", "Bob", "bob@example.com");

        library.addPatron(patron1);
        library.addPatron(patron2);

        // ------------------ Borrow and Return ------------------
        System.out.println("\n--- Borrow Operations ---");
        library.checkoutBook("P001", "ISBN001");
        library.checkoutBook("P002", "ISBN002");

        System.out.println("\n--- Return Operations ---");
        library.returnBook("P001", "ISBN001");

        // ------------------ Search Examples ------------------
        System.out.println("\n--- Search by Title ---");
        library.searchByTitle("Clean Code").forEach(System.out::println);

        System.out.println("\n--- Search by Author ---");
        library.searchByAuthor("Joshua Bloch").forEach(System.out::println);

        System.out.println("\n--- Search by ISBN ---");
        System.out.println(library.searchByIsbn("ISBN003"));

        // ------------------ Display All ------------------
        System.out.println("\n--- All Books ---");
        library.showAllBooks();

        System.out.println("\n--- All Patrons ---");
        library.showAllPatrons();

        // ------------------ Borrowing History ------------------
        System.out.println("\n--- Borrowing History ---");
        patron1.showBorrowingHistory();
        patron2.showBorrowingHistory();
	}

}
