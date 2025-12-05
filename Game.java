import java.util.Scanner;
public class Game {
    private final Scanner in = new Scanner(System.in);
    private final Board board = new Board();
    private Player p1, p2, current;
    private int score1, score2;

    public void run() {
        setupPlayers();
        while (true) {
            playOneRound();
            if (!askYesNo("Play again? (y/n): "))
                break;
        }
        System.out.println("Final score - " + p1.getName() + ": " + score1 + ", " + p2.getName() + ": " + score2);
        System.out.println("Thanks for playing!");
    }

    private void setupPlayers() {
        System.out.print("Player 1 name (X): ");
        p1 = new Player(in.nextLine().trim(), 'X');

        System.out.print("Player 2 name (O): ");
        p2 = new Player(in.nextLine().trim(), 'O');
    }

    private void playOneRound() {
        board.reset();
        current = p1;
        while (true) {
            board.printBoard();
            System.out.print(current.getName() + " (" + current.getMark() + "), choose a position 1-9: ");
            int move = readMove();
            board.placeMark(move, current.getMark());

            if (board.hasWinner()) {
                board.printBoard();
                System.out.println(current.getName() + " wins!");
                updateScore();
                printScore();
                return;
            }
            if (board.isFull()) {
                board.printBoard();
                System.out.println("Draw!");
                printScore();
                return;
            }
            switchPlayer();
        }
    }

    private int readMove() {
        while (true) {
            String line = in.nextLine().trim();
            try {
                int pos = Integer.parseInt(line);
                if (pos < 1 || pos > 9) {
                    System.out.print("Enter a number 1-9: ");
                    continue;
                }
                if (!board.isCellFree(pos)) {
                    System.out.print("That spot is taken, try again: ");
                    continue;
                }
                return pos;
            }
            catch (NumberFormatException e) {
                System.out.print("Not a number, try again: ");
            }
        }
    }
    private void switchPlayer() {
        current = (current == p1) ? p2 : p1;
    }
    private void updateScore() {
        if (current == p1) score1++;
        else score2++;
    }
    private void printScore() {
        System.out.println("Score - " + p1.getName() + ": " + score1 + ", " + p2.getName() + ": " + score2);
    }

    private boolean askYesNo(String prompt) {
        System.out.print(prompt);
        while (true) {
            String s = in.nextLine().trim().toLowerCase();
            if (s.equals("y"))
                return true;
            if (s.equals("n"))
                return false;
            System.out.print("Please answer y or n: ");
        }
    }
}
