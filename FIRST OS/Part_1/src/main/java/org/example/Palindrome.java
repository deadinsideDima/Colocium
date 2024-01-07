package org.example;

public class Palindrome {
    public static boolean isPalindrome(long num) throws Exception {
        if (num < 0) {
            throw new Exception("Negative number");
        } else {
            long number = num, reverse = 0;
            while(number != 0)
            {
                long remainder = number % 10;
                reverse = reverse * 10 + remainder;
                number = number/10;
            }
            return num == reverse;
        }
    }
}