package org.example;

import java.util.Scanner;

public class Calculator {

    // Addition method
    private double add(double a, double b) {
        return a + b;
    }

    // Subtraction method
    private double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication method
    private double multiply(double a, double b) {
        return a * b;
    }

    // Division method
    private double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        // initialize variable
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double result = 0.0;
        boolean isFirstOperation = true;

        System.out.println("===================== CALCULATOR =====================");

        // While not exiting the calculator
        while (true) {
            try {
                // if first operation or from a clear
                if (isFirstOperation) {
                    System.out.println("Enter number: ");
                    result = scanner.nextDouble();
                    isFirstOperation = false;
                }

                System.out.println("Choose an operation: +, -, *, / (or type 'clear' to reset, 'exit' to quit): ");
                String operation = scanner.next().toLowerCase();

                if (operation.equals("exit")) {
                    break;
                } else if (operation.equals("clear")) {
                    isFirstOperation = true;
                    System.out.println("Cleared.");
                    continue;
                }

                System.out.println("Enter the number: ");
                double nextNumber = scanner.nextDouble();

                switch (operation) {
                    case "+":   // addition
                        result = calculator.add(result, nextNumber);
                        System.out.println("Result: " + result);
                        break;
                    case "-":   // subtraction
                        result = calculator.subtract(result, nextNumber);
                        System.out.println("Result: " + result);
                        break;
                    case "*":   // multiplication
                        result = calculator.multiply(result, nextNumber);
                        System.out.println("Result: " + result);
                        break;
                    case "/":   // division
                        result = calculator.divide(result, nextNumber);
                        System.out.println("Result: " + result);
                        break;
                    default:
                        System.out.println("Invalid operation. Please try again.");
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.next(); // Clear the invalid input
            }
        }

        scanner.close();
        System.out.println("Calculator closed.");
    }
}
