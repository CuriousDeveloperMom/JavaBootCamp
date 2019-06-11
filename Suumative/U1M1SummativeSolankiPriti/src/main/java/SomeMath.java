import java.sql.SQLOutput;

public class SomeMath {

    static int total5(int num1, int num2,int num3, int num4, int num5){
        int total = num1 + num2 + num3 + num4 + num5;
        return total;
    }
    static double average5(int num1, int num2,int num3, int num4, int num5){
        int avg = ((num1 + num2 + num3 + num4 + num5)/5);
        return avg;
    }
    static double largest5(double num1, double num2, double num3, double num4, double num5){
        double max;
        max = num1;
        if (num2 > max)
            max = num2;
        if (num3 > max)
            max = num3;
        if (num4 > max)
            max = num4;
        if (num5 > max)
            max = num5;
        return max;
    }

    public static void main(String[] args) {
        System.out.println("The sum of five numbers : " + total5(1, 2, 3, 4, 5));
        System.out.println("The average of five numbers : " + average5(1, 3, 5, 7, 9));
        System.out.println("The largest of five numbers : " + largest5(42.0, 35.1, 2.3, 40.2, 15.6));

    }

}
