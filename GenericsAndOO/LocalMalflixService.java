package GenericsAndOO;


import java.util.*;
import java.util.stream.Collectors;

public class LocalMalflixService implements MalflixService {
    List<Show> shows;
    public LocalMalflixService() {
        this.shows = new ArrayList<>();
    }
    @Override
    public Show createShow(String name, String[] tags) {
        Show newShow = new Show(this.shows.size(), name, tags);
        this.shows.add(newShow);
        return newShow;
    }

    @Override
    public Optional<Show> getShow(int id) {
        if (id < this.shows.size()) { return Optional.ofNullable(this.shows.get(id)); } else { return Optional.empty(); }
    }

    @Override
    public Collection<Show> getShows(String tag) {
        return this.shows.stream().filter((Show s) -> (Arrays.asList(s.getTags()).contains(tag))).collect(Collectors.toList());
    }

    @Override
    public Collection<Show> getShowsByName(String name) {
        return this.shows.stream().filter((Show s) -> s.getName().equals(name)).collect(Collectors.toList());
    }
}
