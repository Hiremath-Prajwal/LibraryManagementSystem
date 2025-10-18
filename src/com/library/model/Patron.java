package com.library.model;

import java.util.ArrayList;
import java.util.List;


public class Patron {

   
    private final String patronId;        
    private String name;
    private String contactInfo;
    private List<Transaction> borrowingHistory;

    
    public Patron(String patronId, String name, String contactInfo) {
        this.patronId = patronId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowingHistory = new ArrayList<>();
    }

    
    public String getPatronId() {
        return patronId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Transaction> getBorrowingHistory() {
        return borrowingHistory;
    }


    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            borrowingHistory.add(transaction);
        }
    }


    public void showBorrowingHistory() {
        if (borrowingHistory.isEmpty()) {
            System.out.println(name + " has no borrowing history.");
            return;
        }

        System.out.println("Borrowing history for " + name + ":");
        for (Transaction t : borrowingHistory) {
            System.out.println("  - " + t);
        }
    }

 
    @Override
    public String toString() {
        return String.format("Patron[ID=%s, Name=%s, Contact=%s, Transactions=%d]",
                patronId, name, contactInfo, borrowingHistory.size());
    }
}
