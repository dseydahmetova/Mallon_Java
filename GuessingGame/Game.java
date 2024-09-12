package GuessingGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Please enter your name: ");
        Scanner readInput = new Scanner(System.in);
        String player = readInput.nextLine();
        Random rand = new Random();
        int number = rand.nextInt(50) + 1;
        System.out.println(number);
        startGame(number);

    }

    public static void startGame(int number) {
        int countGuess = 5;
        int score = 20;

        for (int i = 0; i < countGuess; i++) {
            System.out.println("Please guess the number between 1 and 50");
            Scanner input = new Scanner(System.in);
            int guess = input.nextInt();
            if (guess == number) {
                System.out.println("Good job! You won! Your score is " + score);
                break;
            } else if (guess > number && i != countGuess - 1) {
                System.out.println("The number is lower than " + guess);
                score -= 5;
            } else if (guess < number && i != countGuess - 1) {
                System.out.println("The number is greater than " + guess);
                score -= 5;
            } else {
                System.out.println("You have exhausted " + countGuess + " trials. The number was " + number);
            }
        }
    }
}





