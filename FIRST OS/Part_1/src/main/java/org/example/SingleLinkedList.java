package org.example;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T> {

    ListItem<T> head;
    ListItem<T> tail;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            ListItem<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToEnd(T item) {
        ListItem<T> newItem = new ListItem<>();
        newItem.data = item;
        if (isEmpty()) {
            head = newItem;
            tail = newItem;
        } else {
            tail.next = newItem;
            tail = newItem;
        }
    }

    public void reverse() {
        if (!isEmpty() && head.next != null) {
            tail = head;
            ListItem<T> current = head.next;
            head.next = null;
            while (current != null) {
                ListItem<T> next = current.next;
                current.next = head;
                head = current;
                current = next;
            }
        }
    }
}