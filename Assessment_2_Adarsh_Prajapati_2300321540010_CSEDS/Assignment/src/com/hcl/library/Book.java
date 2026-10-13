package com.hcl.library;

public class Book extends LibraryItem {
    private String author;
    private String isbn;

    // Overloaded constructor 1: Full details
    public Book(String title, int year, String author, String isbn) {
        super(title, year);
        if (author == null || author.trim().isEmpty()) {
            this.author = "Unknown Author";
        } else {
            this.author = author.trim();
        }
        this.isbn = (isbn != null) ? isbn.trim() : "";
    }

    // Overloaded constructor 2: Defaults author to "Unknown Author" and empty isbn
    public Book(String title, int year) {
        this(title, year, "Unknown Author", "");
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public double lateFee(int daysLate) {
        if (daysLate <= 0) return 0.0;
        return daysLate * 2.0;
    }

    @Override
    public String toString() {
        return "[Book] " + super.toString() + ", Author: '" + author + "', ISBN: '" + isbn + "'";
    }
}
