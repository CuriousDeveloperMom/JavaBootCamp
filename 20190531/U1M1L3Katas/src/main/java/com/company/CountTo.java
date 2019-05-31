import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {

            Scanner myScanner = new Scanner(System.in);

            String userInput;
            int userInt;

        System.out.println("Enter a number : ");
        userInput = myScanner.nextLine();
        userInt = Integer.parseInt(userInput);

        for(int i=0; i<=userInt; i++){

            System.out.println(i);

        }


        }
    }


