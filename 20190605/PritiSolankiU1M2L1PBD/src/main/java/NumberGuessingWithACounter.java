import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithACounter {

    public static void main(String[] args) {

        //create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int randnum = rand.nextInt(10);
        System.out.println("Computer generated Random number : " + randnum);

        Scanner myScanner = new Scanner(System.in);
        System.out.println("I have chosen a number between 1 and 10.  Try to guess it. ");
        System.out.println("Your guess : ");
        int guess = Integer.parseInt(myScanner.nextLine());

        int count = 0;

        while(guess != randnum){
            System.out.println("That is incorrect.  Guess again.");
            guess = Integer.parseInt(myScanner.nextLine());
            count ++;
        }
        System.out.println("That's right!  You're a good guesser.");
        System.out.println("It only took you " + count + " tries.");
    }
}
