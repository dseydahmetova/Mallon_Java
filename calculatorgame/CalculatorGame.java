package calculatorgame;

import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class CalculatorGame {

    public static void main(String[] args) {
        // In main method, create an instance of Player using your name and age,
        //and then print that Player's score to the terminal.

        int arrSize = 5;
//        //Creating an array to keep the scores
//        int scoreArr[] = new int[arrSize];

        Player player1 = createPlayer();
        int score = 0;

        // Declaring the ArrayList to replace the array
        ArrayList<Integer> scoreArray = new ArrayList<Integer>();

        int choice;

        // The user is given option to choose the quiz type
        do {
            System.out.println("Please enter the quiz type by choosing the corresponding number:");
            System.out.println("1. Calculate remainder \n2. Add numbers \n3. Calculate the value of first number raised to the power of the second number.\n4. True AND false\n5. True/False Quiz\n6. Exit");            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    score = moduloQuiz(arrSize);
                    break;

                case 2:
                    score = addQuiz(arrSize);
                    break;
                case 3:
                    score = powQuiz(arrSize);
                    break;

                case 4:
                    score = trueFalseQuiz(arrSize);
                    break;

                case 5:
                    score = trueFalseQuiz2();
                    break;

                case 6:
                    System.out.println("Goodbye, " + player1.name() + "!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Try again");
                    break;
            }

            // record the score of the user
            HighScore highScore = new HighScore(player1, score);
            System.out.println("\nThe player " + player1.name() + " has a score " + highScore.score());

            // push the scores from the quiz to an array
            // scoreArr = addScoreArray(arrSize, scoreArr, score);
// int[] maxScore = findMaxScoreInArray(arrSize, scoreArr);
// System.out.println("Total score list " + Arrays.toString(scoreArr) + "\n");

            // push the scores from the quiz to an arrayList
            scoreArray.add(score);
            int maxScore = findMaxScoreInArray(scoreArray);

            System.out.println("Total score list in arraylist " + scoreArray + "\n");
            System.out.println("Score to beat " + maxScore + "\n");

//            System.out.println("Score to beat: " + maxScore).replace("[", "").replace("]", "") + "\n\n");

        }

        // prompt the user to choose the next quiz type until they decide to exit by entering the number 5
        while (choice != 6);

    }

    //  Create a method called createPlayer to create a player with their name and age using record
    public static Player createPlayer() {
        Scanner readInput = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        String name = readInput.nextLine();

        System.out.println("Please enter your age: ");
        int age = readInput.nextInt();
        Player playerInfo = new Player(name, age);

        return playerInfo;
    }

    // Create a method called addQuestion, that compares the sum of the numbers with the user's answer
    public static boolean addQuestion(int a, int b) {
        Scanner readInput = new Scanner(System.in);

        System.out.println("Please enter the answer of " + a + " + " + b);
        int sum = readInput.nextInt();
        if (sum == a + b) {
            return true;
        } else return false;
    }

    // Create a method called moduloQuestion, that compares the modulo of the numbers with the user's answer
    public static boolean moduloQuestion(int a, int b) {
        Scanner readInput = new Scanner(System.in);

        System.out.println("Please enter the answer of " + a + " % " + b);
        int modulo = readInput.nextInt();
        if (modulo == a % b) {
            return true;
        } else return false;
    }

    // Create a method called powQuestion, that compares the pow of the numbers with the user's answer
    public static boolean powQuestion(int a, int b) {
        Scanner readInput = new Scanner(System.in);

        System.out.println("Please raise the base = " + a + " to the power = " + b);
        int pow = readInput.nextInt();
        if (pow == Math.pow(a, b)) {
            return true;
        } else return false;
    }

    // a method called trueFalseQuestion, that compares the boolean value with the user's answer
    public static boolean trueFalseQuestion(boolean a, boolean b) {
        Scanner readInput = new Scanner(System.in);
        System.out.println(a + " AND " + b);
        String trueFalse = readInput.nextLine().toLowerCase();

        while (!(trueFalse.equals("true") || trueFalse.equals("false"))) {
            System.out.println("Answer not recognised. Please try again.");
            trueFalseQuestion(a, b);
            break;
        }

        String answer = String.valueOf(a && b);
        if (trueFalse.equals(answer)) {
            return true;
        } else return false;
    }

    // another option of true false quiz
    public static boolean trueFalseQuestion2(String question, String answer) {
        Scanner readInput = new Scanner(System.in);
        System.out.println(question);
        String trueFalse = readInput.nextLine().toLowerCase();
        while (!trueFalse.equals("true") && !trueFalse.equals("false")) {
            System.out.println("Answer not recognised. Please try again.");
            trueFalseQuestion2(question, answer);
            break;
        }

        if (trueFalse.equals(answer)) {
            return true;
        } else return false;
    }

    // Create a method called addQuiz, that generates random 2 numbers and calls add method
    // if the user answered correct, the score increments to 1
    public static int addQuiz(int length) {
        int score = 0;

        for (int i = 0; i < length; i++) {
            Random rand = new Random();
            int rand_int1 = rand.nextInt(100);
            int rand_int2 = rand.nextInt(100);
            boolean answer = CalculatorGame.addQuestion(rand_int1, rand_int2);
            if (answer == true) {
                score++;
            }
        }
        return score;
    }

    // Create a moduloQuiz method, that produces questions that have the player calculate the remainder of the division
    // if the user answered correct, the score increments to 1
    public static int moduloQuiz(int length) {
        int score = 0;

        for (int i = 0; i < length; i++) {
            int rand_int1 = (int) (Math.random() * 100) + 1;
            int rand_int2 = (int) (Math.random() * 100) + 1;
            boolean answer = CalculatorGame.moduloQuestion(rand_int1, rand_int2);
            if (answer == true) {
                score++;
            }
        }
        return score;
    }

    // Create a powQuiz method, that produces questions that have the player calculate number raise to the power of some other number
    // if the user answered correct, the score increments to 1
    public static int powQuiz(int length) {
        int score = 0;

        for (int i = 0; i < length; i++) {
            int rand_int1 = (int) (Math.random() * 10) + 1;
            int rand_int2 = (int) (Math.random() * 10) + 1;
            boolean answer = CalculatorGame.powQuestion(rand_int1, rand_int2);
            if (answer == true) {
                score++;
            }
        }
        return score;
    }

    // True AND False quiz
    public static int trueFalseQuiz(int length) {
        int score = 0;
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            boolean rand_boolean1 = random.nextBoolean();
            boolean rand_boolean2 = random.nextBoolean();
            boolean answer = CalculatorGame.trueFalseQuestion(rand_boolean1, rand_boolean2);
            if (answer == true) {
                score++;
            }
        }
        return score;
    }

    // Alternative option of creating the quiz questions
    public static int trueFalseQuiz2() {
        int score = 0;
        String[][] quiz = {
                {"Question 1: A googol is bigger than a billion", "true"},
                {"Question 2: 29 + 38 = 57", "false"},
                {"Question 3: -4 is a natural number", "false"},
                {"Question 4: A convex shape curves outwards", "true"},
                {"Question 5: -2 is an integer", "true"}
        };

        for (int i = 0; i < quiz.length; i++) {
            String question = quiz[i][0];
            String answer = quiz[i][1];
            boolean userAnswer = CalculatorGame.trueFalseQuestion2(question, answer);
            if (userAnswer == true) {
                score++;
            }
        }
        return score;
    }

    // Function to add score in arr
//    public static int[] addScoreArray(int n, int arr[], int score) {
//        int i;
//        // insert the score to an array if the element is 0 and quit
//        for (i = 0; i < n; i++)
//            if (arr[i] == 0) {
//                arr[i] = score;
//                break;
//            }
//        return arr;
//    }


    //     Function to find max element in arr
    public static int findMaxScoreInArray(ArrayList<Integer> list) {
        int i;
        int max = list.get(0);
        for (i = 1; i < list.size(); i++)
            if (list.get(i) > max) {
                max = list.get(i);
            }
        return max;
    }
}


// Create a record called Player, which has two fields: the player's name and their age.
record Player(String name, int age) {

}

// Create a second record called HighScore, with two fields. This record type should logically connect a player and their score, stored as an integer. Create yourself a HighScore, using the Player you made earlier. Print that HighScore to the terminal.
record HighScore(Player player, int score) {

}