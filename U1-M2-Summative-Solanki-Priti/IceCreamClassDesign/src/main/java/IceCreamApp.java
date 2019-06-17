import java.util.Scanner;

public class IceCreamApp {

    public static void main(String[] args) {

        IceCreamStore iStore = new IceCreamStore();
        IceCreamFactory iFactory = new IceCreamFactory();

        iStore.flavorsOfIceCream.put("Vanilla",20);
        iStore.flavorsOfIceCream.put("Chocolate",10);
        iStore.flavorsOfIceCream.put("Mint",5);
        iStore.flavorsOfIceCream.put("Strawberry",10);
        iStore.flavorsOfIceCream.put("CookieDough",15);
        iStore.flavorsOfIceCream.put("ChocolateChip",10);

        Scanner myScanner = new Scanner(System.in);
        int choice = 0;
        int scoop = 0;

        do {
            System.out.println("################# IceCream Menu #################");
            System.out.println("Select 1 for Vanilla");
            System.out.println("Select 2 for Chocolate");
            System.out.println("Select 3 for Mint");
            System.out.println("Select 4 for Strawberry");
            System.out.println("Select 5 for CookieDough");
            System.out.println("Select 6 for ChocolateChip");
            System.out.println("\nEnter your selection: ");
            choice = Integer.parseInt(myScanner.nextLine());
            System.out.println("Enter quantity in scoops : ");
            scoop = Integer.parseInt(myScanner.nextLine());
            int curQuantity = 0;
            String flavor;
            switch (choice) {
                case 1:
                    flavor = "Vanilla";
                    break;
                case 2:
                    flavor = "Chocolate";
                    break;
                case 3:
                    flavor = "Mint";
                    break;
                case 4:
                    flavor = "Strawberry";
                    break;
                case 5:
                    flavor = "CookieDough";
                    break;
                default:
                    flavor = "ChocolateChip";
                    break;
            }

            curQuantity = (int) iStore.flavorsOfIceCream.get(flavor);
            if (scoop <= curQuantity) {
                iStore.flavorsOfIceCream.replace(flavor, curQuantity - scoop);
                if (iStore.iceCreamOrderMemo.containsKey(flavor)) {
                    iStore.iceCreamOrderMemo.replace(flavor, (int) iStore.iceCreamOrderMemo.get(flavor) + scoop);

                } else {
                    iStore.iceCreamOrderMemo.put(flavor, scoop);
                    System.out.println("Enjoy your IceCream!");
                }
            } else {
                System.out.println(flavor + " is not available");
            }
        }while (iStore.flavorsOfIceCream.forEach();)
    }
}
