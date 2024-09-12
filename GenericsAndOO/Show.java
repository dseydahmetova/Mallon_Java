package GenericsAndOO;


import java.util.Arrays;

public class Show {
    private int id;
    private String name;
    private String[] tags;


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }

    public String getName() {
        return name;
    }

    public String[] getTags() {
        return tags;
    }

    public Show(int id, String name, String[] tags) {
        this.id = id;
        this.name = name;
        this.tags = tags;
    }
}
