package hellojava;

public class PrimeNum {

        public static void main(String[] args) {
            for (int cand = 2; cand <=100; cand ++) {
                boolean isPrime = true;
                for (int test = 2; test <=100; test ++) {
                    if ((cand % 2 == 0) && (cand != test)) {
                        isPrime = false;
                    }
                }


                if (isPrime)
                {
                    System.out.println(cand);
                }

            }
        }
    }

