package com.hcl.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private LibraryRepository repository;
    private Waitlist waitlist;

    public LibraryService(LibraryRepository repository, Waitlist waitlist) {
        this.repository = repository;
        this.waitlist = waitlist;
    }

    public void registerMember(int id, String name) throws LibraryException {
        Member member = new Member(id, name);
        repository.addMember(member);
    }

    public void addBook(String title, int year, String author, String isbn) throws LibraryException {
        Book book = new Book(title, year, author, isbn);
        repository.addItem(book);
    }

    public void addMagazine(String title, int year, int issueNumber) throws LibraryException {
        Magazine magazine = new Magazine(title, year, issueNumber);
        repository.addItem(magazine);
    }

    public void addDVD(String title, int year, int durationMinutes) throws LibraryException {
        DVD dvd = new DVD(title, year, durationMinutes);
        repository.addItem(dvd);
    }

    public void borrowItem(int itemId, int memberId) throws LibraryException {
        Member member = repository.findMemberById(memberId);
        if (member == null) {
            throw new InvalidMemberException("Invalid Member ID: " + memberId + ". Member not registered.");
        }

        LibraryItem item = repository.findItemById(itemId);
        if (item == null) {
            throw new LibraryException("Item with ID " + itemId + " not found.");
        }

        if (!item.isAvailable()) {
            // Add member to waitlist automatically when item is not available
            waitlist.addToWaitlist(itemId, member);
            throw new ItemNotAvailableException("Item '" + item.getTitle() + "' (ID: " + itemId + ") is currently unavailable. Member " + member.getName() + " added to waitlist.");
        }

        item.borrow();
        repository.getBorrowedItemMembers().put(itemId, memberId);
    }

    public Member returnItem(int itemId, int memberId) throws LibraryException {
        Member member = repository.findMemberById(memberId);
        if (member == null) {
            throw new InvalidMemberException("Invalid Member ID: " + memberId + ". Member not registered.");
        }

        LibraryItem item = repository.findItemById(itemId);
        if (item == null) {
            throw new LibraryException("Item with ID " + itemId + " not found.");
        }

        Integer borrowerId = repository.getBorrowedItemMembers().get(itemId);
        if (item.isAvailable() || borrowerId == null) {
            throw new InvalidReturnException("Item ID " + itemId + " was not borrowed.");
        }

        if (borrowerId != memberId) {
            throw new InvalidReturnException("Item ID " + itemId + " was borrowed by Member " + borrowerId + ", not Member " + memberId + ".");
        }

        item.returnItem();
        repository.getBorrowedItemMembers().remove(itemId);

        // Check waitlist for waiting members
        Member nextMember = waitlist.getNextMember(itemId);
        return nextMember;
    }

    public List<LibraryItem> searchByTitle(String title) {
        List<LibraryItem> result = new ArrayList<>();
        if (title == null || title.trim().isEmpty()) return result;
        String query = title.trim().toLowerCase();
        for (LibraryItem item : repository.getItems()) {
            if (item.getTitle().toLowerCase().contains(query)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> result = new ArrayList<>();
        if (author == null || author.trim().isEmpty()) return result;
        String query = author.trim().toLowerCase();
        for (LibraryItem item : repository.getItems()) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.getAuthor().toLowerCase().contains(query)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    public List<LibraryItem> getAllSortedItems() {
        List<LibraryItem> sortedList = new ArrayList<>(repository.getItems());
        CollectionUtils.sortByTitleThenYear(sortedList);
        return sortedList;
    }

    public void exportReport(String filePath) throws LibraryException {
        ReportGenerator.exportReport(filePath, repository.getItems(), repository.getMembers());
    }

    public LibraryRepository getRepository() {
        return repository;
    }

    public Waitlist getWaitlist() {
        return waitlist;
    }
}
