import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Please enter your current earth weight : ");
        double weight = Integer.parseInt(myScanner.nextLine());
        System.out.println("");
        System.out.println("I have information for following planets :");
        System.out.println("    1.   Venus    2. Mars     3. Jupiter      ");
        System.out.println("    4.   Saturn  5.  Uranus  6.  Neptune");
        System.out.println("");
        System.out.println("Which planet are you visiting?  ");

        int planet = Integer.parseInt(myScanner.nextLine());
        double weightperplanet;

        System.out.println("");
        if (planet == 1){
            weightperplanet = weight * 0.78;
            System.out.printf("Your weight would be %.2f pounds on that planet", weightperplanet);
        }
        else if (planet == 2) {
            weightperplanet = weight * 0.39;
            System.out.printf("Your weight would be %.2f pounds on that planet", weightperplanet);
        }
        else if (planet == 3) {
            weightperplanet = weight * 2.65;
            System.out.printf("Your weight would be %.2f pounds on that planet", weightperplanet);
        }
        else if (planet == 4) {
            weightperplanet = weight * 1.17;
            System.out.printf("Your weight would be %.2f pounds on that planet", weightperplanet);
        }
        else if (planet == 5) {
            weightperplanet = weight * 1.05;
            System.out.printf("Your weight would be %.2f pounds on that planet", weightperplanet);
        }
        else if (planet == 6) {
            weightperplanet = weight * 1.23;
            System.out.printf("Your weight would be %.2f pounds on that planet", weightperplanet);
        }
        else
            System.out.println("Invalid Planet.");
    }

}
