package com.company.PrintSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class PrintSet {
    public static void main(String[] args) {
        HashSet<Integer> h = new HashSet<Integer>(Arrays.asList(5,1,2,1,4,1,5));
        Iterator<Integer> itr = h.iterator();


        while (itr.hasNext()) {
            System.out.println(itr.next());
        }


    }


}
