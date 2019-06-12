package com.company.RefactoredUsingArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseAndPrint {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(2, 4, 5, 3, 7, 6, 1, 9, 10, 13, 56, 43));

        System.out.println("--------------");
        System.out.println("Original ArrayList");
        System.out.println("--------------");

        for(int element : numbers) {
            System.out.println(element);
        }

        List<Integer> reversed = new ArrayList<>();

        int temp = 0;
        for(int i = (numbers.size()-1); i >= 0; i--) {
            reversed.add(numbers.get(i));
        }

        System.out.println("--------------");
        System.out.println("Reversed ArrayList");
        System.out.println("--------------");

        for(int element : reversed) {
               System.out.println(element);
        }
    }

}
