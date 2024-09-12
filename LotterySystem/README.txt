Project: Programming Fundamentals
Lottery System
In a typical 6/49 game, each player chooses six distinct numbers from a range of 1–49. If the six numbers on a ticket match the numbers drawn by the lottery, the ticket holder is a jackpot winner—regardless of the order of the numbers.
The probability of this happening is 1 in 13,983,816

STEP 1: Over 18s only!
- In order to play the game, the user should be asked for their name and date of birth.
- You can ask for the year, month and day separately, or as a single string - it's up to you.
- Your program should validate the input (e.g., a date of 33/19/2056 is clearly not reasonable, what about 01/01/1900?).
- It should also validate that the person is over 18 in order to play the game.
- When checking ages, you can assume that the date that the game is played is 10th June 2024.

STEP 2: Pick numbers
- Allow the user to pick six numbers for their lottery ticket from the range 1-49.
- The user should only be able to pick each number once per game.
- They must pick exactly six numbers.

STEP 3: Lucky dip
- In addition to allowing users to pick their own numbers,
- offer the choice for the program to generate them a 'lucky dip', where the program picks the six random numbers for them for their ticket.
- The same rules apply: six numbers, from the range 1-49, and each number can be picked only once per game.

STEP 4: View the ticket
- Allow the user to see the ticket (i.e., the numbers they have selected).

STEP 5: Play the game
- When ready, the user should be able to run the lottery to see if they have won.

- The program should pick exactly six random numbers from the range 1-49, and these numbers should be compared against the ticket.
- A range of prizes are on offer:
// "\u00A3"  - sign £
1 or fewer matches, results in no prize.
2 correct numbers should get a prize of £1.
3 correct numbers should get a prize of £2.
4 correct numbers should get a price of £4.
5 correct numbers should get a price of £8.
6 correct numbers should win the jackpot.

STEP 6: Check the ticket
Provide a way for the user to check their ticket and see if they won, and how much they won!

STEP 7: Reset and replay
Provide an option to reset the game, and start over from the very beginning.

STEP 8: Extended functionality if time permits
If you complete all the tasks above, you could attempt one or more of the following to add extra features (these generally go from easier to harder):

- Allow the user to set the range of numbers available in the game, instead of being hard coded to 1-49.
- Allow the user to change the default prize amounts for 2, 3, 4 and 5 correct balls.
- Allow the user to change the number of numbers drawn and on a ticket (they must remain the same, e.g., both are currently 6, so both could become 7 or 8 or 5).
- Implement a 'bonus ball'; an extra ball that the user can pick on their ticket to increase (or decrease) their chances of winning. The bonus ball can be a duplicate of the main six numbers, so a ticket might be numbers: 2, 30, 31, 44, 48, 49 and a bonus ball of 31. Implement any logic you like for the bonus ball (e.g., it must be correct to win (decreasing the odds of winning), it means you only need 6/7 correct to win (potentially increasing the odds of winning), or anything other strategy you can imagine).
- Allow multi-ticket games, where more than one person can get a ticket, or where a person can get multiple tickets - as many as the like.
- Explore the Date API in Java and adjust your logic for over 18s to use the real date.