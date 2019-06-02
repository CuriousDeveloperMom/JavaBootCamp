package com.company;
import java.util.Scanner;
import java.util.Random;

public class HiLo {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Welcome to Hi-Lo : ");
        System.out.println("Enter Your Name : ");
        System.out.println("Ok, Here are the rules");

        Random computerRandom = new Random();
        int computerGuess;
        computerGuess = computerRandom.nextInt(100) + 1;
        System.out.println(computerGuess);

        int userInput;
        int guesses;
        String name;
        name = myScanner.nextLine();

        do{
        System.out.println("Guess any number :  (bewtween 1 to 100)");
        userInput = Integer.parseInt(myScanner.nextLine());
        guesses ++;


             if (userInput < computerRandom){
                    System.out.println("Too Low");
             }else if (userInput > computerRandom) {
                    System.out.println("Too high");
             }
        }while(userInput != computerRandom);

        System.out.println("Congratulation!" + name + "you won!");
        System.out.println("It took you " + guesses + "to guess the number");


    }
}
