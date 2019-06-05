import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Are you ready for the quiz? ");
        System.out.println("Okay, here it comes!");
        System.out.println("Q1) What is the capital of Alaska?");       // Question 1
        System.out.println("\t1) Melbourne");
        System.out.println("\t2) Anchorage");
        System.out.println("\t3) Juneau");
        System.out.println("");
        System.out.println("> ");

        int ans = Integer.parseInt(myScanner.nextLine());
        int count = 0;

        if (ans == 3){
            System.out.println("That's right!");
            count++;
        }
        else {
            System.out.println("That's incorrect.");
        }

        System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?");    //Question 2
        System.out.println("        1) yes ");
        System.out.println("        2) no  ");
        System.out.println("");
        System.out.println("> ");

        ans = Integer.parseInt(myScanner.nextLine());
        if (ans == 2){
            System.out.println("That's right!");
            count++;
        }
        else {
            System.out.println("Sorry, \"cat\" is a string. ints can only store numbers.");
        }

        System.out.println("Q3) What is the result of 9+6/3?");
        System.out.println("        1) 5 ");
        System.out.println("        2) 11");
        System.out.println("        3) 15/3");
        System.out.println("");
        System.out.println("> ");

        ans = Integer.parseInt(myScanner.nextLine());
        if (ans ==2 ){
            System.out.println("That's correct!");
            count++;
        }
        else {
            System.out.println("That's incorrect.");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Overall, you got " + count +  " out of 3 correct.\n" + "Thanks for playing!\n");
    }

}
