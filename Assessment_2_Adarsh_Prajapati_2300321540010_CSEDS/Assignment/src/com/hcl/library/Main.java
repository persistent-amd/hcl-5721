package com.hcl.library;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryRepository repository = new LibraryRepository();
        Waitlist waitlist = new Waitlist();
        LibraryService service = new LibraryService(repository, waitlist);
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("   Welcome to Library Management System (HCLTech) ");
        System.out.println("==================================================");

        boolean running = true;
        while (running) {
            try {
                printMenu();
                System.out.print("Choice: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    continue;
                }

                int choice;
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("[Error] Please enter a valid number from 1 to 9.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        handleAddItem(scanner, service);
                        break;
                    case 2:
                        handleRegisterMember(scanner, service);
                        break;
                    case 3:
                        handleBorrow(scanner, service);
                        break;
                    case 4:
                        handleReturn(scanner, service);
                        break;
                    case 5:
                        handleExportReport(scanner, service);
                        break;
                    case 6:
                        handleSearch(scanner, service);
                        break;
                    case 7:
                        handleCalculateLateFee(scanner, service);
                        break;
                    case 8:
                        handlePolymorphismDemo(service);
                        break;
                    case 9:
                        System.out.println("Thank you for using the Library Management System. Exiting...");
                        running = false;
                        break;
                    default:
                        System.out.println("[Error] Invalid choice. Please choose between 1 and 9.");
                }
            } catch (LibraryException e) {
                System.out.println("[Library Error] " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("[Validation Error] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[Unexpected Error] " + e.getMessage());
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. Add Item");
        System.out.println("2. Register Member");
        System.out.println("3. Borrow");
        System.out.println("4. Return");
        System.out.println("5. Export Report");
        System.out.println("6. Search");
        System.out.println("7. Calculate Late Fee");
        System.out.println("8. Demonstrate Polymorphism & Sorting");
        System.out.println("9. Exit");
    }

    private static void handleAddItem(Scanner scanner, LibraryService service) throws LibraryException {
        System.out.print("Enter type (Book/Magazine/DVD): ");
        String type = scanner.nextLine().trim();

        System.out.print("Title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine().trim());

        if (type.equalsIgnoreCase("Book")) {
            System.out.print("Author: ");
            String author = scanner.nextLine().trim();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine().trim();
            service.addBook(title, year, author, isbn);
            System.out.println("Book added successfully.");
        } else if (type.equalsIgnoreCase("Magazine")) {
            System.out.print("Issue Number: ");
            int issueNumber = Integer.parseInt(scanner.nextLine().trim());
            service.addMagazine(title, year, issueNumber);
            System.out.println("Magazine added successfully.");
        } else if (type.equalsIgnoreCase("DVD")) {
            System.out.print("Duration (in minutes): ");
            int duration = Integer.parseInt(scanner.nextLine().trim());
            service.addDVD(title, year, duration);
            System.out.println("DVD added successfully.");
        } else {
            System.out.println("[Error] Unknown item type: " + type + ". Must be Book, Magazine, or DVD.");
        }
    }

    private static void handleRegisterMember(Scanner scanner, LibraryService service) throws LibraryException {
        System.out.print("Member ID: ");
        int memberId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        service.registerMember(memberId, name);
        System.out.println("Member registered successfully.");
    }

    private static void handleBorrow(Scanner scanner, LibraryService service) throws LibraryException {
        System.out.print("Item ID: ");
        int itemId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Member ID: ");
        int memberId = Integer.parseInt(scanner.nextLine().trim());
        service.borrowItem(itemId, memberId);
        System.out.println("Item ID " + itemId + " borrowed successfully by Member " + memberId + ".");
    }

    private static void handleReturn(Scanner scanner, LibraryService service) throws LibraryException {
        System.out.print("Item ID: ");
        int itemId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Member ID: ");
        int memberId = Integer.parseInt(scanner.nextLine().trim());
        Member nextWaiting = service.returnItem(itemId, memberId);
        System.out.println("Item ID " + itemId + " returned successfully.");
        if (nextWaiting != null) {
            System.out.println("[Waitlist Notification] Member " + nextWaiting.getName() + " (ID: " + nextWaiting.getId() + ") is next in queue for Item ID " + itemId + "!");
        }
    }

    private static void handleExportReport(Scanner scanner, LibraryService service) throws LibraryException {
        System.out.print("Enter report file name (or press Enter for default 'library_report.txt'): ");
        String fileName = scanner.nextLine().trim();
        if (fileName.isEmpty()) {
            fileName = "library_report.txt";
        }
        service.exportReport(fileName);
        System.out.println("Export report completed successfully: " + fileName);
    }

    private static void handleSearch(Scanner scanner, LibraryService service) {
        System.out.println("Search Options:");
        System.out.println("1. Search by Title");
        System.out.println("2. Search by Author (Books only)");
        System.out.print("Choice: ");
        String searchChoice = scanner.nextLine().trim();

        if (searchChoice.equals("1")) {
            System.out.print("Enter title keyword: ");
            String title = scanner.nextLine().trim();
            List<LibraryItem> found = service.searchByTitle(title);
            printSearchResults(found);
        } else if (searchChoice.equals("2")) {
            System.out.print("Enter author keyword: ");
            String author = scanner.nextLine().trim();
            List<LibraryItem> found = service.searchByAuthor(author);
            printSearchResults(found);
        } else {
            System.out.println("[Error] Invalid search option.");
        }
    }

    private static void printSearchResults(List<LibraryItem> items) {
        if (items.isEmpty()) {
            System.out.println("No matching items found.");
        } else {
            System.out.println("Found " + items.size() + " item(s):");
            for (LibraryItem item : items) {
                System.out.println(" - " + item);
            }
        }
    }

    private static void handleCalculateLateFee(Scanner scanner, LibraryService service) {
        System.out.print("Item ID: ");
        int itemId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Days Late: ");
        int daysLate = Integer.parseInt(scanner.nextLine().trim());

        LibraryItem item = service.getRepository().findItemById(itemId);
        if (item == null) {
            System.out.println("[Error] Item not found with ID: " + itemId);
            return;
        }

        double fee = LateFeeCalculator.calculate(item, daysLate);
        System.out.println("Late fee for '" + item.getTitle() + "' (" + daysLate + " days late): $" + fee);
    }

    private static void handlePolymorphismDemo(LibraryService service) {
        System.out.println("=== Polymorphism & Sorting Demo ===");
        List<LibraryItem> sorted = service.getAllSortedItems();
        if (sorted.isEmpty()) {
            System.out.println("No items to display. Add some items first.");
            return;
        }

        System.out.println("All items sorted by Title then Year (Demonstrating Polymorphism with lateFee for 5 days late):");
        for (LibraryItem item : sorted) {
            // Polymorphic call to lateFee() without checking concrete type
            double feeFor5Days = item.lateFee(5);
            System.out.println(" * " + item + " -> Late fee for 5 days: $" + feeFor5Days);
        }
    }
}
