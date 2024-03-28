package com.library.management.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuangweiwei
 * @version 1.0
 */
public class User {
    private final String username;
    private final String password;
    private final List<Book> borrowedBooks; // List to keep track of borrowed books

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getter for password to validate login in LibrarySystem
    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return username;
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Method to return a book
    public boolean returnBook(Book book) {
        return borrowedBooks.remove(book);
    }

    // Getter for the list of borrowed books for returning books and listing borrowed books
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}




