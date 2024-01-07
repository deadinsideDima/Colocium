package org.example;

import java.math.BigInteger;
import java.util.ArrayList;

public class factorialCalculator {
    public static ArrayList<BigInteger> getRowOfFactorials(int n) throws Exception {

        if (n < 0) {
            throw new Exception("Count of factorials must be non-negative");
        }

        ArrayList<BigInteger> factorials = new ArrayList<BigInteger>(n);
        factorials.add(BigInteger.ONE);

        for (int i = 1; i < n; i++) {
            factorials.add(calculateFactorial(i));
        }

        return factorials;
    }

    public static BigInteger calculateFactorial(int number) throws Exception {

        if (number < 0) {
            throw new Exception("Number must be non-negative");
        }

        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
