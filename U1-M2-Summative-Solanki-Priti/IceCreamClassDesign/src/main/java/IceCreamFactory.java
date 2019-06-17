public class IceCreamFactory {

    private double amtOfMilk;
    private double amtOfCream;
    private double amtOfNuts;
    static double amtOfIceCream;

    //Constructor
    public IceCreamFactory(double amtOfMilk, double amtOfCream, double amtOfNuts) {
        this.amtOfMilk = amtOfMilk;
        this.amtOfCream = amtOfCream;
        this.amtOfNuts = amtOfNuts;
    }

    //Getter ANd Setters
    public double getAmtOfMilk() {
        return amtOfMilk;
    }

    public void setAmtOfMilk(double amtOfMilk) {
        this.amtOfMilk = amtOfMilk;
    }

    public double getAmtOfCream() {
        return amtOfCream;
    }

    public void setAmtOfCream(double amtOfCream) {
        this.amtOfCream = amtOfCream;
    }

    public double getAmtOfNuts() {
        return amtOfNuts;
    }

    public void setAmtOfNuts(double amtOfNuts) {
        this.amtOfNuts = amtOfNuts;
    }

    public static double getAmtOfIceCream() {
        return amtOfIceCream;
    }

    public static void setAmtOfIceCream(double amtOfIceCream) {
        IceCreamFactory.amtOfIceCream = amtOfIceCream;
    }

    //Method to make Icecream
    private double makeIceCream(double amtOfMilk, double amtOfCream, double amtOfNuts){

        return amtOfIceCream;
    }

}
