package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int num;
        System.out.println("Enter a number :");
        num = Integer.parseInt(myScanner.nextLine());

        num = (num + 5) * 2;
       System.out.println("The number is: " + num );


    }
}
