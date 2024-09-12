// Project: Programming Fundamentals

package LotterySystem;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class LotteryGame {
    public static void main(String[] args) {
        // the user is asked for their name.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        LocalDate currentDate = LocalDate.now();

        //the game will continue until the user exits
        boolean playGame = true;

        int age = -1;
        int choice;
        int arrSize = 6;
        int[] arr = new int[arrSize];
        int[] winNumbers = new int[arrSize];

        // the user is asked for their date of birth in format dd/MM/yyyy to calculate the age
        while (age == -1) {
            System.out.println(name + ", please enter your date of birth (dd/MM/yyyy):");
            String dateOfBirth = scanner.nextLine();

            // step 1: Over 18s only!
            // Check the age of the player after they input it.
            age = calculateAge(dateOfBirth);

            if (age == -1) {
                System.out.println("Please enter a valid date.");
            }
        }

        System.out.println("Your age: " + age);


        // If they are over 18, offer the player to choose the lottery numbers manually or generate by program.
        // Otherwise, exit the game

        if (age < 18) {
            System.out.println("You need to be at least 18 years old to play the lottery.");
        } else {
            // the date that the game is in format ex: 10th June 2024
            System.out.println("The date of the game is: " + currentDate.getMonth() + " " + currentDate.getDayOfMonth() + ", " + currentDate.getYear());


            while (playGame) {

                // resetting the user's and winning arrays and assigning 0
                arr = resetTheGame(arr);
                winNumbers = resetTheGame(winNumbers);

                //checking the function for reset
//                System.out.println("arr:" + Arrays.toString(arr));
//                System.out.println("arr:" + Arrays.toString(winNumbers));

                System.out.println("Please enter how would you like to pick the lottery numbers by choosing the corresponding number:");
                System.out.println("1. Enter it manually\n2. Lucky dip (randomly generated)");
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();

                // assigned numbers manually, to check if the priceCheck function works
                // winNumbers = new int[]{5, 10, 48, 36, 27, 12};

                winNumbers = luckyDip(winNumbers);

                switch (choice) {
                    case 1:

                        // user manually enters the numbers
                        arr = pickYourNumbers(arr);
                        break;

                    case 2:
                        //program randomly generates the numbers for the user
                        arr = luckyDip(arr);
                        break;

                    default:
                        System.out.println("Try again");
                        break;
                }


                // step 4 View the ticket
                System.out.println("Your lottery numbers: " + Arrays.toString(arr));

                // step 5 Play the game
                // users numbers should be compared against the winning numbers.
                String result = priceCheck(arr, winNumbers);
                System.out.println("These are winning numbers: " + Arrays.toString(winNumbers));

                // step 6: Check the ticket
                // Provided a way for the user to check their ticket and see if they won, and how much they won
                System.out.println("You won: " + result);

                // step 7: Reset and replay
                System.out.println("Would you like to play again?");
                System.out.println("1. Yes\n2. Exit");
                int playChoice = scanner.nextInt();
                if (playChoice != 1) {
                    playGame = false;
                }
            }
            System.out.println("Goodbye, " + name + "!");
        }
    }

    // step 2: Pick numbers
    // user picks six numbers from the range 1-49, each number once per game.
    public static int[] pickYourNumbers(int[] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose 6 numbers from the range 1-49.");

        for (int i = 0; i < arr.length; i++) {
            boolean isNumberInRange = false;

            while (!isNumberInRange) {
                System.out.println("Enter lottery number " + (i + 1));
                int number = scanner.nextInt();
                if (checkTheRange(number)) {
                    if (checkDuplicateNum(arr, number)) {
                        System.out.println("Number is duplicate. Please try again.");
                    } else {
                        arr[i] = number;
                        isNumberInRange = true;
                    }
                } else {
                    System.out.println("Out of range. Please try again.");
                }
            }
        }
        return arr;
    }

    // step3: Lucky dip
// user picks 6 random numbers by program.
    public static int[] luckyDip(int[] arr) {
        Random rand = new Random();
        int min = 1;
        int max = 49;
        for (int i = 0; i < arr.length; i++) {
            //generats random number
            int number = rand.nextInt(max - min) + min;            //checks if the number is already in array
            while (checkDuplicateNum(arr, number)) {
                //if duplicate found, generate rand number again
                number = rand.nextInt(max - min) + min;            }
            //if no duplicates found, adds the number to an array
            arr[i] = number;
        }
        return arr;
    }

    // calculate the age of the user
    public static int calculateAge(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate birthDate = LocalDate.parse(dateOfBirth, formatter);
            LocalDate currentDate = LocalDate.now();

            if (birthDate.isAfter(currentDate)) {
                System.out.println("Date of birth cannot be in the future.");
                return -1;
            }

            Period age = Period.between(birthDate, currentDate);
            return age.getYears();
        } catch (DateTimeParseException e) {
            return -1;
        }
    }

    // checks if entered number is between 1 and 49
    public static boolean checkTheRange(int arrElement) {
        if (arrElement >= 1 && arrElement <= 49) {
            return true;
        } else {
            return false;
        }
    }

    // checks if array already has the same number
    public static boolean checkDuplicateNum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                // duplicate found
                return true;
            }
        }
        return false;
    }

    // count how many matches and winning price
    public static String priceCheck(int[] arr, int[] winNum) {
        int matchCount = 0;
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < winNum.length; j++) {
                if (arr[i] == winNum[j]) {
                    matchCount++;
                }
            }
        }


// Alt depressed and numeric keyboard 0163 for £
        if (matchCount <= 1) {
            result = "No Prize";
        }
        if (matchCount == 2) {
            result = "£1";
        }
        if (matchCount == 3) {
            result = "£2";
        }
        if (matchCount == 4) {
            result = "£4";
        }
        if (matchCount == 5) {
            result = "£8";
        }
        if (matchCount == 6) {
            result = "JACKPOT";
        }
//        System.out.println("matches: " + matchCount);

        return result;
    }

    //reset the array by assigning 0
    public static int[] resetTheGame(int[] arr) {
        arr = new int[arr.length];
        return arr;
    }
}