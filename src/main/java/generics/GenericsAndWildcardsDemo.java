
package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1. Generic class
class GenericBox<T> {
    private T value;

    public GenericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void display() {
        System.out.println("Value: " + value);
    }
}

// 2. Generic method
class GenericUtility {
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // 3. Upper-bounded wildcard: accepts Number or its subclasses
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0;

        for (Number number : numbers) {
            sum += number.doubleValue();
        }

        return sum;
    }

    // 4. Lower-bounded wildcard: accepts Integer or its supertypes
    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
    }

    // 5. Unbounded wildcard: accepts a list of any element type
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

public class GenericsAndWildcardsDemo {
    public static void main(String[] args) {

        // Generic class
        GenericBox<String> stringBox = new GenericBox<>("Hello Java");
        GenericBox<Integer> integerBox = new GenericBox<>(100);

        stringBox.display();
        integerBox.display();

        // Generic method
        Integer[] numbers = {10, 20, 30};
        String[] names = {"Rahul", "Priya", "Aman"};

        System.out.print("Integer array: ");
        GenericUtility.printArray(numbers);

        System.out.print("String array: ");
        GenericUtility.printArray(names);

        // Upper-bounded wildcard
        List<Integer> integers = Arrays.asList(10, 20, 30);
        List<Double> decimals = Arrays.asList(1.5, 2.5, 3.5);

        System.out.println("Integer sum: " +
                GenericUtility.sumNumbers(integers));

        System.out.println("Double sum: " +
                GenericUtility.sumNumbers(decimals));

        // Lower-bounded wildcard
        List<Number> numberList = new ArrayList<>();
        GenericUtility.addIntegers(numberList);

        System.out.println("Added integers: " + numberList);

        // Unbounded wildcard
        System.out.print("Print any list: ");
        GenericUtility.printList(List.of(names));
    }
}
