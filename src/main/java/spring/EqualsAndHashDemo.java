package spring;

import java.util.Objects;

public class EqualsAndHashDemo {

    static class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User u)) return false;
            return id == u.id && Objects.equals(name, u.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static void main(String[] args) {
        User u1 = new User(101, "Alice");
        User u2 = new User(101, "Alice");
        User u3 = new User(102, "Bob");

        // Reference (==) vs Logical Equality (equals)
        System.out.println("u1 == u2      : " + (u1 == u2));        // false (different references)
        System.out.println("u1.equals(u2) : " + u1.equals(u2));     // true  (same values)
        System.out.println("u1.equals(u3) : " + u1.equals(u3));     // false

        // Hash Code Comparison
        System.out.println("u1.hashCode() : " + u1.hashCode());
        System.out.println("u2.hashCode() : " + u2.hashCode());
        System.out.println("Hash Match?   : " + (u1.hashCode() == u2.hashCode())); // true

        // System identity hash codes (based on memory address, ignores overridden hashCode)
        System.out.println("Identity Hash u1 == u2 : " + 
            (System.identityHashCode(u1) == System.identityHashCode(u2))); // false
    }
}
