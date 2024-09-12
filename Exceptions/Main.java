package Exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            int result = fib(-1);
            System.out.println("The result = " + result);
        } catch (ArithmeticException e) {
            System.err.println("ArithmeticException: " + e.getMessage());
        }

        try {
            int result = fib2(-1);
            System.out.println("The result = " + result);
        } catch (FibonacciException e) {
            System.err.println("FibonacciException: " + e.getMessage());
        }

        System.out.println(fibList(Arrays.asList(1, 5, 3, 2, 5, -3, -2, 1, -4)));
    }


    //task1
    public static int fib(int n) {
        if (n < 0) {
            throw new ArithmeticException("Can not accept negative numbers");
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }


    //task2
    public static int fib2(int n) throws FibonacciException {
        if (n < 0) {
            throw new FibonacciException(n);
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    //task4
    public static List<Integer> fibList(List<Integer> n_list) {
        List<Integer> result = new ArrayList<>();
        int errors = 0;
        for (int num : n_list) {
            try {
                result.add(fib2(num));
            } catch (FibonacciException e) {
                errors ++;
            }
        }
        System.err.println("Errors: " + errors);
        return result;
    }

    public static class FibonacciException extends RuntimeException {
        public FibonacciException(int num) {
            super("Tried to Fibonacci with n = " + num);
        }
    }
}

