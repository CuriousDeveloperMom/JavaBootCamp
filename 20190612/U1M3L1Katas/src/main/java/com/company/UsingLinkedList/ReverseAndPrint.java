package com.company.UsingLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseAndPrint {
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


        System.out.println("--------------");
        System.out.println("Original LinkedList");
        System.out.println("--------------");

        for(int element : numbers) {
            System.out.println(element);
        }

        List<Integer> reversed = new LinkedList<>();

        for(int i = (numbers.size()-1); i >= 0; i--) {
            reversed.add(numbers.get(i));
        }

        System.out.println("--------------");
        System.out.println("Reversed LinkedList");
        System.out.println("--------------");

        for(int element : reversed) {
            System.out.println(element);
        }
    }
}
