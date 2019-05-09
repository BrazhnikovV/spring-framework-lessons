import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
            String str = in.next();
            String[] inputStrings = str.split( " " );

            if ( inputStrings[0].equals( "exit" ) ) {
                in.close();
                return;
            }

            System.out.println( dekanat.help( inputStrings[0] ) );
        }

        /*
        SessionFactory sessionFactory = new Configuration()
            .configure( "hibernate.cfg.xml" )
            .addAnnotatedClass( Students.class )
            .addAnnotatedClass( Courses.class )
            .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        String unixTime = String.valueOf( System.currentTimeMillis() / 1000L );

        ArrayList<List> list = new ArrayList<>();

        session.beginTransaction();
        List<Students> students = session.createQuery( "from Students" ).getResultList();
        students.stream().forEach( d -> {
            list.add(d.getCoursesList());
        });
        session.getTransaction().commit();

        //System.out.println(list);

         */
    }
}
