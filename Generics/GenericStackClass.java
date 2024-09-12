package Generics;

import java.util.LinkedList;
import java.util.List;

public class GenericStackClass<T extends Comparable<T>> {
    private List<T> stack;

    public GenericStackClass(){
        this.stack =new LinkedList<>();
    }

    // put onto stack
    public void push(T item) {
        stack.add(item);
    }

    // return top of stack
    public T top() {
        return stack.get(size()-1);
    }

    // pop and discard top of stack
    public T pop() {
       return stack.remove(stack.size() - 1);
    }

    // number of elements in stack
   public int size() {
        return stack.size();
    }

}