package Utils;


public class HibernateConfiguration {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver")
                    .setProperty(Environment.URL, "jdbc:mysql://localhost:3306/petClinic")
                    .setProperty(Environment.USER, "root")
                    .setProperty(Environment.PASS, "parolaRoot")
                    .setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect")
                    .setProperty(Environment.HBM2DDL_AUTO, "update")
                    .setProperty(Environment.SHOW_SQL, "true")
                    .setProperty(Environment.FORMAT_SQL, "true")
                    .setProperty(Environment.HIGHLIGHT_SQL, "true")
                    .addAnnotatedClass(Veterinary.class)
                    .addAnnotatedClass(PetOwner.class)
                    .addAnnotatedClass(Pet.class)
                    .addAnnotatedClass(Appointment.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}

