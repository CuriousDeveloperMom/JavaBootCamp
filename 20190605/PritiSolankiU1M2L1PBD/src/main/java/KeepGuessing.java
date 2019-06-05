import java.util.Random;
import java.util.Scanner;

public class KeepGuessing {
    public static void main(String[] args) {
        //create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int randnum = rand.nextInt(10);
        //System.out.println("Computer generated Random number : " + randnum);

        Scanner myScanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");
        System.out.println("Your guess : ");
        int guess = Integer.parseInt(myScanner.nextLine());
       // System.out.println("");

        while (guess != randnum) {
            System.out.println("Incorrect Guess again : ");
            System.out.println("Your guess : ");
            guess = Integer.parseInt(myScanner.nextLine());
        }
        System.out.println("That's right! You're a good guesser.");

    }
}
