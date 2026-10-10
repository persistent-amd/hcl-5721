package Task1;

import java.util.ArrayList;
import java.util.Comparator;

class Student {
    String name;
    int roll;
    int age;

    Student(String name, int roll, int age) {
        this.name = name;
        this.roll = roll;
        this.age = age;
    }

    void display() {
        System.out.println(name + " " + roll + " " + age);
    }
}

public class StudentOperationsArrayList {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Rahul", 101, 22));
        students.add(new Student("Priya", 102, 20));
        students.add(new Student("Aman", 103, 21));

        // Sort students by age in ascending order
        students.sort(Comparator.comparingInt(s -> s.age));

        // Print students
        for (Student s : students) {
            s.display();
        }
        System.out.println(students);
    }
}