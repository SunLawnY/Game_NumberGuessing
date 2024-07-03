package org.example;

import java.util.Scanner;

public class GuessNumberGame {
    private int target;
    private boolean mathchTarget;
    private int userGuess;

    public GuessNumberGame() {
        this.target = (int) Math.round(Math.random()*100);
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

    public void makeAGuess(Scanner scanner){
        System.out.println("Please input a number");
        setUserGuess(scanner.nextInt());
        if (getUserGuess() == getTarget()){
            setMathchTarget(true);
        } else {
            giveSomeHints();
        }
    }

    private void giveSomeHints() {
        if (getUserGuess() > getTarget()){
            System.out.println("Guess lower!");
        } else {
            System.out.println("Guess higher!");
        }
    }

}
