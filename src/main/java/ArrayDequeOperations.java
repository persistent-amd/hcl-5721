import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeOperations {
    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        // 1. Add elements at both ends
        deque.addFirst(20);
        deque.addFirst(10);
        deque.addLast(30);
        deque.addLast(40);
        System.out.println("Deque: " + deque);

        // 2. Peek at both ends
        System.out.println("First: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());

        // 3. Remove from both ends
        System.out.println("Removed first: " + deque.pollFirst());
        System.out.println("Removed last: " + deque.pollLast());
        System.out.println("Deque: " + deque);

        // 4. Other common operations
        deque.offerFirst(5);
        deque.offerLast(50);
        System.out.println("After adding: " + deque);

        System.out.println("Contains 20? " + deque.contains(20));
        System.out.println("Size: " + deque.size());
        System.out.println("Is empty? " + deque.isEmpty());

        // 5. Iterate
        deque.forEach(System.out::println);

        // 6. Clear
        deque.clear();
        System.out.println("After clear: " + deque);
    }
}