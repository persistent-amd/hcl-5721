import java.util.LinkedList;
import java.util.Queue;

public class QueueOperations {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        // 1. offer() - Add elements at the rear
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("Queue: " + queue);

        // 2. peek() - View front element
        System.out.println("Front: " + queue.peek());

        // 3. poll() - Remove and return front element
        System.out.println("Removed: " + queue.poll());
        System.out.println("After removal: " + queue);

        // 4. add() - Add an element
        queue.add(40);
        System.out.println("After adding: " + queue);

        // 5. element() - View front (throws exception if empty)
        System.out.println("Front: " + queue.element());

        // 6. contains() - Check if element exists
        System.out.println("Contains 30? " + queue.contains(30));

        // 7. size() - Number of elements
        System.out.println("Size: " + queue.size());

        // 8. isEmpty() - Check if queue is empty
        System.out.println("Is empty? " + queue.isEmpty());

        // 9. Iterate through queue
        for (Integer value : queue) {
            System.out.println(value);
        }

        // 10. clear() - Remove all elements
        queue.clear();
        System.out.println("After clear: " + queue);
    }
}