package DebuggingExercise;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TextStreamApplication extends StreamApplication {
    public TextStreamApplication(MusicStreamingService service) {
        super(service);
    }

    public void run() {
        while (mainMenu()) {
            System.out.println("---------------");
        }
    }

    protected boolean mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Command (searchTitle, searchArtist, get, exit): ");
        String command = sc.nextLine();
        if (command.equals("get")) {
            get();
        } else if (command.equals("searchTitle")) {
            searchTitle();

        } else if (command.equals("searchArtist")) {
            searchArtist();

        } else if (command.equals("exit")) {
            System.exit(0);
        }

        return true;
    }

    protected void get() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter song id to get: ");
        int id = Integer.parseInt(sc.nextLine());
        Song song = this.service.getSong(id);
        System.out.println(song);
    }

    protected void searchArtist() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter artist you wish to search: ");
        String artist = sc.nextLine();
        List<Song> songs = this.service.getSongByArtist(artist);
        if (!songs.isEmpty()) {
            System.out.println("Songs meeting criteria: ");
            System.out.println(songs);
        } else {
            System.out.println("Can not find the song");
        }
    }

    protected void searchTitle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter title you wish to search: ");
        String title = sc.nextLine();
        Optional<Song> song = this.service.getSongByTitle(title);
        if (song.isPresent()) {
            System.out.println("Song found: ");
            System.out.println(song);
        } else {
            System.out.println("Can not find the song");
        }

    }
}
