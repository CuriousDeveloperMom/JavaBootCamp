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

            //int[] player = {1,2};
            //int turn = player[0];
            System.out.println("Player 1, enter your name: ");
            String player1 = myScanner.nextLine();
            System.out.println("Player 2, enter your name: ");
            String player2 = myScanner.nextLine();
            //String turn = player1;
            String [] arr = {player1,player2};
            int i=0;
            while ((PileA != 0) || (PileB != 0) || (PileC !=0)){
               if ((PileA<=0) && (PileB<=0) && (PileC<=0))
                    break;

                System.out.println("A :" + PileA + "       B: " + PileB + "      C: " + PileC);
                //System.out.print("A: " + PileA + "      B: " + PileB + "      C: " + PileC);
                System.out.println(arr[i] + " \n Choose a pile: ");
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
                i++;
                if (i==2)
                    i=i%2;
                //System.out.println("Player : " + turn);
            }

            System.out.println("      A: " + PileA + "      B: " + PileB + "      C: " + PileC);
            System.out.println("");
            System.out.println(arr[i] + " there are no counters left, so you WIN!");
            //System.out.println("Player : " + arr[i]);

        }

}



