package com.trilogyed;

import java.util.Scanner;

public class LuxuryTaxCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        float player1;
        float player2;
        float player3;

        double tax;

        System.out.println("Player 1, input your salary (without dollar symbols or commas.");
        player1 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Player 1, input your salary (without dollar symbols or commas.");
        player2 = Integer.parseInt(myScanner.nextLine());

        System.out.println("Player 1, input your salary (without dollar symbols or commas.");
        player3 = Integer.parseInt(myScanner.nextLine());

        float totalCost = player1 + player2 + player3;

        System.out.println(" total salary (cost) is " + totalCost);

       if (totalCost > 40000000) {
            tax = totalCost * 0.18;
            System.out.println("The cost of Luxury Tax is: " + tax);
        }

    }
}
