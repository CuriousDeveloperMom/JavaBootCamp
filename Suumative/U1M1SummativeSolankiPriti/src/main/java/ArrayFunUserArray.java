import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int  numbers[] = new int[5];
        //numbers[0] = 0;
        for (int i=0; i<numbers.length; i++){
            System.out.println("Enter number " + (i+1) + ": ");
            numbers[i] = Integer.parseInt(myScanner.nextLine());
        }
        System.out.print("Numbers in Array : ");
        for (int i=0; i<numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
    }

}
