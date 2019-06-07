import java.util.Scanner;

public class AddingValuesInALoop {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int num = 0;
        //int num2 = 0;
        int sum = 0;

        do {
            System.out.println("Enter any number :");
            num = Integer.parseInt(myScanner.nextLine());
            sum = sum + num;
        } while (num != 0);
        System.out.println("Total of Numbers is : " + sum);
    }
}
