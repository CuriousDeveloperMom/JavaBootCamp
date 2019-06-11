import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int num = 0;
        System.out.println("Enter a number between 1 and 10. ");

        do {
            num = Integer.parseInt(myScanner.nextLine());
            if ((num < 1) || (num > 10))
                System.out.println("You must enter a number between 1 and 10, please try again.");
        }while ((num < 1) || (num > 10)) ;

        System.out.println("The Valid Number : " + num);
    }
}