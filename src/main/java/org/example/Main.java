package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to this Mini Project, Guess Number Game!");

        System.out.println("Let's see how many rounds you need to guess the number between 1 and 100!");

        GuessNumberGameV3 game = new GuessNumberGameV3();
        System.out.println(game.getTarget());
        Scanner scanner = new Scanner(System.in);

        while(!game.isMatchTarget()) {
            game.makeAGuess(scanner);
        }
        System.out.println("Nice one! You guessed the right number in " + game.getRound() + " rounds.");
    }
}