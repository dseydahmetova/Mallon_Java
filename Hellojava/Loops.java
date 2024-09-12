package hellojava;

public class Loops {
    public static void main(String[] args) {
        int sum = 0, formula = 0;
        int n, i;

        for (n = 2; n <= 100; n++) {
//            sum = 0;
//            for (i = 1; i <= n; i++) {
//                sum += i;
//            }
            sum = sumTo(n);
            formula = n * (n + 1) / 2;

            System.out.println("n = " + n);
            System.out.println("sum = " + sum);
            System.out.println("formula = " + formula);

            if (sum == formula) {
                System.out.println("Sum and Formula are equal\n");
            } else System.out.println("Sum and Formula are NOT equal\n");
        }
    }

    public static int sumTo(int n) {
        int i = 1;
        int sum = 0;

        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }
}

