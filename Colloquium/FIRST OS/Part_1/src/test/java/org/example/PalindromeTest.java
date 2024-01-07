package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    @Test(expected = Exception.class)
    public void throwsException() throws Exception {
        Palindrome.isPalindrome(-10);
    }
    @Test
    public void truePalindrome() throws Exception {
        assertTrue(Palindrome.isPalindrome(123321));
    }
    @Test
    public void falsePalindrome() throws Exception {
        assertFalse(Palindrome.isPalindrome(213));
    }

}