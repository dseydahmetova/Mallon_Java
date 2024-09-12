package Generics;

import java.util.*;

public class Generics {
    public static void main(String[] args) {
        List<Integer> intsList = Arrays.asList(1, 5, 7, 2, 3);
        List<String> strsList = Arrays.asList("Java", "World", "Hello");
        System.out.println(reverse(intsList)); // Expected: [3, 2, 7, 5, 1]
        System.out.println(reverse(strsList)); // Expected: ["Hello", "World", "Java"]
    }

    public static <T> List<T> reverse(List<T> myList) {
        // Arraylist for storing reversed elements
        ArrayList<T> revArrayList = new ArrayList<T>();
        for (int i = myList.size() - 1; i >= 0; i--) {
            // Append the elements in reverse order
            revArrayList.add(myList.get(i));
        }
        return revArrayList;
    }
}
