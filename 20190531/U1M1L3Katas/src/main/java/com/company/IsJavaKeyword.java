import java.util.Scanner;


public class IsJavaKeyword {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        String userInput;

        System.out.println("Enter any word: ");

        userInput = myScanner.nextLine();

        switch (userInput) {
            case "java":
                System.out.println("Its a keyword");
                break;
            case "new":
                System.out.println("its a keyword");
                break;
            case "public":
                System.out.println("its a keyword");
                break;
            case "void":
                System.out.println("its a keyword");
                break;
            case "static":
                System.out.println("its a keyword");
                break;
            case "class":
                System.out.println("its a keyword");
                break;
            default:
                System.out.println("Its not Java keyword");
        }



    }


}
