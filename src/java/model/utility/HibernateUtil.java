package model.utility;

import model.entity.Location;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil
{
    private static HibernateUtil INSTANCE;

    private HibernateUtil() { }

    public static HibernateUtil getINSTANCE()
    {
        if(INSTANCE == null) INSTANCE = new HibernateUtil();
        return INSTANCE;
    }

    public SessionFactory getSessionFactory()
    {
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/google_map_app");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "123456");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(settings);

        configuration.addAnnotatedClass(Location.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);


        return sessionFactory;
    }
}
