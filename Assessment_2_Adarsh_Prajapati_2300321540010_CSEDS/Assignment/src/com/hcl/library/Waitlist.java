package com.hcl.library;

import java.util.*;

public class Waitlist {
    // Map of Item ID -> Queue of Members waiting for that item
    private Map<Integer, Queue<Member>> itemWaitlist;

    public Waitlist() {
        this.itemWaitlist = new HashMap<>();
    }

    // Add a member to the waitlist for a specific item
    public void addToWaitlist(int itemId, Member member) {
        if (!itemWaitlist.containsKey(itemId)) {
            itemWaitlist.put(itemId, new LinkedList<>());
        }
        Queue<Member> queue = itemWaitlist.get(itemId);
        if (!queue.contains(member)) {
            queue.offer(member);
        }
    }

    // Poll the next waiting member when an item is returned
    public Member getNextMember(int itemId) {
        Queue<Member> queue = itemWaitlist.get(itemId);
        if (queue == null || queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    // Check if there is someone waiting for the item
    public boolean hasWaitingMembers(int itemId) {
        Queue<Member> queue = itemWaitlist.get(itemId);
        return queue != null && !queue.isEmpty();
    }

    // Remove a member from the waitlist safely using Iterator to avoid ConcurrentModificationException
    public boolean removeWaitlistMember(int itemId, int memberId) {
        Queue<Member> queue = itemWaitlist.get(itemId);
        if (queue == null || queue.isEmpty()) {
            return false;
        }

        Iterator<Member> iterator = queue.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getId() == memberId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public Map<Integer, Queue<Member>> getAllWaitlists() {
        return Collections.unmodifiableMap(itemWaitlist);
    }
}
