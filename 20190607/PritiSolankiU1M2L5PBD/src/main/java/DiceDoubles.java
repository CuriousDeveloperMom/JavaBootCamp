import java.util.Random;

public class DiceDoubles {

    public static void main(String[] args) {
        Random ran = new Random();
        int dice1;
        int dice2;

        do {
            dice1 = ran.nextInt(6) + 1;
            dice2 = ran.nextInt(6) + 1;
            int sum = dice1 + dice2;
            System.out.println("HERE COMES THE DICE!");
            System.out.println("");
            System.out.println("Roll #1 : " + dice1);
            System.out.println("Roll #2 : " + dice2);
            System.out.println("The total is " + sum + "!");
        } while (dice1!=dice2);

    }
}
