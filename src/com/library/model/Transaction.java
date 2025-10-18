package com.library.model;

import java.time.LocalDateTime;


public class Transaction {

   
    private final String patronId;           // ID of the patron
    private final String isbn;               // ISBN of the book
    private final TransactionType type;      // BORROW or RETURN
    private final LocalDateTime timestamp;   // When the transaction happened

   
    public Transaction(String patronId, String isbn, TransactionType type) {
        this.patronId = patronId;
        this.isbn = isbn;
        this.type = type;
        this.timestamp = LocalDateTime.now(); // Automatically records the time
    }

   
    public String getPatronId() {
        return patronId;
    }

    public String getIsbn() {
        return isbn;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    
    @Override
    public String toString() {
        return String.format(
            "[%s] PatronID: %s | ISBN: %s | Time: %s",
            type, patronId, isbn, timestamp
        );
    }
}
