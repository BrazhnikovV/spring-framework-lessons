package config;

import hospital.Registry;
import interfaces.IDoctor;
import doctors.Cardiologist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig - класс для конфигурирования приложения
 *
 * @version 1.0.0
 * @package config
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Configuration
public class AppConfig {

    @Bean(name = "doctor")
    public IDoctor doctor() {
        return new Cardiologist();
    }

    @Bean(name = "registry")
    public Registry registry( IDoctor doctor ) {
        Registry registry = new Registry();
        registry.setDoctor( doctor );
        return registry;
    }
}
