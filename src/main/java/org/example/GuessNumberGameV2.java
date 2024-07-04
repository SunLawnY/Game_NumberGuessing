package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumberGameV2 {
    private int target;
    private boolean matchTarget;
    private int userGuess;
    private int round;
    private String lastErrorMessage;
    private int upperBound;
    private int lowerBound;

    public GuessNumberGameV2() {
        //Make sure it is from 1 - 100 not 0 - 100
        this.target = (int) Math.round(Math.random()*99+1);
        this.matchTarget = false;
        this.userGuess = -1;
        this.round = 0;
        this.lastErrorMessage = "";
        this.upperBound = 100;
        this.lowerBound = 1;
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

    public int getRound() {
        return round;
    }

    public void incrementRound() {
        this.round++;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public void setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public void makeAGuess(Scanner scanner){
        System.out.printf("Range between %d and %d:%n", lowerBound, upperBound);
        try {
            setUserGuess(scanner.nextInt());
            if (userGuess < lowerBound || userGuess > upperBound){
                throw new IndexOutOfBoundsException();
            }
            incrementRound();
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
            boundaryConstring();
        }
    }


    private void boundaryConstring() {
        if (getUserGuess() > getTarget()){
            setUpperBound(getUserGuess());
        } else {
            setLowerBound(getUserGuess());
        }
    }
}

