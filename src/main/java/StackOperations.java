import java.util.Stack;

public class StackOperations {
    public static void main(String[] args) {

        // 1. Create a Stack using Generics
        Stack<Integer> stack = new Stack<>();

        // 2. push() - Add elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);

        // 3. peek() - View top element
        System.out.println("Top: " + stack.peek());

        // 4. pop() - Remove top element
        System.out.println("Popped: " + stack.pop());
        System.out.println("After pop: " + stack);

        // 5. search() - Find position from top (1-based)
        System.out.println("Position of 10: " + stack.search(10));

        // 6. offset / index-based access
        System.out.println("Element at index 0: " + stack.get(0));

        // 7. size() and empty()
        System.out.println("Size: " + stack.size());
        System.out.println("Is empty? " + stack.empty());

        // 8. contains()
        System.out.println("Contains 20? " + stack.contains(20));

        // 9. Iterate through elements
        for (Integer value : stack) {
            System.out.println(value);
        }

        // 10. Clear all elements
        stack.clear();
        System.out.println("After clear: " + stack);
    }
}