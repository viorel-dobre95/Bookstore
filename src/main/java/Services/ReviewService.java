package Services;

import Utils.HibernateConfiguration;
import entities.Book;
import entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
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

        int reviewRate =-1;
        while(reviewRate < 0 || reviewRate > 5){

            System.out.println("Enter a rating from 0 to 5: ");
            reviewRate = scanner.nextInt();
            if (reviewRate < 0 || reviewRate > 5){
                System.out.println("Invalid rating! Please try again.");
            }
        }
        System.out.println("The review has been added.");
        System.out.println(book);
        Review review = new Review();
        review.setBook(book);
        review.setreviewText(reviewText);
        review.setReviewRate(reviewRate);

        Session session = sessionFactory.openSession();
        session.persist(review);
        session.beginTransaction().commit();
        session.close();
        System.out.println("Your review has been added!");
    }


    public void displayReview(){
        Scanner scanner = new Scanner(System.in);
        Book book = null;

        Session session = sessionFactory.openSession();

        while(book == null) {
            System.out.println("Enter the name of the book you want to see the reviews for:  ");
            String bookName = scanner.nextLine();

            Query<Book> bookQuery = session.createQuery("Select b from Book b where b.bookName = :bookName");
            bookQuery.setParameter("bookName", bookName);
            book = bookQuery.getSingleResult();


            if (book == null) {
                System.out.println("Book not found. Please try again.");
            }

        }

        Query<Review> reviewQuery = session.createQuery("Select r from Review r where r.book.bookId = :bookId");
        reviewQuery.setParameter("bookId",book.getBookId());
        List<Review> reviews = reviewQuery.getResultList();
        if(reviews.isEmpty()){
            System.out.println("There are no reviews registered for this book.");
        }else System.out.println(reviews);

    }
}
