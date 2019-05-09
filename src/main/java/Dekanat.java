import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Dekanat - класс
 *
 * @version 1.0.1
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class Dekanat {

    private SessionFactory sessionFactory;

    public Dekanat() {
        this.sessionFactory = new Configuration()
            .configure( "hibernate.cfg.xml" )
            .addAnnotatedClass( Students.class )
            .addAnnotatedClass( Courses.class )
            .buildSessionFactory();;
    }

    public String help( String req ) {
        //System.out.println( req );
        switch( req ) {
            case "help":
                return "help: List commands " +
                        "\n==================== " +
                        "\n allstudents \n student 1 \n allcourses \n course 1";
            case "allstudents":
                return this.getStudentsList().toString();
            default:
                return "Sorry nothing we can help, read help";
        }
    }

    /**
     * getStudentsList - получить список студенотов в виде строки
     * @return String
     */
    private String getStudentsList() {

        Session session = this.sessionFactory.getCurrentSession();

        AtomicReference<String> listStudents = new AtomicReference<>("" );
        AtomicReference<String> listCourses  = new AtomicReference<>("" );

        session.beginTransaction();
        List<Students> students = session.createQuery( "from Students" ).getResultList();
        students.stream().forEach( student -> {
            student.getCoursesList().stream().forEach( course -> {
                listCourses.updateAndGet( v -> v + " Course: " + course.getName() + "\n" );
            });
            listStudents.updateAndGet( v -> v + "id: " +
                    student.getId() + " Name: " +
                    student.getName() + "\n" +
                    listCourses );
        });
        session.getTransaction().commit();

        return listStudents.get();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
