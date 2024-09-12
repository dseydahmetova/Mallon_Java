package hellojava;

import java.util.Scanner;

public class AgeChecker {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Scanner readInput = new Scanner(System.in);
            System.out.println("Please enter your age: ");

            // if the input is the word, check if it is equal to "EXIT"
            if (readInput.hasNextLine()) {
                String word = readInput.next();
                if (word.toLowerCase().equals("exit")) {
                    System.out.println("Goodbye!\n");
                    break;
                }

                // if the input is number, check if it is greater 18
                else {
                    int number = Integer.valueOf(word);

                    if (number >= 18) {
                        System.out.println("You are old enough.\n");
                    } else {
                        int x = 18 - number;
                        if (x == 1) {
                            System.out.println("You must be " + x + " year older to enter\n");
                        } else {
                            System.out.println("You must be " + x + " years older to enter\n");
                        }
                    }
                }
            }
        }
    }
}

