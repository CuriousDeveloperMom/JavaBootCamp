import java.util.Scanner;


public class UltimateQuestion {

    public static void main(String[] args) {

            Scanner myScanner = new Scanner(System.in);
            String userInput;
            int userInt;

            do {
                System.out.println("Enter a number between 1 to 100 : ");
                userInput = myScanner.nextLine();
                userInt = Integer.parseInt(userInput);

                if (userInt < 1 || userInt > 100) {
                    System.out.println("Invalid input. Please enter a number between 1 to 100 only. ");
                }

            } while(userInt != 42);

        System.out.println("That's the number I was looking for! 42 is definitely the answer!");

        }
    }






