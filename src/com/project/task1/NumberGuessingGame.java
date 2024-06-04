package com.project.task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            
            System.out.println("I have generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("Can you guess what it is?");
            
            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess < numberToGuess) {
                    System.out.println("The number is higher than " + userGuess + ".");
                } else if (userGuess > numberToGuess) {
                    System.out.println("The number is lower than " + userGuess + ".");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    score += (maxAttempts - attempts + 1); // Add points to the score
                }
            }
            
            if (!hasGuessedCorrectly) {
                System.out.println("You've used all your attempts. The number was " + numberToGuess + ".");
            }
            
            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
