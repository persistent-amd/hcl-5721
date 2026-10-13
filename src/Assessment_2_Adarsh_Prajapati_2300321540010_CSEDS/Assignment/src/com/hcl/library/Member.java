package com.hcl.library;

import java.util.Objects;

public class Member {
    private int id;
    private String name;

    public Member(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Member ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be blank.");
        }
        this.id = id;
        this.name = name.trim();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be blank.");
        }
        this.name = name.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Member [ID=" + id + ", Name='" + name + "']";
    }
}
