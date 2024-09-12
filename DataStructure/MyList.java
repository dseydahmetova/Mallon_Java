package DataStructure;

public interface MyList <T> extends MyCollection<T>{
    void add(T element);

    T get(int index);

    void remove(Object o);

    void remove(int index);

    int at(Object o);
}
