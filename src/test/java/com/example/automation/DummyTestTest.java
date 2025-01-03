package com.example.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DummyTestTest {

    @Test
    public void testCalculateSum() {
        double[] values = {1.5, 2.0, 3.0, 4.5, 5.5};
        double expectedSum = 16.5; 
        double actualSum = DummyTest.calculateSum(values);
        assertEquals(expectedSum, actualSum, 0.01, "The calculated sum should be 16.5");
    }

    @Test
    public void testFactorial() {
        int num = 5;
        int expectedFactorial = 120; 
        int actualFactorial = DummyTest.factorial(num);
        assertEquals(expectedFactorial, actualFactorial, "Factorial calculation failed");
    }

    @Test
    public void testPrintEvenNumbers() {
        int limit = 10;
        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("Even numbers up to ").append(limit).append(":\n");
        for (int i = 0; i <= limit; i++) {
            if (i % 2 == 0) {
                expectedOutput.append(i).append("\n");
            }
        }

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DummyTest.printEvenNumbers(limit);

        System.setOut(originalOut);

        assertEquals(expectedOutput.toString().trim(), outContent.toString().trim(), "Even numbers output mismatch");
    }

    @Test
    public void testPrintArray() {
        double[] array = {1.5, 2.5, 3.5};
        StringBuilder expectedOutput = new StringBuilder("Array values:\n");
        for (double value : array) {
            expectedOutput.append(value).append("\n");
        }

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DummyTest.printArray(array);

        System.setOut(originalOut);

        assertEquals(expectedOutput.toString().trim(), outContent.toString().trim(), "Array print output mismatch");
    }
}
