package DebuggingExercise;

abstract public class StreamApplication {
    protected MusicStreamingService service;
    public StreamApplication(MusicStreamingService service) {
        this.service = service;
    }

    abstract public void run();
}
