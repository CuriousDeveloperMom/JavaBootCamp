import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int num = 0;
        double ans = 0;
        System.out.println("SQUARE ROOT!");
        System.out.println("Enter a number : ");
        num = Integer.parseInt(myScanner.nextLine());


        while (num < 0) {
            System.out.println("You can't take the square root of a negative number, silly.");
            System.out.println("Try again : ");
            num = Integer.parseInt(myScanner.nextLine());
        }
        ans = Math.sqrt(num);
        System.out.println("Square Root of " + num + " is : " + ans);

    }
}