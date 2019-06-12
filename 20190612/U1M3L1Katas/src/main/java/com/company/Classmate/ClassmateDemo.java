package com.company.Classmate;

import java.util.ArrayList;
import java.util.List;

public class ClassmateDemo {
    public static void main(String[] args) {

        Classmate classmate1 = new Classmate("Priti", "Brown");
        Classmate classmate2 = new Classmate("Chitra", "Red");
        Classmate classmate3 = new Classmate("Harini", "Green");
        Classmate classmate4 = new Classmate("Vijaya", "Black");
        Classmate classmate5 = new Classmate("Raghi", "Blue");

        List<Classmate> list = new ArrayList<>();
        list.add(classmate1);
        list.add(classmate2);
        list.add(classmate3);
        list.add(classmate4);
        list.add(classmate5);

        System.out.println("***********************");
        System.out.println("Name        HairColor");
        System.out.println("***********************");

        for (Classmate element : list) {
            System.out.println(element.getName() + "    " + element.getHairColor());
       }

    }

}
