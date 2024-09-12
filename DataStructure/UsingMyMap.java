package DataStructure;

public class UsingMyMap<K, V> implements MyMap<K, V> {
    private MyList<K> listOfKeys;
    private MyList<V> listOfValues;

    public UsingMyMap(){
        this.listOfKeys = new MyArrayList<>();
        this.listOfValues = new MyArrayList<>();

    }

    @Override
    public int getSize() {
        return listOfKeys.getSize();
    }

    @Override
    public boolean isEmpty() {
        return listOfKeys.isEmpty();
    }

    @Override
    public void insert(K key, V value) {
        int index = listOfKeys.at(key);
        if (index == -1) {
            listOfKeys.add(key);
            listOfValues.add(value);
        } else {
            listOfValues.remove(index);
            listOfValues.add(value);
        }
    }

    @Override
    public V get(K key) {
        int index = listOfKeys.at(key);
        if (index == -1) {
            return null;
        }
        return listOfValues.get(index);
    }

    @Override
    public MyList<K> getValues() {
        return (MyList<K>) listOfValues;
    }

    @Override
    public MyList<V> getKeys() {
        return (MyList<V>) listOfKeys;
    }
}
