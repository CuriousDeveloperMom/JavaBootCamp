import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WhereIsIt {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(i, ran.nextInt(50));
        }
        System.out.println("ArrayList : " + numbers);

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int num = Integer.parseInt(myScanner.nextLine());
        System.out.println("Value to find: " + num);

        boolean flag = false;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == num) {

                flag = true;

                System.out.println(num + " is in the slot " + i + ".");
            }
        }
        if (flag == false)
            System.out.println(num + "is not in the Arraylist.");
    }

    }
