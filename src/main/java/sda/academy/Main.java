package sda.academy;

import Services.BookstoreService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Bookstore!\n" +
                "Please chose one of the following options:\n" +
                "0 - End session\n" +
                "1 - Register a Bookstore\n" +
                "2 - Display all Bookstores\n" +
                "3 - Register a Book\n" +
                "4 - Display all Books\n" +
                "5 - Add a Review\n" +
                "6 - Display all Reviews\n");

        System.out.print("Alegeti optiunea: ");

        Scanner scanner = new Scanner(System.in);
        Integer UserInput = scanner.nextInt();
        BookstoreService bookstoreService = new BookstoreService();
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
                System.out.println("Enter the name of the Book you want to register: ");
                break;
            case 4:
                System.out.println("Displaying all Books: ");
                break;
            case 5:
                System.out.println("Adding  a Review ...");
                break;
            case 6:
                System.out.println("Displaying all Reviews: ");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 0 and 6");
        }

    }
}