package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumberGame {
    private int target;
    private boolean mathchTarget;
    private int userGuess;

    public GuessNumberGame() {
        this.target = (int) Math.round(Math.random()*99+1);
        this.mathchTarget = false;
        this.userGuess = -1;
    }

    public int getTarget() {
        return target;
    }

    public boolean isMathchTarget() {
        return mathchTarget;
    }

    public void setMathchTarget(boolean mathchTarget) {
        this.mathchTarget = mathchTarget;
    }

    public int getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
    }

    public boolean makeAGuess(Scanner scanner){
        System.out.println("Please input a number");
        try {
            int userInput = scanner.nextInt();
            checkValue(userInput);
            return mathchTarget;
        } catch (InputMismatchException e) {
            System.out.println("No string allowed, only Integer!");
            scanner.next();
            return mathchTarget;
        }
    }

    private boolean checkValue(int userInput) {
        try{
            if (userInput > 100 || userInput < 0){
                throw new IndexOutOfBoundsException();
            }
            checkResult(userInput);
            return mathchTarget;
        } catch (IndexOutOfBoundsException e){
            System.out.println("Integer must be between 0 - 100");
            return mathchTarget;
        }
    }

    private boolean checkResult(int userInput) {
        if (userInput == getTarget()){
            setMathchTarget(true);
        } else {
            giveSomeHints();
        }
        return mathchTarget;
    }


    private void giveSomeHints() {
        if (getUserGuess() > getTarget()){
            System.out.println("Guess lower!");
        } else {
            System.out.println("Guess higher!");
        }
    }

}
