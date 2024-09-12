package DataStructure;

import java.util.List;

public class MyArrayList<T> implements MyList<T> {
    private Object[] myArray;
    private int size;

    public MyArrayList() {
        this.myArray = new Object[10];
        size = 0;
    }

    @Override
    public void add(T element) {
        if (size == myArray.length) {
            resize();
        }
        myArray[size++] = element;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) myArray[index];
    }

    @Override
    public void remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (myArray[i].equals(o)) {
                remove(i);
                return;
            }
        }
    }


    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
           myArray[i] = myArray[i + 1];
        }
        myArray[--size] = null;
    }

    @Override
    public int at(Object o) {
        for (int i = 0; i < size; i++) {
            if (myArray[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[myArray.length * 2];
        System.arraycopy(myArray, 0, newArray, 0, myArray.length);
        myArray = newArray;
    }


}
