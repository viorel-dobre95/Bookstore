package Services;

import Utils.HibernateConfiguration;
import entities.Bookstore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class BookstoreService {
    SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
    public void registerBookstore(){
        System.out.println("Enter the name of the Bookstore you want to register: ");
        Scanner scanner = new Scanner(System.in);
        String bookstoreName = scanner.nextLine();
        Bookstore bookstore = new Bookstore(bookstoreName);
        System.out.println(bookstore);
        Session session = sessionFactory.openSession();
        session.persist(bookstore);
        session.beginTransaction().commit();
        session.close();
    }

    public void getAllBookstore(){
        System.out.println("Displaying all Bookstores: ");
        Session session = sessionFactory.openSession();

        Query<Bookstore> query = session.createQuery("Select b from Bookstore b");
        List<Bookstore> bookstoreList = query.getResultList();
        session.close();
        System.out.println(bookstoreList);
    }
}
