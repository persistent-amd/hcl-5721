import java.util.LinkedList;
import java.util.Arrays;

public class LinkedListOperations {
    public static void main(String[] args) {

        // 1. Create a LinkedList using Generics
        LinkedList<String> list = new LinkedList<>();

        // 2. add() - Add elements
        list.add("Java");
        list.add("Python");
        list.add("SQL");
        System.out.println("List: " + list);

        // 3. size() - Get number of elements
        System.out.println("Size: " + list.size());

        // 4. contains() - Check if element exists
        System.out.println("Contains Java? " + list.contains("Java"));

        // 5. isEmpty() - Check if list is empty
        System.out.println("Is empty? " + list.isEmpty());

        // Insert in between
        list.add(2
                , "Lua");

        // 6. stream() - Process elements
        list.stream().forEach(System.out::println);

        // 7. equals() - Compare two lists
        LinkedList<String> anotherList =
                new LinkedList<>(Arrays.asList("Java", "Python", "SQL"));

        System.out.println("Lists equal? " + list.equals(anotherList));

        // 8. clear() - Remove all elements
        list.clear();
        System.out.println("After clear: " + list);
        System.out.println("Is empty now? " + list.isEmpty());
    }
}