package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int num1;
        int num2;

        System.out.println("Enter first number :");
        num1 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter second number: ");
        num2 = Integer.parseInt(myScanner.nextLine());

        int diff = num1 - num2;

        System.out.println("The Difference of two numbers: " + diff);


    }

}
