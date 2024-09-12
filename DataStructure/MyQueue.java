package DataStructure;

public interface MyQueue <T> extends MyCollection<T>{
    void put(T element);

    T get();

    T get(int i);

    T poll();

}
