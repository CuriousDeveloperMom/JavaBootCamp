import java.util.Scanner;

public class RectangularPavingCompany {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        double width;
        double length;
        double area;
        double perimeter;

        System.out.printf("Enter Widthof the driveway (in feet) : ");
        width  = Double.parseDouble(myScanner.nextLine());
        System.out.printf("Enter Widthof the driveway (in feet) : ");
        length = Double.parseDouble(myScanner.nextLine());
        area = width * length;
        System.out.println("The area of the Driveway is : " + area + " square foot");
        perimeter = (2*width) + (2*length);
        System.out.println("The Perimeter of driveway is : " + perimeter + " linear foot");

      //  double cementCostPerSF = 12.50;
        System.out.println("Enter Cost of Cement : ");
        double cementCostPerSF = Double.parseDouble(myScanner.nextLine());

        double totalCostOfCement = area * cementCostPerSF;
        System.out.println("The subtotal cost of cement: " + totalCostOfCement );

       // double costOfFramingFooters = 8.25;
        System.out.println("Enter Cost of Framing Footers : ");
        double costOfFramingFooters = Double.parseDouble(myScanner.nextLine());

        double totalCostOfFramingFooter = perimeter * costOfFramingFooters;
        System.out.println("The subtotal cost of Framing and Footers is : " + totalCostOfFramingFooter);



    }
}
