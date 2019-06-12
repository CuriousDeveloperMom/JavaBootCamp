package com.company.UsingLinkedList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SwapAndPrint {
    public static void main(String[] args) {

        List<Integer> numbers = new LinkedList<>();

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

        System.out.println("----------------");
        System.out.println("Original LinkedList");

        for(int element : numbers) {
            System.out.println(element);
        }

        int i = 0;
        int j = numbers.size();
        Collections.swap(numbers,i,j-1);

        System.out.println("----------------");
        System.out.println("Swapped LinkedList");

       for(int element : numbers) {
            System.out.println(element);
        }

    }

}
