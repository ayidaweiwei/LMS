package com.library.management.service;


import com.library.management.bo.Admin;
import com.library.management.bo.Book;
import com.library.management.bo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuangweiwei
 * @version 1.0
 */
public class LibrarySystem {
    private final Map<String, User> users;
    private final Map<String, Admin> admins;
    private final Map<Book, Integer> books;
    private User currentUser;

    public LibrarySystem() {
        this.users = new HashMap<>();
        this.admins = new HashMap<>();
        this.books = new HashMap<>();
    }

    public String register(String userType, String username, String password) {
        if (userType.equalsIgnoreCase("user")) {
            if (!users.containsKey(username)) {
                users.put(username, new User(username, password));
                return "User " + username + " successfully registered.";
            }
        } else if (userType.equalsIgnoreCase("admin")) {
            if (!admins.containsKey(username)) {
                admins.put(username, new Admin(username, password));
                return "Admin " + username + " successfully registered.";
            }
        }
        return "Registration failed. User/Admin already exists.";
    }

    public String login(String username, String password) {
        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            currentUser = users.get(username);
            return "User " + username + " successfully logged in.";
        } else if (admins.containsKey(username) && admins.get(username).getPassword().equals(password)) {
            currentUser = admins.get(username);
            return "Admin " + username + " successfully logged in.";
        }
        return "Login failed. Incorrect username or password.";
    }

    public String addBook(String title, String author, int inventory) {
        if (currentUser instanceof Admin) {
            Book newBook = new Book(title, author, inventory);
            books.merge(newBook, inventory, Integer::sum);
            return String.format("Book \"%s\" by %s added successfully, inventory: %d.", title, author, books.get(newBook));
        }
        return "Failed to add book. Only admins are allowed to add books.";
    }

    public String listBooks() {
        StringBuilder sb = new StringBuilder("Book List:\n");
        books.forEach((book, quantity) -> sb.append(book.getTitle()).append(" - ").append(book.getAuthor()).append(" - Inventory: ").append(quantity).append("\n"));
        return sb.toString();
    }

    public String borrowBook(String title, String author) {
        for (Book book : books.keySet()) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && books.get(book) > 0) {
                currentUser.borrowBook(book);
                books.put(book, books.get(book) - 1);
                return "Book \"" + title + "\" successfully borrowed.";
            }
        }
        return "Borrowing failed. Book is not available.";
    }

    public String returnBook(String title, String author) {
        for (Book book : currentUser.getBorrowedBooks()) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                currentUser.returnBook(book);
                books.put(book, books.get(book) + 1);
                return "Book \"" + title + "\" successfully returned.";
            }
        }
        return "Returning failed. Book not borrowed by user.";
    }

    public String deleteBook(String title, String author) {
        if (currentUser instanceof Admin) {
            for (Book book : books.keySet()) {
                if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                    if (books.get(book) > 0) {
                        books.remove(book);
                        return "Book \"" + title + "\" successfully deleted.";
                    } else {
                        return "Cannot delete book \"" + title + "\" because it is currently borrowed.";
                    }
                }
            }
            return "Book not found.";
        }
        return "Failed to delete book. Only admins are allowed to delete books.";
    }
}

