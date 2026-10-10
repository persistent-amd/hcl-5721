import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperations {
    public static void main(String[] args) {

        // 1. Create an ArrayList using Generics
        ArrayList<Integer> numbers = new ArrayList<>();

        // 2. Add elements
        for (int i = 1; i <= 10; i++) {
            numbers.add(i * 10);
        }
        System.out.println("Original: " + numbers);

        // 3. Add an element at a specific index
        numbers.add(2, 25);
        System.out.println("After add: " + numbers);

        // 4. Update elements
        numbers.set(0, 100);
        numbers.set(3, 200);
        System.out.println("After update: " + numbers);

        // 5. Access an element
        System.out.println("Element at index 2: " + numbers.get(2));

        // 6. Remove by index
        numbers.remove(1);
        System.out.println("After remove: " + numbers);

        // 7. Check if an element exists
        System.out.println("Contains 100? " + numbers.contains(100));

        // 8. Find index of an element
        System.out.println("Index of 200: " + numbers.indexOf(200));

        // 9. Get size and check if empty
        System.out.println("Size: " + numbers.size());
        System.out.println("Is empty? " + numbers.isEmpty());

        // 10. Iterate using enhanced for loop
        System.out.print("Elements: ");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

//        // 11. Sort in ascending order
//        Collections.sort(numbers);
//        System.out.println("Sorted: " + numbers);
//
//        // 12. Reverse the list
//        Collections.reverse(numbers);
//        System.out.println("Reversed: " + numbers);

        // 13. Remove by value
        numbers.remove(Integer.valueOf(100));
        System.out.println("After removing value 100: " + numbers);

        // 14. Clear all elements
         numbers.clear();
         System.out.println("After clear: " + numbers);
    }
}