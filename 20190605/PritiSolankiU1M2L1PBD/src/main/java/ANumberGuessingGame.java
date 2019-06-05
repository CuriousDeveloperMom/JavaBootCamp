import java.util.Scanner;
import java.util.Random;

public class ANumberGuessingGame {

    public static void main(String[] args) {

        //create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int randnum = rand.nextInt(10);
        //System.out.println("Computer generated Random number : " + randnum);

        Scanner myScanner = new Scanner(System.in);
        System.out.println("I'm thinking of number from 1 to 10. ");
        System.out.println("Your guess : ");
        int guess = Integer.parseInt(myScanner.nextLine());
        System.out.println("");

        if (guess == randnum){
            System.out.println("That's right!  My secret number was " + randnum +"!");
        }else {
            System.out.println("Sorry, but I was really thinking of " + randnum + ".");
        }


    }
}

