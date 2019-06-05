public class ModulusAnimation {

    public static void main(String[] args) throws Exception {

        for ( int i=0; i<80; i++ )
        {
            if ( i%16 == 0 )
                System.out.print(" P                            \r");
            else if ( i%16 == 1 ){
                System.out.print(" P R                          \r");
            }
            else if ( i%16 == 2 ){
                System.out.print(" P R I                        \r");
            }
            else if ( i%16 == 3 ){
                System.out.print(" P R I T                      \r");
            }
            else if ( i%16 == 4 ){
                System.out.print(" P R I T I    L                \r");
            }
            else if ( i%16 == 5 ){
                System.out.print(" P R I T I    L                \r");
            }
            else if ( i%16 == 6 ){
                System.out.print(" P R I T I    L O              \r");
            }
            else if ( i%16 == 7 ) {
                System.out.print(" P R I T I    L O V            \r");
            }
            else if ( i%16 == 8 ){
                System.out.print(" P R I T I    L O V E          \r");
            }
            else if ( i%16 == 9 ){
                System.out.print(" P R I T I    L O V E S        \r");
            }
            else if ( i== 9 ){
                System.out.print(" P R I T I    L O V E S   J    \r");
            }
            else if ( i== 10 ){
                System.out.print(" P R I T I    L O V E S   J A  \r");
            }
            else if ( i%16 == 11 )
                System.out.print(" P R I T I    L O V E S   J A V \r");
            else if ( i%16 == 12 )
                    System.out.print(" P R I T I    L O V E S   J A V A\r");
            /*else if ( i%16 == 13 )
                System.out.print("       ********           \r");
            else if ( i%16 == 14 )
                System.out.print("     ********             \r");
            else if ( i%16 == 15 )
                System.out.print("   ********               \r");
            */
            Thread.sleep(200);
        }


    }
}