package GenericsAndOO;


import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;

public class TextMalflixApplication extends MalflixApplication {
    public TextMalflixApplication(MalflixService service) {
        super(service);
    }

    @Override
    public void run() {
        while (mainMenu()) {
            System.out.println("---------------");
        }
    }

    protected boolean mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Command (search by tag, search by name, stream, get): ");
        String command = sc.nextLine();
        switch (command) {
            case "search by tag" -> search();
            case "search by name" -> searchByName();
            case "stream" -> stream();
            case "get" -> get();
            case "exit" -> {return false; }
        }
        return true; // exits
    }

    protected void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter tag you wish to search: ");
        String tag = sc.nextLine();
        Collection<Show> shows = this.service.getShows(tag);
        System.out.println("Shows meeting criteria: ");
        System.out.println(shows);
    }

    protected void searchByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name you wish to search: ");
        String name = sc.nextLine();
        Collection<Show> shows = this.service.getShowsByName(name);
        System.out.println("Shows meeting criteria: ");
        System.out.println(shows);
    }

    protected void stream() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter show id to stream: ");
        int id = Integer.parseInt(sc.nextLine());
        this.service.stream(id);
    }

    protected void get() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter show id to stream: ");
        int id = Integer.parseInt(sc.nextLine());
        // A container object which may or may not contain a non-null value.
        // If a value is present, sPresent() will return true and get() will return the value.
        Optional<Show> show = this.service.getShow(id);
        if (show.isEmpty())
            System.out.println("Show not found");
        else
            System.out.println(show);
    }
}
