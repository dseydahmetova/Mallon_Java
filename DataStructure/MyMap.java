package DataStructure;

public interface MyMap <K, V> extends MyCollection<V>{
    void insert(K key, V value);

    V get(K key);

 MyList<K> getValues();

    MyList<V> getKeys();

    boolean equals(Object o);

    int hashCode();

}
