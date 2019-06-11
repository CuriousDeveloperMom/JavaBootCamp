import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String  words[] = new String[5];
        for (int i=0; i<words.length; i++){
            System.out.println("Enter word no. " + (i+1) + " : ");
            words[i] = myScanner.nextLine();
        }
        System.out.println("The Array of words : ");
        for (int i=0; i<words.length; i++){
            System.out.print(words[i] + " ");
        }
    }
}
