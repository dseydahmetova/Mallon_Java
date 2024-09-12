package DebuggingExercise;

import java.util.*;

public class MallonStreamingService implements MusicStreamingService {
    private Map<Integer, Song> songs;
    int nextSongId = 0;

    public MallonStreamingService() {
        this.songs = new HashMap<>();
    }
    @Override
    public Song getSong(int id) {
        return songs.get(id);
    }

    @Override
    public List<Song> getSongByArtist(String artist) {
        List<Song> matchingSongs = new ArrayList<>();
        for (int i = 1; i < songs.size(); i++) {
            if (songs.get(i).getArtist().equals(artist)) {
                matchingSongs.add(songs.get(i));
            }
        }
        return matchingSongs;
    }

    @Override
    public Optional<Song> getSongByTitle(String title) {
        for (int i = 1; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) {
                return Optional.of(songs.get(i));
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean addSong(String title, String artist, int length) {
        Song newSong = new Song(nextSongId++, title, artist, length);
        this.songs.put(newSong.getId(), newSong);
        return true;
    }

}
