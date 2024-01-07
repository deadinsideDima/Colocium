package org.example;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FibonacciCalculatorTest {
    @Test (expected = Exception.class)
    public void negativeFibonacci() throws Exception {
        fibonacciCalculator.calculateFibonacci(-1410);
    }

    @Test (expected = Exception.class)
    public void rowOfNegativeFibonacci() throws Exception {
        fibonacciCalculator.getRowOfFibonacci(-120);
    }

    @Test
    public void zeroFibonacci() throws Exception {
        assertEquals(fibonacciCalculator.calculateFibonacci(0), BigInteger.ZERO);
    }

    @Test
    public void fibonacciOfFive() throws Exception {
        assertEquals(fibonacciCalculator.calculateFibonacci(5), BigInteger.valueOf(5));
    }

    @Test
    public void fibonacciOfSix() throws Exception {
        assertEquals(fibonacciCalculator.calculateFibonacci(6), BigInteger.valueOf(8));
    }

    @Test
    public void fibonacciOfFirstSixNumbers() throws Exception {
        ArrayList<BigInteger> list = new ArrayList<BigInteger>(
                Arrays.asList(
                        BigInteger.ZERO,
                        BigInteger.ONE,
                        BigInteger.ONE,
                        BigInteger.TWO,
                        BigInteger.valueOf(3),
                        BigInteger.valueOf(5)
                )
        );
        List<BigInteger> result = fibonacciCalculator.getRowOfFibonacci(6);

        assertEquals(6, result.size());
        assertEquals(list, fibonacciCalculator.getRowOfFibonacci(6));
    }
}