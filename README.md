
# Number Guessing Game
Welcome to the Number Guessing Game! This is a simple Java console application that allows users to play two different number guessing game modes.

## Game Modes
1. Guess the Number (1 to 100)

- The player must guess a number between 1 and 100.
- The game provides hints to help the player narrow down their guesses.
- The game ends when the player correctly guesses the number.
2. Avoid the Specified Number

- The player must guess a number between 1 and 100 without hitting a specific target number.
- The game provides hints to help the player avoid the target number.
- The game ends when the player accidentally guesses the target number.
## How to Run
1. Clone the repository:

```
git clone https://github.com/yourusername/number-guessing-game.git
```
2. Navigate to the project directory:

```
cd number-guessing-game
```
3. Compile the Java files:
```
javac -d bin src/org/example/*.java
```
4. Run the game:
```
java -cp bin org.example.Main
```
## Code Structure
### Main Class
- Main: The entry point of the application. It prompts the user to select a game mode and initializes the corresponding game class.
### Game Classes
- GuessNumberGame: The base class for the guessing game. It includes methods for handling user input, checking results, and providing hints.
- GuessNumberGameV2: Extends GuessNumberGame for the "Avoid the Specified Number" mode. It adjusts the guessing range based on the user's guesses.
- GuessNumberGameV3: Extends GuessNumberGame for the "Guess the Number" mode. It provides different hints based on how close the user's guess is to the target number.
## Usage
1. Run the application.
2. Select a game mode by entering 1 or 2.
3. Follow the prompts to make guesses.
4. Receive hints and try to win the game based on the mode you selected.
## Example
```
Welcome to the Number Guessing Game!
Please select a game mode:
1: Guess the number between 1 and 100
2: Avoid the specified number at all costs
You will receive hints to help you narrow down your guess.
Enter your choice [1/2]: 1
You have selected: Guess the number between 1 and 100.
Let's see how many attempts you need to guess the correct number!
Please input a number between 1 and 100:
50
Far Far away
Please input a number between 1 and 100:
25
Almost!
Please input a number between 1 and 100:
30
Few steps away
...
```

### Contributions
Feel free to fork the repository and submit pull requests. If you find any issues or have suggestions, please open an issue on GitHub.

### License
This project is licensed under the MIT License. See the LICENSE file for details.
#
Enjoy the game! If you have any questions or feedback, please feel free to reach out.
