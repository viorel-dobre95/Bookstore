package Services;

import Utils.HibernateConfiguration;
import entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Scanner;

public class ReviewService {
    SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
    public void addReview(){
        Scanner scanner = new Scanner(System.in);
        Book book = null;

        while(book == null) {
            System.out.println("Enter the name of the book you want to review: ");
            String bookName = scanner.nextLine();

            Session session = sessionFactory.openSession();


            Query<Book> bookQuery = session.createQuery("Select b from Book b where b.bookName = :bookName");
            bookQuery.setParameter("bookName", bookName);
            book = bookQuery.getSingleResult();

            session.close();

            if (book == null) {
                System.out.println("Book not found. Please try again.");
            }
        }

        System.out.println("Book found: "+book.getBookName());

        System.out.println("Write your review: ");
        String reviewText = scanner.nextLine();

        int rating =-1;
        while(rating < 0 || rating > 5){

            System.out.println("Enter a rating from 0 to 5: ");
            rating = scanner.nextInt();
            if (rating < 0 || rating > 5){
                System.out.println("Invalid rating! Please try again.");
            }


        }
        System.out.println("The review has been added.");

    }
}
