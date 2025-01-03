package com.example.automation;

public class DummyTest {
 
    public static void main(String[] args) {
        System.out.println("Starting Dummy Test Program...");

        int counter = 0;
        String name = "Test Name";
        double[] values = {1.5, 2.0, 3.0, 4.5, 5.5};

        for (int i = 0; i < 10; i++) {
            counter++;
            System.out.println("Counter: " + counter);
        }

        String greeting = "Hello, " + name;
        System.out.println(greeting);

        double sum = calculateSum(values);
        System.out.println("Sum of values: " + sum);

        if (sum > 15.0) {
            System.out.println("The sum is greater than 15!");
        } else {
            System.out.println("The sum is less than or equal to 15.");
        }

        printEvenNumbers(10);

        int num = 5;
        int factorialResult = factorial(num);
        System.out.println("Factorial of " + num + " is: " + factorialResult);

        printArray(values);

        System.out.println("Dummy Test Program completed.");
    }

    public static double calculateSum(double[] values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum;
    }

    public static void printEvenNumbers(int limit) {
        System.out.println("Even numbers up to " + limit + ":");
        for (int i = 0; i <= limit; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static int factorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void printArray(double[] array) {
        System.out.println("Array values:");
        for (double value : array) {
            System.out.println(value);
        }
    }
}
