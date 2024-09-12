package DebuggingExercise;

public class Song {
    private int id;
    private String title;

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", length (seconds)=" + length +
                '}';
    }

    public Song(int id, String title, String artist, int length) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.length = length;
    }

    private String artist;
    public int length;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getLength() {
        return length;
    }
}
