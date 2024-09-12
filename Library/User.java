package Library;

import java.util.ArrayList;

public class User {
    String name;
    private ArrayList<Books> borrowedBooks;


    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<Books>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Books> getBorrowedBooks() {
        return borrowedBooks;
    }

    void addBook(Books newBook) {
        borrowedBooks.add(newBook);
    }

    public void remove(String searchBook) {
        borrowedBooks.remove(searchBook);

    }
}

