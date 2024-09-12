package DataStructure;

public class MyLinkedList<T> implements MyList<T>{
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }


    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }


    @Override
    public void add(T element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(element);
        }
        size++;

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current.data;
    }

    @Override
    public void remove(Object o) {
        if (head == null) {
            return;
        }
        if (head.data.equals(o)) {
            head = head.next;
            size--;
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.data.equals(o)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    @Override
    public int at(Object o) {
        Node current = head;
        for (int i = 0; current != null; i++) {
            if (current.data.equals(o)) {
                return i;
            }
            current = current.next;
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
}
