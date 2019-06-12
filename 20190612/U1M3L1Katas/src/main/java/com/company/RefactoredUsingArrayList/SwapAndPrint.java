package com.company.RefactoredUsingArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapAndPrint {

    public static void main(String[] args) {

        //List<Integer> numbers = new ArrayList<Integer>();
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(2, 4, 5, 3, 7, 6, 1, 9, 10, 13, 56, 43));

        System.out.println("----------------");
        System.out.println("Original ArrayList");

        for(int element : numbers) {
            System.out.println(element);
        }

        int temp = numbers.get(0);
        numbers.set(0,numbers.get(numbers.size() - 1));
        numbers.set(numbers.size() - 1,temp);

        System.out.println("----------------");
        System.out.println("Swapped ArrayList");

        for(int element : numbers) {
            System.out.println(element);
        }

    }

}
