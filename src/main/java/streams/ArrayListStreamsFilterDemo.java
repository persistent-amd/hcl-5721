
package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListStreamsFilterDemo {

        public static void main(String[] args) {

                ArrayList<Integer> numbers = new ArrayList<>();

                numbers.add(10);
                numbers.add(15);
                numbers.add(20);
                numbers.add(25);
                numbers.add(30);
                numbers.add(35);
                numbers.add(40);

                System.out.println("Original List: " + numbers);

                // 1. Filter even numbers
                List<Integer> evenNumbers = numbers.stream()
                                .filter(n -> n % 2 == 0)
                                .collect(Collectors.toList());

                System.out.println("Even Numbers: " + evenNumbers);

                // 2. Filter numbers greater than 20
                List<Integer> greaterThan20 = numbers.stream()
                                .filter(n -> n > 20)
                                .collect(Collectors.toList());

                System.out.println("Numbers > 20: " + greaterThan20);

                // 3. Filter and transform numbers
                List<Integer> doubledEvens = numbers.stream()
                                .filter(n -> n % 2 == 0)
                                .map(n -> n * 2)
                                .collect(Collectors.toList());

                System.out.println("Doubled Even Numbers: " + doubledEvens);

                // 4. Sort filtered numbers in descending order
                List<Integer> descending = numbers.stream()
                                .filter(n -> n >= 20)
                                .sorted((a, b) -> Integer.compare(b, a))
                                .collect(Collectors.toList());

                System.out.println("Filtered and Sorted: " + descending);

                // 5. Count matching elements
                long count = numbers.stream()
                                .filter(n -> n > 20)
                                .count();

                System.out.println("Count of numbers > 20: " + count);

                // 6. Find the first matching element
                numbers.stream()
                                .filter(n -> n % 2 != 0)
                                .findFirst()
                                .ifPresent(n -> System.out.println("First odd number: " + n));

                // 7. Check whether any number is divisible by 7
                boolean hasMultipleOf7 = numbers.stream()
                                .anyMatch(n -> n % 7 == 0);

                System.out.println("Has a multiple of 7: " + hasMultipleOf7);
        }
}
