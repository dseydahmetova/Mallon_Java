package Generics;

public class GenericsStack {
    public static void main(String[] args) {
        GenericStackClass<String> stack = new GenericStackClass<String>();
        stack.push("World");
        stack.push("Hello");

        System.out.println("---------------Exercise 2----------------------"); // Expected: 7

        System.out.println(stack.top()); // Expected: "Hello"
        stack.pop();
        System.out.println(stack.top()); // Expected: "World"
        System.out.println(stack.size()); // Expected: 1

        System.out.println("---------------Exercise 3----------------------"); // Expected: 7

        GenericStackClass<Integer> intStack = new GenericStackClass<Integer>();
        intStack.push(5);
        intStack.push(3);
        intStack.push(7);
        System.out.println(emptyAndGetGreatest(intStack)); // Expected: 7
        System.out.println(intStack.size()); // Expected: 0
    }

    public static <T extends Comparable<T>> T emptyAndGetGreatest(GenericStackClass<T> stack) {
        if (stack.size() == 0) {
            System.out.println("Stack is empty");
        }
        T max = stack.pop();

        while (stack.size() != 0) {
            T current = stack.pop();
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }

        return max;
    }
}
