# 📚 Library Management System (Java OOP Project)

This **Library Management System** is a Java-based application designed to demonstrate key **Object-Oriented Programming (OOP)** principles such as **encapsulation, abstraction, inheritance, and polymorphism**.  
It provides functionalities for managing books, patrons, and lending operations, following **SOLID principles** and using **Java Logging API** for tracking events.

---

## 🚀 Features 🚀##


✅ **Book Management**
- Add, remove, update, and search books by title, author, or ISBN.  
- Each book maintains details such as title, author, year, and availability.

✅ **Patron Management**
- Register patrons with ID, name, and contact information.  
- View or update patron information and their borrowing history.

✅ **Lending Operations**
- Borrow and return books with transaction logging.  
- Prevents borrowing of unavailable books and handles invalid cases gracefully.

✅ **Transaction Tracking**
- Automatically records each borrow/return event with timestamp.  
- Maintains per-patron transaction history.

✅ **Centralized Logging**
- Uses a custom `LibraryLogger` utility for unified logging (console + file).  
- Logs saved in `library.log` file for auditing and debugging.

---

## 🏗️ Class Overview

|----- Class--------|          | -------Description--------- |


| **Book** | Represents a library book with details like ISBN, title, author, year, and availability status. |

| **Patron** | Represents a library member. Stores name, contact, and borrowing history. |

| **Transaction** | Records each borrow/return operation with timestamp and type. |

| **TransactionType (Enum)** | Defines transaction types: `BORROW`, `RETURN`. |

| **Library** | Central class that manages books, patrons, and transactions. |

| **LibraryLogger** | Utility class for global logging configuration. |

| **LibraryApp** | Driver class that demonstrates all functionalities. |

---

## 🧩 UML Diagram

The project follows the below UML structure:

![UML Diagram](images/library_uml.png)

---



