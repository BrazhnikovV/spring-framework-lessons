import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Main -
 *
 * @version 1.0.0
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class Main {

    public static void main( String[] args ) {

        SessionFactory sessionFactory = new Configuration()
            .configure( "hibernate.cfg.xml" )
            .addAnnotatedClass( Students.class )
            .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        String unixTime = String.valueOf( System.currentTimeMillis() / 1000L );
        Students students = new Students();
        students.setCreated_at( unixTime );
        students.setUpdated_at( unixTime );
        students.setName( "Name" );
        students.setDescription( "Description" );
        session.beginTransaction();
        session.save( students );
        session.getTransaction().commit();
    }
}
