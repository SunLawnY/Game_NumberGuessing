package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GuessNumberGameV2Test {
    @Test
    @DisplayName("Valid Input")
    void testGame(){
        GuessNumberGameV2 game = new GuessNumberGameV2();
        game.setTarget(50);
        Scanner scanner = new Scanner("51");
        game.makeAGuess(scanner);
        assertEquals(51, game.getUserGuess());
        assertEquals(1,game.getRound());
        assertFalse(game.isMatchTarget());
        assertEquals(51, game.getUpperBound());
        assertEquals(1, game.getLowerBound());
    }

    @Test
    @DisplayName("Test >100 input")
    void testIndexOutOfBounds_HighNumber() {
        GuessNumberGameV2 game = new GuessNumberGameV2();
        game.setTarget(50);
        Scanner scanner = new Scanner("150");
        game.makeAGuess(scanner);
        assertEquals(150, game.getUserGuess());
        assertEquals("Number must be between 1 and 100!", game.getLastErrorMessage());
    }

    @Test
    @DisplayName("Test <0 input")
    void testIndexOutOfBound_LowNumber() {
        GuessNumberGameV2 game = new GuessNumberGameV2();
        game.setTarget(50);
        Scanner scanner = new Scanner("-2");
        game.makeAGuess(scanner);
        assertEquals(-2, game.getUserGuess());
        assertEquals("Number must be between 1 and 100!", game.getLastErrorMessage());
    }

    @Test
    @DisplayName("Test invalid input_String")
    void testInputMismatch_String() {
        GuessNumberGameV2 game = new GuessNumberGameV2();
        game.setTarget(50);
        Scanner scanner = new Scanner("a");
        game.makeAGuess(scanner);
        assertEquals(-1, game.getUserGuess());
        assertEquals("Only integers are allowed.", game.getLastErrorMessage());
    }

    @Test
    @DisplayName("Test invalid input_float")
    void testInputMismatch_Float(){
        GuessNumberGameV2 game = new GuessNumberGameV2();
        game.setTarget(50);
        Scanner scanner = new Scanner("12.5");
        game.makeAGuess(scanner);
        assertEquals(-1, game.getUserGuess());
        assertEquals("Only integers are allowed.", game.getLastErrorMessage());
    }

    @Test
    @DisplayName("Test boundary value 1")
    void boundaryTestOne(){
        GuessNumberGameV2 game = new GuessNumberGameV2();
        game.setTarget(50);
        Scanner scanner = new Scanner("1");
        game.makeAGuess(scanner);
        assertEquals(1, game.getUserGuess());
        assertEquals(1,game.getRound());
        assertFalse(game.isMatchTarget());
        assertEquals("",game.getLastErrorMessage());
        assertEquals(1, game.getLowerBound());
        assertEquals(100, game.getUpperBound());
    }

    @Test
    @DisplayName("Test boundary value 100")
    void boundaryTestHundred(){
        GuessNumberGameV2 game = new GuessNumberGameV2();
        game.setTarget(50);
        Scanner scanner = new Scanner("100");
        game.makeAGuess(scanner);
        assertEquals(100, game.getUserGuess());
        assertEquals(1,game.getRound());
        assertFalse(game.isMatchTarget());
        assertEquals("",game.getLastErrorMessage());
        assertEquals(1, game.getLowerBound());
        assertEquals(100, game.getUpperBound());
    }

    @Test
    @DisplayName("Test correct guess")
    void testCorrectGuest(){
        GuessNumberGameV2 game = new GuessNumberGameV2();
        int target = game.getTarget();
        Scanner scanner = new Scanner(Integer.toString(target));
        game.makeAGuess(scanner);
        assertTrue(game.isMatchTarget());
        assertEquals(1,game.getRound());
    }

    @Test
    @DisplayName("Multiple input test")
    void testMultipleInput(){
        GuessNumberGameV2 game = new GuessNumberGameV2();
        game.setTarget(45);
        Scanner scanner = new Scanner("30\n40\n50");
        game.makeAGuess(scanner);
        assertEquals(30, game.getUserGuess());
        assertFalse(game.isMatchTarget());
        assertEquals(30, game.getLowerBound());
        assertEquals(100, game.getUpperBound());
        game.makeAGuess(scanner);
        assertEquals(40, game.getUserGuess());
        assertFalse(game.isMatchTarget());
        assertEquals(40, game.getLowerBound());
        assertEquals(100, game.getUpperBound());
        game.makeAGuess(scanner);
        assertEquals(50, game.getUserGuess());
        assertFalse(game.isMatchTarget());
        assertEquals(40, game.getLowerBound());
        assertEquals(50, game.getUpperBound());
        assertEquals(3, game.getRound());
    }
}