import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Dekanat - класс для обеспечения выдачи
 * необходимой информации о студентах и курсах
 *
 * @version 1.0.1
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
public class Dekanat {

    /**
     *  @access private
     *  @var SessionFactory sessionFactory - сессия для работы с базой данных
     *  (как-то надо закрывать наверное)
     */
    private SessionFactory sessionFactory;

    /**
     * Dekanat - конструктор (выполняется инициализация сессии для работы с бд)
     */
    public Dekanat() {
        this.sessionFactory = new Configuration()
            .configure( "hibernate.cfg.xml" )
            .addAnnotatedClass( Students.class )
            .addAnnotatedClass( Courses.class )
            .buildSessionFactory();;
    }

    /**
     * help - помощь(справка) которую выдает деканат посетителям
     * @param req - данные вводимые пользователем в консоль
     * @return String
     */
    public String help( String[] req ) {
        switch( req[0] ) {
            case "help":
                return "help: List commands " +
                        "\n==================== " +
                        "\n allstudents \n delstudent 1 \n allcourses \n delcourse 1";
            case "allstudents":
                return this.getStudentsList().toString();

            case "allcourses":
                return this.getCoursesList().toString();
            case "delstudent":
                return this.removeStudent( req[1] ).toString();
            case "delcourse":
                return this.removeCourse( req[1] ).toString();
            default:
                return "Sorry nothing we can help, read help";
        }
    }

    /**
     * getStudentsList - получить список студенотов в виде строки
     * @return String
     */
    private String getStudentsList() {

        AtomicReference<String> listStudents = new AtomicReference<>("" );
        AtomicReference<String> listCourses  = new AtomicReference<>("" );

        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Students> students = session.createQuery( "from Students" ).getResultList();
        students.stream().forEach( student -> {

            listCourses.set( "" );
            student.getCoursesList().stream().forEach( course -> {
                listCourses.updateAndGet( v -> v + " Course: " + course.getName() + "\n" );
            });
            listStudents.updateAndGet( v -> v + "id: " + student.getId() + " Name: " + student.getName() + "\n" + listCourses );
        });

        session.getTransaction().commit();

        return listStudents.get();
    }

    /**
     * getCoursesList - получить список
     * @return String
     */
    private String getCoursesList() {

        AtomicReference<String> listStudents = new AtomicReference<>("" );
        AtomicReference<String> listCourses  = new AtomicReference<>("" );

        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Courses> courses = session.createQuery( "from Courses" ).getResultList();
        courses.stream().forEach( course -> {

            listStudents.set( "" );
            course.getStudentsList().stream().forEach( student -> {
                listStudents.updateAndGet( v -> v + " Student: " + student.getName() + "\n" );
            });
            listCourses.updateAndGet( v -> v + "id: " + course.getId() + " Name: " + course.getName() + "\n" + listStudents );
        });

        session.getTransaction().commit();

        return listCourses.get();
    }

    /**
     * removeStudent - удалить студента
     * @return String
     */
    private String removeStudent( String id ) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Students> students = session.createQuery( "from Students" ).getResultList();

        students.stream().forEach( student -> {
            String courseId = String.valueOf( student.getId() );
            if ( id.equals( courseId ) ) {
                session.delete(student);
            }
        });

        return "remove id = " + id ;
    }

    /**
     * removeCourse - удалить курс
     * @return String
     */
    private String removeCourse( String id ) {

        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Courses> courses = session.createQuery( "from Courses" ).getResultList();

        courses.stream().forEach( course -> {
            String courseId = String.valueOf( course.getId() );
            if ( id.equals( courseId ) ) {
                session.delete(course);
            }
        });
        return "remove id = " + id ;
    }
}
