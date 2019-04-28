package client;

import hospital.Registry;
import interfaces.IDoctor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Client - класс реализующий функционал клиента(пациента)
 *
 * @version 1.0.0
 * @package client
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class Client {

    /*
    public static void main( String[] args ) {
        Registry registry = new Registry();
        registry.referPatientToDoctor();
    }
    */

    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext( "config.xml" );
        //IDoctor doctor = context.getBean( "doctor", IDoctor.class);
        Registry registry = context.getBean( "registry", Registry.class);
        registry.referPatientToDoctor();
    }
}
