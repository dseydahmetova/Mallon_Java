package GenericsAndOO;


abstract public class MalflixApplication {
    protected MalflixService service;
    public MalflixApplication(MalflixService service) {
        this.service = service;
    }

    abstract void run();
}
