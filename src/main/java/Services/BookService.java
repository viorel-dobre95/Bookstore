package Services;

import Utils.HibernateConfiguration;
import entities.Book;
import entities.Bookstore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class BookService {
    SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
    public void registerBook(){
        System.out.println("Enter the name of the Book you want to register: ");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        Book book = new Book(bookName);
        System.out.println("Your book has been registered: "+book);
        Session session = sessionFactory.openSession();
        session.persist(book);
        session.beginTransaction().commit();
        session.close();
    }

    public void getAllBooks(){
        System.out.println("Displaying all Books: ");

        Session session = sessionFactory.openSession();

        Query<Book> query = session.createQuery("Select b from Book b");
        List<Book> bookList = query.getResultList();
        session.close();;
        for(Book book : bookList){
            System.out.println(book);
        }
    }
}
