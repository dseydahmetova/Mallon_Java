package hellojava;

public class Factorial {
    public static void main(String[] args) {
        int toFind = 6;
        int result = 1;

        if (toFind < 0) {
            System.out.println("Error!");
        } else {
            while (toFind != 0) {
                if (toFind > 0) {
                    result *= toFind;
                    toFind--;
                }
            }
            System.out.println(result);
        }
    }
}


