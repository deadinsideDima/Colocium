package org.example;

public class Main {
    public static void main(String[] args) {
       SingleLinkedList<Integer> list = new SingleLinkedList<>();
       list.addToEnd(5);
       list.addToEnd(1);
       list.addToEnd(10);
       list.addToEnd(12);
       for (Integer item: list) {
           System.out.println(item);
       }
       System.out.println("-------------------");
       list.reverse();
        for (Integer item: list) {
            System.out.println(item);
        }
    }
}