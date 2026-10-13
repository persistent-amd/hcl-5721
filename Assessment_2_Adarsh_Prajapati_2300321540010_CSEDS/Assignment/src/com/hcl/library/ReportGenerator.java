package com.hcl.library;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReportGenerator {

    // Exports library status to a text file using try-with-resources
    public static void exportReport(String filePath, List<LibraryItem> items, List<Member> members) throws LibraryException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("==================================================");
            writer.println("            LIBRARY STATUS REPORT                 ");
            writer.println("==================================================");
            writer.println();
            writer.println("--- REGISTERED MEMBERS (" + (members != null ? members.size() : 0) + ") ---");
            if (members != null && !members.isEmpty()) {
                for (Member m : members) {
                    writer.println(m);
                }
            } else {
                writer.println("No members registered.");
            }

            writer.println();
            writer.println("--- LIBRARY ITEMS (" + (items != null ? items.size() : 0) + ") ---");
            if (items != null && !items.isEmpty()) {
                for (LibraryItem item : items) {
                    writer.println(item + " | Status: " + (item.isAvailable() ? "AVAILABLE" : "BORROWED"));
                }
            } else {
                writer.println("No items in library.");
            }
            writer.println();
            writer.println("================== END OF REPORT =================");
        } catch (IOException e) {
            throw new LibraryException("Failed to export library report to file: " + filePath, e);
        }
    }
}
