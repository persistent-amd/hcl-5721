package lambdas;

import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.Consumer;

public class FunctionalInterfacesLambdaDemo {

    public static void main(String[] args) {

        // 1. Predicate<T> - takes input, returns boolean
        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println("Is 10 even? " + isEven.test(10));
        System.out.println("Is 7 even? " + isEven.test(7));


        // 2. BiFunction<T, U, R> - takes two inputs, returns a result
        BiFunction<Integer, Integer, Integer> add =
                (a, b) -> a + b;

        System.out.println("Addition: " + add.apply(10, 20));


        // 3. Supplier<T> - takes no input, supplies a value
        Supplier<String> message =
                () -> "Hello from Supplier!";

        System.out.println(message.get());


        // 4. Consumer<T> - takes input, returns no result
        Consumer<String> printer =
                text -> System.out.println("Message: " + text);

        printer.accept("Hello from Consumer!");
    }
}