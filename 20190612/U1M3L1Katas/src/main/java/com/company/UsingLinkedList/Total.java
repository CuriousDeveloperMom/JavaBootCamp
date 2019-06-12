package com.company.UsingLinkedList;

import java.util.LinkedList;
import java.util.List;

public class Total {
    public static void main(String[] args) {

        List<Integer> numbers = new LinkedList<>();
        // List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 4, 5, 3,
        //7, 6, 1, 9,
        //10, 13, 56, 43))

        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);
        numbers.add(7);
        numbers.add(6);
        numbers.add(1);
        numbers.add(9);
        numbers.add(10);
        numbers.add(13);
        numbers.add(56);
        numbers.add(43);

        int total = 0;

        for(int element : numbers) {
            total += element;
        }

        System.out.println("The sum of all elements in the LinkedList is " + total);

    }
}
