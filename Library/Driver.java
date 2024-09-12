package Library;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Books> bookList = new ArrayList<>();
        User user1 = new User("Amy");
        boolean action = true;


        Books book1 = new Books("Meeting the Universe Halfway", "Karen Barad", "978-0822339175");
        Books book2 = new Books("The Programmer's Brain", " Felienne Hermans", "978-1617298677");
        Books book3 = new Books("Blindsight", "Peter Watts", "978-1250237484");
        Books book4 = new Books("Test Driven Development", "Kent Beck", "978-0321146533");
        Books book5 = new Books("This Is How You Lose the Time War", "Amal El-Mohtar and Max Gladstone", "978-1529405231");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);

        while (action) {
            System.out.println("Available Actions: borrow, return, search\n" +
                    "Please enter your action: ...");
            String actionType = scanner.nextLine();

            System.out.println("Enter the book name:");
            String searchBookName = scanner.nextLine();

            if (actionType.equals("search")) {
                Books foundBook = searchBook(bookList, searchBookName);
                if (foundBook != null) {
                    System.out.println("The book is available: " + foundBook.getName() + " by " + foundBook.getAuthor() + " , ISBN: " + foundBook.getISBN());
                }
            } else if (actionType.equals("borrow")) {
                String result = borrowBook(bookList, searchBookName, user1);
                System.out.println(result);

                ArrayList<Books> usersBooks = user1.getBorrowedBooks();
                for (Books i : usersBooks) {
                    System.out.println("Your borrowed books: " + i.getName());
                }
            } else System.out.println(returnBook(bookList, searchBookName, user1));


            System.out.println("Would you like to continue?");
            System.out.println("1. Yes\n2. Exit");
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            if (userChoice != 1) {
                action = false;
            }
        }
        System.out.println("Goodbye, " + user1.getName() + "!");

    }


    public static Books searchBook(ArrayList<Books> bookList, String searchBookName) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().contains(searchBookName)) {
                return bookList.get(i);
            }
        }
        System.out.println(searchBookName + " is not available");
        return null;
    }

    public static String borrowBook(ArrayList<Books> bookList, String searchBookName, User user) {
        Books bookIsAvailable = searchBook(bookList, searchBookName);

        if (bookIsAvailable != null) {
            user.addBook(bookIsAvailable);
            bookList.remove(bookIsAvailable);
            return "The book was added to your account";
        } else {
            return "The book is not available to borrow";
        }
    }


    private static String returnBook(ArrayList<Books> bookList, String searchBook, User user) {
        Books bookIsBorrowed = searchBook(user.getBorrowedBooks(), searchBook);

        if (bookIsBorrowed != null) {
            user.remove(searchBook);
            bookList.add(bookIsBorrowed);
            return "The book was returned to the library";
        } else {
            return "The book was not borrowed";
        }
    }

}
