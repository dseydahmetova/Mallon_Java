package DataStructure;

public class MyStack <T> implements MyQueue<T>{
    private  MyArrayList<T> stack;

    public MyStack() {
        this.stack = new MyArrayList<>();
    }

    @Override
    public void put(T element) {
        stack.add(element);

    }

    @Override
    public T get() {
        if(stack.isEmpty()) {
            return null;
        }
        return stack.get(stack.getSize() - 1);
    }

    @Override
    public T get(int i) {
        return null;
    }


    @Override
    public T poll() {return null;
//        if (stack.isEmpty()) {
//            return null;
//        }
//        return stack.remove(stack.getSize() - 1);
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
