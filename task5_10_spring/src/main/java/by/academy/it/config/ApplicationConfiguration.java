package by.academy.it.config;

import by.academy.it.annotation.Include;
import by.academy.it.annotation.NoInclude;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(value = "by.academy",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Include.class),
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = NoInclude.class))
public class ApplicationConfiguration {
}
