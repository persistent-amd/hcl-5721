package Task1;

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
    private String name;
    private int roll;
    private int age;

    public Student(String name, int roll, int age) {
        this.name = name;
        this.roll = roll;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }

    public void display() {
        System.out.println(
                "Name: " + name +
                        ", Roll: " + roll +
                        ", Age: " + age
        );
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', roll=" + roll +
                ", age=" + age + "}";
    }
}

public class StudentComparableSortingDemo {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // 1. Add students
        students.add(new Student("Rahul", 101, 22));
        students.add(new Student("Priya", 102, 20));
        students.add(new Student("Aman", 103, 21));
        students.add(new Student("Neha", 104, 19));

        System.out.println("Original List:");
        students.forEach(System.out::println);

        // 2. Add a student at a specific index
        students.add(1, new Student("Rohit", 105, 23));

        // 3. Display the number of students
        System.out.println("\nTotal Students: " + students.size());

        // 4. Access a student by index
        System.out.println("\nStudent at index 0: " + students.get(0));

        // 5. Sort by natural ordering (age ascending)
        Collections.sort(students);

        System.out.println("\nStudents Sorted by Age (Ascending):");
        students.forEach(System.out::println);

        // 6. Reverse the list (age descending after sorting)
        Collections.reverse(students);

        System.out.println("\nStudents Sorted by Age (Descending):");
        students.forEach(System.out::println);

        // 7. Check whether the list is empty
        System.out.println("\nIs list empty? " + students.isEmpty());

        // 8. Remove a student by index
        students.remove(0);

        System.out.println("\nAfter Removing First Student:");
        students.forEach(System.out::println);

        // 9. Clear the list
        students.clear();

        System.out.println("\nIs list empty after clear? " + students.isEmpty());
    }
}