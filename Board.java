public class Board {
    private final char[][] grid = new char[3][3];

    public Board() {
        reset();
    }
    public void reset() {
        //fill board with spaces.
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                grid[r][c] = ' ';
            }
        }
    }

    // row/column 1-9 helper.
    private int row(int pos) { return (pos - 1) / 3; }
    private int col(int pos) { return (pos - 1) % 3; }

    public boolean isCellFree(int pos) {
        int r = row(pos), c = col(pos);
        return grid[r][c] == ' ';
    }

    public boolean placeMark(int pos, char mark) {
        if (!isCellFree(pos)) return false;
        grid[row(pos)][col(pos)] = mark;
        return true;
    }

    public boolean isFull() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }

    private static final int[][] LINES = {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, //row.
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, //cols.
            {1, 5, 9}, {3, 5, 7}
    };

    public boolean hasWinner() {
        for (int[] line : LINES) {
            if (sameMark(line[0], line[1], line[2])) {
                return true;
            }
        }
        return false;
    }

    private boolean sameMark(int a, int b, int c) {
        char m = grid[row(a)][col(a)];
        return m != ' ' && m == grid[row(b)][col(b)] && m == grid[row(c)][col(c)];
    }

    public void printBoard() {
        int pos = 1;
        for (int r = 0; r < 3; r++) {
            System.out.printf(" %c | %c | %c %n",
                    display(pos++), display(pos++), display(pos++));
            if (r < 2) System.out.println("---+---+---");
        }
    }

    private char display(int pos) {
        char cell = grid[row(pos)][col(pos)];
        return (cell == ' ') ? Character.forDigit(pos, 10) : cell;
    }
}
