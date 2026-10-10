import java.util.PriorityQueue;
import java.util.Collections;

public class PriorityQueueOperations {
    public static void main(String[] args) {

        // 1. Create a min-heap PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 2. add() / offer() - Insert elements
        pq.offer(30);
        pq.offer(10);
        pq.offer(40);
        pq.offer(20);
        System.out.println("PriorityQueue: " + pq);

        // 3. peek() - View highest-priority element
        System.out.println("Peek: " + pq.peek());

        // 4. poll() - Remove highest-priority element
        System.out.println("Removed: " + pq.poll());
        System.out.println("After poll: " + pq);

        // 5. contains() - Check element
        System.out.println("Contains 30? " + pq.contains(30));

        // 6. size() and isEmpty()
        System.out.println("Size: " + pq.size());
        System.out.println("Is empty? " + pq.isEmpty());

        // 7. Iterate (not guaranteed sorted)
        System.out.println("Elements:");
        for (Integer n : pq) {
            System.out.println(n);
        }

        // 8. Remove a specific element
        pq.remove(30);
        System.out.println("After removing 30: " + pq);

        // 9. Clear all elements
        pq.clear();
        System.out.println("After clear: " + pq);

        // 10. Max-heap (largest element has highest priority)
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(10);
        maxHeap.offer(30);
        maxHeap.offer(20);

        System.out.println("Max-heap top: " + maxHeap.peek()); // 30
    }
}