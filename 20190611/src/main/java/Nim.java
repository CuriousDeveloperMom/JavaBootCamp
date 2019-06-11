import java.sql.SQLOutput;
import java.util.Scanner;

public class Nim {

        public static void main(String[] args) {

            Scanner myScanner = new Scanner(System.in);
            String P;
            int PileA = 3;
            int PileB = 3;
            int PileC = 3;
            int count = 0;
            //String player1 = "Player1";
            //String player2 = "Player2";
            //String turn = "";
            //turn = player1;
            //String temp = "";

            for (int i=0; i<arr.length; i++)

            while ((PileA != 0) || (PileB != 0) || (PileC !=0)){
               if ((PileA<=0) && (PileB<=0) && (PileC<=0))
                    break;

                System.out.println("A :" + PileA + "       B: " + PileB + "      C: " + PileC);
                //System.out.print("A: " + PileA + "      B: " + PileB + "      C: " + PileC);
                System.out.println("\nChoose a pile: ");
                P = myScanner.nextLine();
                //System.out.println(P);
                System.out.println("How many to remove from pile " + P + ":");
                count = Integer.parseInt(myScanner.nextLine());
                //System.out.println(count);

                switch (P) {
                    case "A":
                        PileA = PileA - count;
                        break;
                    case "B":
                        PileB = PileB - count;
                        break;
                    case "C":
                        PileC = PileC - count;
                        break;
                }
                temp = turn;
                turn = player2;
                System.out.println(turn);
            }

            System.out.print("      A: " + PileA + "      B: " + PileB + "      C: " + PileC);
            System.out.println("All piles are empty. Good job!\n");
            System.out.println(turn);

        }

}



