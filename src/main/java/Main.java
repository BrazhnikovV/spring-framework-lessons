import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            .addAnnotatedClass( Dekanat.class )
            .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        String unixTime = String.valueOf( System.currentTimeMillis() / 1000L );

        //Dekanat dekanat = new Dekanat();

        ArrayList<List> list = new ArrayList<>();

        session.beginTransaction();
        List<Dekanat> dekanats = session.createQuery( "from Dekanat" ).getResultList();
        dekanats.stream().forEach( d -> {
            list.add(d.getStudentsList());
        });
        session.getTransaction().commit();

        //System.out.println(list);

        /*
        Students students = new Students();
        students.setCreated_at( unixTime );
        students.setUpdated_at( unixTime );
        students.setName( "Name" );
        students.setDescription( "Description" );
        session.beginTransaction();
        session.save( students );
        session.getTransaction().commit();
        */
    }
}
