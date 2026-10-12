
package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

// Separate model class with a unique name to avoid conflicts
class ComparatorStudent {
    private String name;
    private int roll;
    private int age;

    public ComparatorStudent(String name, int roll, int age) {
        this.name = name;
        this.roll = roll;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Roll: " + roll +
                ", Age: " + age;
    }
}

// Custom Comparator class: sort by age ascending
class ComparatorStudentAgeComparator
        implements Comparator<ComparatorStudent> {

    @Override
    public int compare(ComparatorStudent s1, ComparatorStudent s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}

public class CustomComparatorSortingDemo {

    public static void main(String[] args) {
        ArrayList<ComparatorStudent> students = new ArrayList<>();

        students.add(new ComparatorStudent("Rahul", 101, 22));
        students.add(new ComparatorStudent("Priya", 102, 20));
        students.add(new ComparatorStudent("Aman", 103, 21));

        // 1. Sort using the custom Comparator class
        Collections.sort(students, new ComparatorStudentAgeComparator());

        System.out.println("Sorted by age using custom Comparator:");
        students.forEach(System.out::println);

        // 2. Sort by name using a lambda
        students.sort((s1, s2) ->
                s1.getName().compareTo(s2.getName()));

        System.out.println("\nSorted by name using lambda:");
        students.forEach(System.out::println);

        // 3. Sort by age descending using a lambda
        students.sort((s1, s2) ->
                Integer.compare(s2.getAge(), s1.getAge()));

        System.out.println("\nSorted by age descending using lambda:");
        students.forEach(System.out::println);
    }
}
