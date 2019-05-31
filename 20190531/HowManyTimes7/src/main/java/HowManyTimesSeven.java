
import java.util.Random;

public class HowManyTimesSeven {

    public static void main(String[] args) {

        Random dice = new Random();
        int diceValue1;
        int diceValue2;
        int counter = 0;
        int firstSevenCounter = 0;

        for(int i=1; i<=100; i++) {
            diceValue1 = dice.nextInt(6) + 1;
            diceValue2 = dice.nextInt(6) + 1;
            System.out.println("diceValue1 : "+ diceValue1 + " ========== diceValue2 : "+ diceValue2);

            if(diceValue1 + diceValue2 == 7){
                counter++;
                if (firstSevenCounter == 0) {
                    firstSevenCounter = i;
                }
            }
        }

        System.out.println("It took " + firstSevenCounter + " roll to the first 7");
        System.out.println("The total number of 7s rolled out of 100 are " + counter);
    }
}

