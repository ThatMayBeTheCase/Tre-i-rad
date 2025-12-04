# Tic-Tac-Toe

A simple two-player, text-based Tic-Tac-Toe game for the
console. Written in Java. Tracks player names and running
score, validates input, and restarts after each round.

## How to run
```
javac *.java
java Main
```
Follow the prompts: enter player names, choose positions 1-9,
and decide whether to play again.

## Files
- `Board.java` – board state
- `Player.java` – player name and mark (X/O)
- `Game.java` – game loop, input handling, scoring
- `Main.java` – starts the game

## Notes
- Input is validated: only numbers 1-9 and empty cells are
accepted.
- Scores accumulate across rounds until you quit.
