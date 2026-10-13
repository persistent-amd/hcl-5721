package com.hcl.library;

public class DVD extends LibraryItem {
    private int durationMinutes;

    public DVD(String title, int year, int durationMinutes) {
        super(title, year);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public double lateFee(int daysLate) {
        if (daysLate <= 0) return 0.0;
        return daysLate * 5.0;
    }

    @Override
    public String toString() {
        return "[DVD] " + super.toString() + ", Duration: " + durationMinutes + " mins";
    }
}
