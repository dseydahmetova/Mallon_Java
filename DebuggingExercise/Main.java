package DebuggingExercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicStreamingService service = new MallonStreamingService();
        populate(service);
        StreamApplication app = new TextStreamApplication(service);
        app.run();




    }

    public static void populate(MusicStreamingService service) {
        service.addSong("Evidemment","La Zarra",181);
        service.addSong("Cha Cha Cha","Käärijä",175);
        service.addSong("Queen of Kings","Alessandra Mele",160);
        service.addSong("Carpe Diem","Joker Out",165);
        service.addSong("Promise", "Voyager",183);
    }
}