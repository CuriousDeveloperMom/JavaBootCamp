import java.util.Scanner;

public class ConverterApplication {
    public static void main(String[] args) {

        ConverterIf conIf = new ConverterIf();
        ConverterSwitch conSwitch = new ConverterSwitch();

        Scanner myScanner = new Scanner(System.in);
        boolean flag = false;

        do {
        try {
                System.out.println("####################################################################");
                System.out.println("Enter a Number between 1 to 12 (to convert it to Month) : ");
                int num = Integer.parseInt(myScanner.nextLine());
                System.out.println("Output using ConverterIf : ");
                System.out.println("The corresponding Month to number " + num + " is " + conIf.convertMonth(num));
                System.out.println("Output using ConverterSwitch : ");
                System.out.println("The corresponding Month to number " + num + " is " + conSwitch.convertMonth(num));

                System.out.println("####################################################################");

                System.out.println("Enter a Number between 1 to 7 (to convert it to Day) : ");
                num = Integer.parseInt(myScanner.nextLine());
                System.out.println("Output using ConverterIf : ");
                System.out.println("The corresponding Day to number " + num + " is " + conIf.convertDay(num));
                System.out.println("Output using ConverterSwitch : ");
                System.out.println("The corresponding Day to number " + num + " is " + conSwitch.convertDay(num));
                System.out.println("####################################################################");
                flag = true;
        }catch (Exception e){
            System.out.println("Please Enter a Valid Number. ");
        }
        }while(flag==false);

    }
}
