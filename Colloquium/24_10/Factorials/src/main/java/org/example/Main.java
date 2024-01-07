package org.example;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(factorialCalculator.calculateFactorial(100));
            System.out.println(factorialCalculator.getRowOfFactorials(12));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}