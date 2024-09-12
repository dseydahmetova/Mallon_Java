package DebuggingExercise;

import java.util.List;
import java.util.Optional;

public interface MusicStreamingService {
    Song getSong(int id);

    List<Song> getSongByArtist(String artist);

    Optional<Song> getSongByTitle(String title);

    boolean addSong(String title, String artist, int length);
}
