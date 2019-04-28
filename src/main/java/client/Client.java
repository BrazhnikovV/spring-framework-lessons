package client;

import config.AppConfig;
import hospital.Registry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
    // ============== Обычный способ выполнения функционала =============== //

    public static void main( String[] args ) {
        Registry registry = new Registry();
        registry.referPatientToDoctor();
    }

    // ============== Конфигурация через файл XML =============== //

    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext( "config.xml" );
        Registry registry = context.getBean("registry", Registry.class );
        registry.referPatientToDoctor();
    }

    // ============== Конфигурация через AppConfiguration =============== //

    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class );
        Registry registry = context.getBean("registry", Registry.class );
        registry.referPatientToDoctor();
    }
    */

    // ============== Использование Autowired (Здесь есть сомнения...) =============== //
    // По сути autowired отличается от javaConfig в данном случае, только добавлением аннотации Component для класа Registry,
    // а также добавлением аннотации Autowired для метода setDoctor.

    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class );
        Registry registry = context.getBean("registry", Registry.class );
        registry.referPatientToDoctor();
    }
}
