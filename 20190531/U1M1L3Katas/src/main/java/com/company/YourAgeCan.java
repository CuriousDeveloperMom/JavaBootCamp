import java.util.Scanner;

public class YourAgeCan {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter your Age : ");

        String userInput;
        int age;

        userInput = myScanner.nextLine();
        age = Integer.parseInt(userInput);

        if (age >= 100)
            System.out.println("person is more then century old.");
        else if (age >= 80 && age <= 89)
            System.out.println("Person is an octogenerien.");
        else if (age >= 65)
            System.out.println("Person can retire.");
        else if (age >= 55)
            System.out.println("Person is eligible for AARP.");
        else if (age >= 35)
            System.out.println("Person can be president.");
        else if (age >= 21)
            System.out.println("Person can drink alcohol.");
        else if (age >= 18)
            System.out.println("Person can vote.");
        else
            System.out.println("The person is minor");


    }

}
