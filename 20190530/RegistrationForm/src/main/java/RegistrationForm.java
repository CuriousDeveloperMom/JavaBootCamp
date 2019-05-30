import java.util.Scanner;

public class RegistrationForm {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter First Name : ");
        String firstName = myScanner.nextLine();

        System.out.println("Enter Last Name : ");
        String lastName = myScanner.nextLine();

        System.out.println("Enter Email : ");
        String email = myScanner.nextLine();

        System.out.println("Twitter Handle : ");
        String tweeterHandle = myScanner.nextLine();

        System.out.println("Enter Age : ");
        int age = Integer.parseInt(myScanner.nextLine());

        System.out.println("Enter Country : ");
        String country = myScanner.nextLine();

        System.out.println("Enter Profession : ");
        String profession = myScanner.nextLine();

        System.out.println("Enter Favorite Operating System : ");
        String favOS = myScanner.nextLine();

        System.out.println("Enter Favorite Programming Language : ");
        String favPL = myScanner.nextLine();

        System.out.println("Enter Favorite Computer Scientist : ");
        String favCS = myScanner.nextLine();

        System.out.println("Enter Favorite Keyboard Shortcut : ");
        String favKS = myScanner.nextLine();

        System.out.println("Have you ever built your own computer : ");
        String buildYourComp = myScanner.nextLine();

        System.out.println("If you could be any superhero, who could it be: : ");
        String superhero = myScanner.nextLine();

        System.out.println("Registration information for command line grimm");
        System.out.println("===============================================");
        System.out.println("Full Name : " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Twitter Handle: " + tweeterHandle);
        System.out.println("Age : " + age);
        System.out.println("Country : " + country);
        System.out.println("Profession : " + profession);
        System.out.println("Favorite Operating System : " + favOS);
        System.out.println("Favorite Programming Language : " + favPL);
        System.out.println("Favorite Computer Scientist : " + favCS);
        System.out.println("Favorite Keyboard Shortcut : " + favKS);
        System.out.println("Have you ever built your own computer? : " + buildYourComp);
        System.out.println("Favorite superhero : " + superhero);
        System.out.println("===============================================");









    }
}
