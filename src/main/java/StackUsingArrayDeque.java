import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingArrayDeque {
    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();

        // 1. push() - Add to top
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);

        // 2. peek() - View top element
        System.out.println("Top: " + stack.peek());

        // 3. pop() - Remove top element
        System.out.println("Popped: " + stack.pop());
        System.out.println("After pop: " + stack);

        // 4. Check element and size
        System.out.println("Contains 10? " + stack.contains(10));
        System.out.println("Size: " + stack.size());
        System.out.println("Is empty? " + stack.isEmpty());

        // 5. Iterate
        stack.forEach(System.out::println);

        // 6. Clear
        stack.clear();
        System.out.println("After clear: " + stack);
    }
}