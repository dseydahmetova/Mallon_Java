package GenericsAndOO;

import java.util.Collection;
import java.util.Optional;

public interface MalflixService {
    Show createShow(String name, String[] tags);

    Optional<Show> getShow(int id);

    Collection<Show> getShows(String tag);

    default void stream(int id) {
        System.err.println("Streaming " + id + " not currently supported.");
    }

    Collection<Show> getShowsByName(String name);
}
