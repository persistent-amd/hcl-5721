package com.hcl.library;

public class LateFeeCalculator {
    public static double calculate(LibraryItem item, int daysLate) {
        if (item == null || daysLate <= 0) {
            return 0.0;
        }
        return item.lateFee(daysLate);
    }
}
