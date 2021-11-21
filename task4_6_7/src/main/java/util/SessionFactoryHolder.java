package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryHolder {
    private static SessionFactory sessionFactory;

    private SessionFactoryHolder() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry reg =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.task4.cfg.xml")
                            .build();
            sessionFactory = new MetadataSources(reg)
                    .buildMetadata()
                    .buildSessionFactory();

        }
        return sessionFactory;
    }
}
