package sda.academy;

import Services.BookstoreService;
import Services.BookService;
import Services.ReviewService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer UserInput;
        System.out.print("Welcome to the Bookstore!\n");
        do{
            System.out.println(
                    "Please chose one of the following options:\n" +
                    "0 - End session\n" +
                    "1 - Register a Bookstore\n" +
                    "2 - Display all Bookstores\n" +
                    "3 - Register a Book\n" +
                    "4 - Display all Books\n" +
                    "5 - Add a Review\n" +
                    "6 - Display all reviews for a chosen book\n");

            System.out.print("Alegeti optiunea: ");

            UserInput = scanner.nextInt();
            BookstoreService bookstoreService = new BookstoreService();
            BookService bookService = new BookService();
            ReviewService reviewService = new ReviewService();
            switch (UserInput){
                case 0:
                    System.out.println("Ending Session.");
                    return;
                case 1:
                    bookstoreService.registerBookstore();
                    break;
                case 2:
                    bookstoreService.getAllBookstore();
                    break;
                case 3:
                    bookService.registerBook();
                    break;
                case 4:
                    bookService.getAllBooks();
                    break;
                case 5:
                    reviewService.addReview();
                    break;
                case 6:
                    reviewService.displayReview();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 6");
            }
        }while(UserInput!=0);


    }
}