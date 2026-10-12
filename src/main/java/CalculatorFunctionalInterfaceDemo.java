
@FunctionalInterface
interface Calculator {
    double calculate(double a, double b);
}

public class CalculatorFunctionalInterfaceDemo {
    public static void main(String[] args) {

        // Addition
        Calculator add = (a, b) -> a + b;

        // Subtraction
        Calculator subtract = (a, b) -> a - b;

        // Multiplication
        Calculator multiply = (a, b) -> a * b;

        // Division
        Calculator divide = (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        };

        // Modulus
        Calculator modulus = (a, b) -> a % b;

        double x = 20;
        double y = 6;

        System.out.println("Addition: " + add.calculate(x, y));
        System.out.println("Subtraction: " + subtract.calculate(x, y));
        System.out.println("Multiplication: " + multiply.calculate(x, y));
        System.out.println("Division: " + divide.calculate(x, y));
        System.out.println("Modulus: " + modulus.calculate(x, y));
    }
}
