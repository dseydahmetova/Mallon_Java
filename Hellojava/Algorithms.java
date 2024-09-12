package hellojava;

import java.util.*;

public class Algorithms {
    public static void main(String[] args) {
        System.out.println("Search the target element ");
        System.out.println("{1, 3, 5, 7, 9}, 4 " + search(new int[]{1, 3, 5, 7, 9}, 4));  // should return false
        System.out.println("{1, 3, 1, 5, 3}, 3 " + search(new int[]{1, 3, 1, 5, 3}, 3)); // should return true
        System.out.println("new int[5], 0 " + search(new int[5], 0) + "\n\n");  //   should return true

        System.out.println("Sort in ascending order ");
        System.out.println("{1, 5, 3} " + Arrays.toString(sort(new int[]{1, 5, 3})));  // should print [1, 3, 5]
        System.out.println("{1, 2, 3, 4, 5, 6} " + Arrays.toString(sort(new int[]{1, 2, 3, 4, 5, 6}))); // should return [1, 2, 3, 4, 5, 6]
        System.out.println("{1, 5, 1, 3, 7, 9, 1} " + Arrays.toString(sort(new int[]{1, 5, 1, 3, 7, 9, 1})) + "\n\n");  //   should return [1, 5, 1, 3, 7, 9, 1]

        System.out.println("Binary search ");
        System.out.println("{1, 3, 5, 7, 9}, 1 " + binarySearch(new int[]{1, 3, 5, 7, 9}, 1));  // should return true
        System.out.println("{1, 3, 5, 7, 9}, 15 " + binarySearch(new int[]{1, 3, 5, 7, 9}, 15));  // should return false
        System.out.println("{1, 5, 8, 11, 38, 91}, 38 " + binarySearch(new int[]{1, 5, 8, 11, 38, 91}, 38)); // should return true
        System.out.println("{1, 5, 8, 11, 38, 91, 302}, 8 " + binarySearch(new int[]{1, 5, 8, 11, 38, 91, 302}, 8)); // should return true
        System.out.println("new int[5], 0 " + binarySearch(new int[5], 0) + "\n\n");  //   should return true

    }

    // search method
    public static boolean search(int[] toSearch, int target) {
        boolean result = false;
        for (int i = 0; i < toSearch.length; i++) {
            if (toSearch[i] == target) {
                result = true;
            }
        }
        return result;
    }


    // toSort method
    public static int[] sort(int[] toSort) {
        for (int i = 0; i < toSort.length; i++) {
            for (int j = 0; j < toSort.length; j++) {
                int temp = 0;
                if (toSort[i] < toSort[j]) {
                    temp = toSort[i];
                    toSort[i] = toSort[j];
                    toSort[j] = temp;
                }
            }
        }
        return toSort;
    }

    // binarySearch method
    public static boolean binarySearch(int[] toSearch, int target) {
        int start = 0;
        int move = 0;
        int mid = toSearch.length / 2;

        for (int index = mid; true; ) {
            if (toSearch[index] == target) {
                return true;
            } else if (toSearch[index] > target) {
                // take left
                move = (index - start) / 2;
                index = move;
                if (move < 0) {
                    return false;
                }
            } else {
                // take right
                start = index;
                if (start < mid) {
                    move = (mid - index) / 2;
                } else {
                    move = (toSearch.length - index) / 2;
                }
                index = start + move;
                if (move < 1) {
                    return false;
                }
            }
        }
    }
}
