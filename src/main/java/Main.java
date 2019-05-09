import java.util.Scanner;

/**
 * Main -
 *
 * @version 1.0.0
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class Main {

    public static void main( String[] args ) {

        Scanner in = new Scanner( System.in );
        Dekanat dekanat = new Dekanat();

        System.out.print("Enter the command( or enter help): ");

        while ( in.hasNext() ) {
            String str = in.nextLine();
            String[] inputStrings = str.split( " " );

            if ( inputStrings[0].equals( "exit" ) ) {
                in.close();
                return;
            }

            System.out.println( dekanat.help( inputStrings ) );
        }

        /*
        String unixTime = String.valueOf( System.currentTimeMillis() / 1000L );
         */
    }
}
