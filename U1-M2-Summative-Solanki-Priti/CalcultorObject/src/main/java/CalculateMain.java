public class CalculateMain {

    public static void main(String[] args) {
        Calculate cal = new Calculate();

        System.out.println("1 + 1 = " + cal.add(1, 1));
        System.out.println("23 - 52 = " + cal.sub(23,-52));
        System.out.println("34 * 2 = " + cal.mul(34,2));
        System.out.println("12/3 = " + cal.div(12,3));
        System.out.println("12/7 = " + cal.div(12, 7));
        System.out.println("3.4 + 2.3 = " + cal.add(3.4, 2.3));
        System.out.println("6.7 * 4.4 = " + cal.mul(6.7,4.4));
        System.out.println("5.5 - 0.5 = " + cal.sub(5.5, 0.5));
        System.out.println("10.8 / 2.2 = " + cal.div(10.8, 2.2));

    }
}
