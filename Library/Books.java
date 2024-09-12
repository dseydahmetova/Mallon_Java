package Library;

public class Books {
    private String name;
    private String author;
    private String ISBN;


    public Books(String name, String author, String ISBN) {
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }
}
