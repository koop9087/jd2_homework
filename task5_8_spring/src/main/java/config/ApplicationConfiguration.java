package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("beans")
@ComponentScan("config")
public class ApplicationConfiguration {
}
