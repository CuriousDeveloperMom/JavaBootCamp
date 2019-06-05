import java.util.Random;
public class FortuneCookie {

    public static void main(String[] args) {

        Random ran = new Random();
        int fornum = ran.nextInt(6) + 1;
        String msg;

        if ( fornum == 1 )
            msg = "You have an awesome day!";
        else if ( fornum == 2 )
            msg = "You have a fantastic day!";
        else if ( fornum == 3 )
            msg = "You will have an adventurous day!";
        else if ( fornum == 4 )
            msg = "Today is your lucky day!";
        else if ( fornum == 5 )
            msg = "Be Kind to others!";
        else if ( fornum == 6 )
            msg = "You have lovely day!";
        else
            msg = "Be cautious today!";

        System.out.println("");
        System.out.println( " Fortune cookie says: " + msg );

        int lottonum1 = 1 + ran.nextInt(54);
        int lottonum2 = 1 + ran.nextInt(54);
        int lottonum3 = 1 + ran.nextInt(54);
        int lottonum4 = 1 + ran.nextInt(54);
        int lottonum5 = 1 + ran.nextInt(54);
        int lottonum6 = 1 + ran.nextInt(54);

        System.out.println( "\t" + lottonum1 + " - " + lottonum2 + " - " + lottonum3 + " - " + lottonum4 + " - " + lottonum5 + " - " + lottonum6 );


    }
}