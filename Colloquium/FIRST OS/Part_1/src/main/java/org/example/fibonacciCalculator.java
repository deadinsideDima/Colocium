package org.example;

import java.math.BigInteger;
import java.util.ArrayList;

public class fibonacciCalculator {
    public static ArrayList<BigInteger> getRowOfFibonacci(int n) throws Exception {

        if (n < 0) {
            throw new Exception("Count of fibonacci row must be non-negative");
        }

        ArrayList<BigInteger> fibonacciNumbers = new ArrayList<BigInteger>(n);

        for (int i = 0; i < n; ++i) {
            fibonacciNumbers.add(calculateFibonacci(i));
        }

        return fibonacciNumbers;
    }

    public static BigInteger calculateFibonacci(int number) throws Exception {

        if (number < 0) {
            throw new Exception("Number must be non-negative");
        }
        if (number == 0 || number == 1) {
            return BigInteger.valueOf(number);
        }
        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;
        for (int i = 1; i < number; ++i) {
            BigInteger temp = second;
            second = second.add(first);
            first = temp;
        }
        return second;
    }
}