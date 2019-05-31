import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String userInput;
        int userInt;

        System.out.println("Enter any number : ");
        userInput = myScanner.nextLine();
        userInt = Integer.parseInt(userInput);


        for (int i=2; i<=userInt; i++){
            int totalDiv = 0;
            //System.out.println("i = " + i );
            for (int j=1; j<=i; j++){
                //System.out.println("========> j = " + j);
                if (i%j == 0){
                    totalDiv++;
                }
                //System.out.println("totalDiv = " + totalDiv);

            }
            if (totalDiv == 2){
                System.out.println("  " + i + "   ");
            }


        }

    }
}
