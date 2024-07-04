package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Please select a game mode:");
        System.out.println("1: Guess the number between 1 and 100");
        System.out.println("2: Avoid the specified number at all costs");
        System.out.println("You will receive hints to help you narrow down your guess.");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println("Enter your choice [1/2]: ");
            try {
                choice = scanner.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please select 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please select 1 or 2.");
                scanner.next();
            }
        }

        if (choice == 1) {
            System.out.println("You have selected: Guess the number between 1 and 100.");
            System.out.println("Let's see how many attempts you need to guess the correct number!");

            GuessNumberGameV3 game = new GuessNumberGameV3();
            while (!game.isMatchTarget()) {
                game.makeAGuess(scanner);
            }
            System.out.println("Congratulations! You guessed the correct number in " + game.getRound() + " attempts.");

        } else {
            System.out.println("You have selected: Avoid the specified number at all costs!");
            System.out.println("Let's see how many attempts you need to guess the correct number!");
            GuessNumberGameV2 game = new GuessNumberGameV2();
            while (!game.isMatchTarget()) {
                game.makeAGuess(scanner);
            }
            System.out.println("Unlucky! you just hit the number at round " + game.getRound() + "!");
        }
    }
}