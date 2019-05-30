package com.company;


import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int num1;
        int num2;
        int num3;

        System.out.println("Enter first number :");
        num1 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter second number: ");
        num2 = Integer.parseInt(myScanner.nextLine());
        System.out.println("Enter third number: ");
        num3 = Integer.parseInt(myScanner.nextLine());

        int avg = (num1+num2+num3)/3;

        System.out.println("The Average of three numbers: " + avg);


    }
}
