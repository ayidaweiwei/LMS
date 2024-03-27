package com.library.management.bo;

import java.util.Objects;

/**
 * @author zhuangweiwei
 * @version 1.0
 */
public class Book {
    private final String title;
    private final String author;
    private int inventory;

    public Book(String title, String author, int inventory) {
        this.title = title;
        this.author = author;
        this.inventory = inventory;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    // Utility methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}

