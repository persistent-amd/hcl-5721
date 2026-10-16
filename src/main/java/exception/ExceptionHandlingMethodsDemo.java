
package exception;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;

// Custom checked exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionHandlingMethodsDemo {

    // Demonstrates throws and a custom exception
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException(
                    "Age must be at least 18.");
        }

        System.out.println("Age validation successful.");
    }

    // Demonstrates throws with a checked exception
    static String readFirstLine() throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new StringReader("Hello from Java"))) {
            return reader.readLine();
        }
    }

    public static void main(String[] args) {

        // 1. Basic try-catch
        System.out.println("1. Basic try-catch");

        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }

        // 2. Multiple catch blocks
        System.out.println("\n2. Multiple catch blocks");

        try {
            int[] numbers = { 10, 20, 30 };
            System.out.println(numbers[5]);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index.");
        } catch (Exception e) {
            System.out.println("Some other exception occurred.");
        }

        // 3. Finally block
        System.out.println("\n3. Finally block");

        try {
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error.");
        } finally {
            System.out.println("Finally block executed.");
        }

        // 4. Nested try-catch
        System.out.println("\n4. Nested try-catch");

        try {
            try {
                @SuppressWarnings("unused")
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch handled division.");
            }

            int[] arr = { 1, 2 };
            System.out.println(arr[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch handled array error.");
        }

        // 5. throw and throws with custom exception
        System.out.println("\n5. Custom exception");

        try {
            validateAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        // 6. Checked exception with throws
        System.out.println("\n6. Checked exception");

        try {
            System.out.println(readFirstLine());
        } catch (IOException e) {
            System.out.println("Reading failed: " + e.getMessage());
        }

        System.out.println("\nProgram completed.");
    }
}
