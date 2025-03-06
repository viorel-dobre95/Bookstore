package Utils;
import entities.Author;
import entities.Book;
import entities.Bookstore;
import entities.Review;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfiguration {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver")
                    .setProperty(Environment.URL, "jdbc:mysql://localhost:3306/bookstore")
                    .setProperty(Environment.USER, "root")
                    .setProperty(Environment.PASS, "123")
                    .setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect")
                    .setProperty(Environment.HBM2DDL_AUTO, "update")
                    .setProperty(Environment.SHOW_SQL, "true")
                    .setProperty(Environment.FORMAT_SQL, "true")
                    .setProperty(Environment.HIGHLIGHT_SQL, "true")
                    .addAnnotatedClass(Bookstore.class)
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(Author.class)
                    .addAnnotatedClass(Review.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}

