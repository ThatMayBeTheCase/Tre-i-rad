public class Main {
    public static void main(String[] args) {
        Board b = new Board();
        b.placeMark(1, 'X');
        b.placeMark(2, 'X');
        b.placeMark(3, 'X');
        b.printBoard();
        System.out.println("Has winner? " + b.hasWinner());
    }
}
