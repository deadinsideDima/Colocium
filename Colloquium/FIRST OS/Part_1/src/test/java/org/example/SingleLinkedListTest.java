package org.example;

import org.junit.jupiter.api.Test;
import org.example.SingleLinkedList;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    @Test
    void isEmpty() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addToEnd(5);
        list.addToEnd(1);
        list.addToEnd(10);
        list.addToEnd(12);
        assertFalse(list.isEmpty());
    }

    @Test
    void reverse() {

    }
}