
package exception;

import java.io.FileReader;
import java.io.IOException;

public class CheckedUncheckedExceptionsDemo {

    // Checked exception: must be caught or declared
    static void readFile() throws IOException {
        FileReader file = new FileReader("sample.txt");
        file.close();
    }

    @SuppressWarnings("null")
    public static void main(String[] args) {

        // 1. Checked Exception
        System.out.println("1. Checked Exception");

        try {
            readFile();
            System.out.println("File read successfully.");
        } catch (IOException e) {
            System.out.println("Checked exception: " + e.getMessage());
        }

        // 2. Unchecked Exception
        System.out.println("\n2. Unchecked Exception");

        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Unchecked exception: " + e);
        }

        // 3. Another Unchecked Exception
        System.out.println("\n3. NullPointerException");

        try {
            String name = null;
            System.out.println(name.length());
        } catch (NullPointerException e) {
            System.out.println("Cannot access a method on a null reference.");
        }

        System.out.println("\nProgram completed.");
    }
}
