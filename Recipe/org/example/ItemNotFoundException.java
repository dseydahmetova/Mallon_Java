package Recipe.org.example;

public class ItemNotFoundException extends RuntimeException{
    private static final String ERROR_MESSAGE = "Element Not found";

    public ItemNotFoundException() {
        super(ERROR_MESSAGE);
    }
}
