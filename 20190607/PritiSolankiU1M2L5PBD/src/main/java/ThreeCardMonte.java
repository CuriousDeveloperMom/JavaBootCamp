import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        Random random = new Random();
        int num = random.nextInt(3) + 1;
            System.out.println(num);
        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards.");
        System.out.println(" ");
        System.out.println("Which one is the ace?");
        System.out.println(" ");
        System.out.println("          ##  ##  ##      ");
        System.out.println("          ##  ##  ##      ");
        System.out.println("           1   2   3       ");
        System.out.println("   ");
        System.out.println("   ");
        System.out.println(">");
        int userInput = Integer.parseInt(myScanner.nextLine());
        if (userInput == num) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
            System.out.println(" ");
        } else {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + num);
            System.out.println(" ");
        }
        if (num == 1){
            System.out.println("          AA  ##  ##      ");
            System.out.println("          AA  ##  ##      ");
            System.out.println("           1   2   3       ");
        }else if(num == 2){
            System.out.println("          ##  AA  ##      ");
            System.out.println("          ##  AA  ##      ");
            System.out.println("           1   2   3       ");
        }else {
            System.out.println("          ##  ##  AA      ");
            System.out.println("          ##  ##  AA      ");
            System.out.println("           1   2   3       ");
        }



    }


}
