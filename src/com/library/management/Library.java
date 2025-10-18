package com.library.management;

import java.util.*;
import java.util.logging.Logger;

import com.library.model.*;


/**
 * Library class acts as a central manager for books, patrons, and transactions.
 * Demonstrates OOP concepts and uses logging for tracking events and errors.
 */
public class Library {

    private static final Logger logger = Logger.getLogger(Library.class.getName());

    // --- Collections (Encapsulation) ---
    private Map<String, Book> books;
    private Map<String, Patron> patrons;

    // --- Constructor ---
    public Library() {
        this.books = new HashMap<>();
        this.patrons = new HashMap<>();
        logger.info("Library system initialized.");
    }

    // -------------------- BOOK MANAGEMENT --------------------

    /** Adds a new book to the library. */
    public void addBook(Book book) {
        if (book == null) {
            logger.warning("Attempted to add a null book.");
            return;
        }
        if (books.containsKey(book.getIsbn())) {
            logger.warning("Book with ISBN " + book.getIsbn() + " already exists.");
            return;
        }
        books.put(book.getIsbn(), book);
        logger.info("Book added: " + book);
    }

    /** Removes a book from the library by ISBN. */
    public void removeBook(String isbn) {
        Book removed = books.remove(isbn);
        if (removed != null) {
            logger.info("Book removed: " + removed);
        } else {
            logger.warning("No book found with ISBN: " + isbn);
        }
    }

    /** Updates a book's details. */
    public void updateBook(String isbn, String title, String author, int year) {
        Book book = books.get(isbn);
        if (book == null) {
            logger.warning("Cannot update. Book not found: " + isbn);
            return;
        }
        // Note: You could replace the object, but let's keep immutability simple here
        removeBook(isbn);
        addBook(new Book(isbn, title, author, year));
        logger.info("Book updated for ISBN: " + isbn);
    }

    /** Search by title (case-insensitive). */
    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        logger.info("Search by title '" + title + "' found " + result.size() + " book(s).");
        return result;
    }

    /** Search by author (case-insensitive). */
    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        logger.info("Search by author '" + author + "' found " + result.size() + " book(s).");
        return result;
    }

    /** Search by ISBN (exact match). */
    public Book searchByIsbn(String isbn) {
        Book found = books.get(isbn);
        if (found != null) {
            logger.info("Found book by ISBN: " + isbn);
        } else {
            logger.warning("No book found for ISBN: " + isbn);
        }
        return found;
    }

    // -------------------- PATRON MANAGEMENT --------------------

    /** Adds a new patron to the library. */
    public void addPatron(Patron patron) {
        if (patron == null) {
            logger.warning("Attempted to add a null patron.");
            return;
        }
        if (patrons.containsKey(patron.getPatronId())) {
            logger.warning("Patron with ID " + patron.getPatronId() + " already exists.");
            return;
        }
        patrons.put(patron.getPatronId(), patron);
        logger.info("Patron added: " + patron);
    }

    /** Updates patron details. */
    public void updatePatron(String id, String newName, String newContact) {
        Patron patron = patrons.get(id);
        if (patron == null) {
            logger.warning("Cannot update. Patron not found: " + id);
            return;
        }
        patron.setName(newName);
        patron.setContactInfo(newContact);
        logger.info("Patron updated: " + patron);
    }

    // -------------------- LENDING PROCESS --------------------

    /** Handles book checkout (borrow). */
    public boolean checkoutBook(String patronId, String isbn) {
        Patron patron = patrons.get(patronId);
        Book book = books.get(isbn);

        if (patron == null) {
            logger.warning("Checkout failed. Patron not found: " + patronId);
            return false;
        }
        if (book == null) {
            logger.warning("Checkout failed. Book not found: " + isbn);
            return false;
        }
        if (!book.isAvailable()) {
            logger.warning("Checkout failed. Book is already borrowed: " + book.getTitle());
            return false;
        }

        book.borrowBook();
        Transaction transaction = new Transaction(patronId, isbn, TransactionType.BORROW);
        patron.addTransaction(transaction);
        logger.info("Book checked out: " + book.getTitle() + " by " + patron.getName());
        return true;
    }

    /** Handles book return. */
    public boolean returnBook(String patronId, String isbn) {
        Patron patron = patrons.get(patronId);
        Book book = books.get(isbn);

        if (patron == null) {
            logger.warning("Return failed. Patron not found: " + patronId);
            return false;
        }
        if (book == null) {
            logger.warning("Return failed. Book not found: " + isbn);
            return false;
        }

        if (book.isAvailable()) {
            logger.warning("Return failed. Book is already marked as available: " + book.getTitle());
            return false;
        }

        book.setAvailable(true);
        Transaction transaction = new Transaction(patronId, isbn, TransactionType.RETURN);
        patron.addTransaction(transaction);
        logger.info("Book returned: " + book.getTitle() + " by " + patron.getName());
        return true;
    }

    // -------------------- INVENTORY VIEW --------------------

    /** Displays all books. */
    public void showAllBooks() {
        logger.info("Displaying all books in inventory:");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    /** Displays all patrons. */
    public void showAllPatrons() {
        logger.info("Displaying all registered patrons:");
        for (Patron patron : patrons.values()) {
            System.out.println(patron);
        }
    }
}
