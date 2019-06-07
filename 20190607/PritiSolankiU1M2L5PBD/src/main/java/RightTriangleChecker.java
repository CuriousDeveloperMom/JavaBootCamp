import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int a,b,c = 0;

        System.out.println("Side 1 : ");
        a = Integer.parseInt(myScanner.nextLine());

        do {
            System.out.println("Side 2 : ");
            b = Integer.parseInt(myScanner.nextLine());
            if (b < a)
                    System.out.println(b + " is smaller than " + a + ". Try again");
        }while(b < a);

        do {
            System.out.println("Side 3 : ");
            c = Integer.parseInt(myScanner.nextLine());
            if (c < b)
                System.out.println(c + " is smaller than " + b + ". Try again");
        }while(c < b);

        System.out.println("Your three side are " + a + " " + b + " " + c);
        if (((a*a) + (b*b)) == (c*c))
            System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
        else
            System.out.println("NO!  These sides do not make a right triangle!");
    }

}
