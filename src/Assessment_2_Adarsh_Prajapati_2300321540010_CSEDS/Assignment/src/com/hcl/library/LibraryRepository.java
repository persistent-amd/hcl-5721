package com.hcl.library;

import java.util.*;

public class LibraryRepository {
    private List<LibraryItem> items;
    private List<Member> members;
    private Set<String> registeredIsbns;
    // Track active borrows: Item ID -> Member ID
    private Map<Integer, Integer> borrowedItemMembers;

    public LibraryRepository() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.registeredIsbns = new HashSet<>();
        this.borrowedItemMembers = new HashMap<>();
    }

    public void addItem(LibraryItem item) throws LibraryException {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        if (item instanceof Book) {
            Book book = (Book) item;
            String isbn = book.getIsbn();
            if (isbn != null && !isbn.isEmpty()) {
                if (registeredIsbns.contains(isbn)) {
                    throw new LibraryException("Duplicate ISBN detected: " + isbn + ". Book cannot be added.");
                }
                registeredIsbns.add(isbn);
            }
        }
        items.add(item);
    }

    public void addMember(Member member) throws LibraryException {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }
        if (findMemberById(member.getId()) != null) {
            throw new LibraryException("Member with ID " + member.getId() + " already exists.");
        }
        members.add(member);
    }

    public LibraryItem findItemById(int id) {
        for (LibraryItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public List<Member> getMembers() {
        return members;
    }

    public Map<Integer, Integer> getBorrowedItemMembers() {
        return borrowedItemMembers;
    }
}
