import java.util.Random;
import java.util.Scanner;

public class HiLoWithLimitedTries {

    public static void main(String[] args) {
        //create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 99
        int randnum = rand.nextInt(100);
        System.out.println("Computer generated Random number : " + randnum);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("I'm thinking of a number between 1-100.  You have 7 guesses.");
        System.out.println("First guess : ");

        int guess = Integer.parseInt(myScanner.nextLine());
        if (guess > randnum)
            System.out.println("Sorry, that guess is too high.");
        else if (guess < randnum)
            System.out.println("Sorry, you are too low.");

        int count = 1;
        while (guess != randnum){
            System.out.println("That is incorrect.  Guess again.");
            guess = Integer.parseInt(myScanner.nextLine());
            if (guess > randnum)
                System.out.println("Sorry, that guess is too high.");
            else if (guess < randnum)
                System.out.println("Sorry, you are too low.");

            if(count >= 6)
                 break;
            else
                count++;
        }
        if (guess == randnum && count <= 7)
            System.out.println("You guessed it!  What are the odds?!?");
        else
            System.out.println("Sorry, you didn't guess it in 7 tries.  You lose.");



    }
}
