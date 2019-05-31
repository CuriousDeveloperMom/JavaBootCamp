import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        String userInput;
        int num;

        System.out.println("Enter a number : ");

        userInput = myScanner.nextLine();
        num = Integer.parseInt(userInput);

        if ((num % 2) == 0 )

            System.out.println("The Number is Even.");
        else
            System.out.println("The number is Odd.");


    }
}
