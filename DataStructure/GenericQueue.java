package DataStructure;

public class GenericQueue<T> implements MyQueue<T>{
    private MyLinkedList<T> list;

    public GenericQueue(){
        this.list = new MyLinkedList<>();
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void put(T element) {
        list.add(element);

    }

    @Override
    public T get() {
        return list.get(0);
    }

    @Override
    public T get(int i) {
        return list.get(i);
    }

    @Override
    public T poll() {
        T removedElement = list.get(0);
        list.remove(0);
        return removedElement;
    }
}
