package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumberGame {
    private int target;
    private boolean matchTarget;
    private int userGuess;
    private int round;
    private String lastErrorMessage;

    public GuessNumberGame() {
        //Make sure it is from 1 - 100 not 0 - 100
        this.target = (int) Math.round(Math.random()*99+1);
        this.matchTarget = false;
        this.userGuess = -1;
        this.round = 0;
        this.lastErrorMessage = "";
    }

    public int getRound() {
        return round;
    }

    public void incrementRound() {
        this.round++;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public boolean isMatchTarget() {
        return matchTarget;
    }

    public void setMatchTarget(boolean matchTarget) {
        this.matchTarget = matchTarget;
    }

    public int getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(int userGuess) {
        this.userGuess = userGuess;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public void setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
    }

    public void makeAGuess(Scanner scanner){
        System.out.println("Please input a number between 1 and 100:");
        incrementRound();
        try {
            setUserGuess(scanner.nextInt());
            if (userGuess < 0 || userGuess > 100){
                throw new IndexOutOfBoundsException();
            }
            checkResult(userGuess);
        } catch (InputMismatchException e) {
            lastErrorMessage = "Only integers are allowed.";
            System.out.println(lastErrorMessage);
            scanner.next();
        } catch (IndexOutOfBoundsException e){
            lastErrorMessage = "Number must be between 1 and 100!";
            System.out.println(lastErrorMessage);
        }
    }

    private void checkResult(int userInput) {
        if (userInput == getTarget()){
            setMatchTarget(true);
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
