package GenericsAndOO;

public class Main {
    public static void main(String[] args) {
        //
        MalflixService service = new LocalMalflixService();
        populate(service);
        MalflixApplication app = new TextMalflixApplication(service);
        app.run();
    }

    public static void populate(MalflixService service) {
        service.createShow("Suits", new String[]{"office", "drama", "law"});
        service.createShow("Gilmore Girls", new String[]{"comedy", "sitcom"});
        service.createShow("The Empress", new String[]{"drama", "period"});
        service.createShow("Friends", new String[]{"comedy", "nyc"});
        service.createShow("The Queen's Gambit", new String[]{"drama", "chess"});
        service.createShow("The Good Place", new String[]{"comedy", "drama"});
    }
}
