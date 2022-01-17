package by.academy.it;

import by.academy.it.config.ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {        //run main (^_^)
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);
        System.out.println("We don't want to include Disease " + Arrays.stream(beanNames).noneMatch(name -> name.equals("disease")));
        context.close();
    }
}
