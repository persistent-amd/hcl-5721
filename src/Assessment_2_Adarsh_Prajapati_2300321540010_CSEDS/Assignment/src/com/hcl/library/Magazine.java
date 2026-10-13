package com.hcl.library;

public class Magazine extends LibraryItem {
    private int issueNumber;

    // Overloaded constructor 1: Full details
    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        this.issueNumber = issueNumber;
    }

    // Overloaded constructor 2: Default issue number to 1
    public Magazine(String title, int year) {
        this(title, year, 1);
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public double lateFee(int daysLate) {
        if (daysLate <= 0) return 0.0;
        return daysLate * 1.0;
    }

    @Override
    public String toString() {
        return "[Magazine] " + super.toString() + ", Issue No: " + issueNumber;
    }
}
