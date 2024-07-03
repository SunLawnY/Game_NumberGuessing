package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to this Mini Project, Guess Number Game!");
        System.out.println("Let see if you can guess the number between 1 to 100!");

        GuessNumberGame game = new GuessNumberGame();
        Scanner scanner = new Scanner(System.in);
        while(!game.isMathchTarget()) {
            game.makeAGuess(scanner);
        }
        System.out.println("Complete!");
    }
}