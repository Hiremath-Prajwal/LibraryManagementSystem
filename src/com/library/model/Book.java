package com.library.model;

public class Book {

   
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;

    
    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true; 
    }

   
    public String getIsbn() {
        return isbn;
    }



    public String getTitle() {
        return title;
    }



    public String getAuthor() {
        return author;
    }



    public int getPublicationYear() {
        return publicationYear;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    //--- Utility Methods ---


    public void borrowBook() {
        if (available) {
            available = false;
        } else {
            System.out.println("Book \"" + title + "\" is already borrowed.");
        }
    }

    void returnBook() {
        if (!available) {
            available = true;
        } else {
            System.out.println("Book \"" + title + "\" is already available.");
        }
    }


    @Override
    public String toString() {
        return String.format(
            "Book[ISBN=%s, Title=%s, Author=%s, Year=%d, Available=%s]",
            isbn, title, author, publicationYear, available ? "Yes" : "No"
        );
    }
}
