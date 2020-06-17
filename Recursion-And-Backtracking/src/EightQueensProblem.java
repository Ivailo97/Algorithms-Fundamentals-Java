import java.util.Arrays;

public class EightQueensProblem implements Solution {

    private static final int BOARD_SIZE = 8;
    private char[][] board;
    private boolean[] leftDiagonals;
    private boolean[] rightDiagonals;
    private boolean[] cols;

    @Override
    public void solve() {
        init();
        putQueens(0);
    }

    private void putQueens(int row) {
        if (row == board.length) {
            printBoard();
        } else {
            for (int col = 0; col < board.length; col++) {
                if (canPlaceQueen(row, col)) {
                    setQueen(row, col);
                    putQueens(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private void setQueen(int row, int col) {
        board[row][col] = '*';
        markAttacked(row, col);
    }

    private void removeQueen(int row, int col) {
        board[row][col] = '-';
        unmarkAttacked(row, col);
    }

    private void unmarkAttacked(int row, int col) {
        cols[col] = false;
        leftDiagonals[getLeftDiagonalIndex(row, col)] = false;
        rightDiagonals[getRightDiagonalIndex(row, col)] = false;
    }

    private void markAttacked(int row, int col) {
        cols[col] = true;
        leftDiagonals[getLeftDiagonalIndex(row, col)] = true;
        rightDiagonals[getRightDiagonalIndex(row, col)] = true;
    }

    private boolean canPlaceQueen(int row, int col) {
        return !cols[col] && !leftDiagonals[getLeftDiagonalIndex(row, col)]
                && !rightDiagonals[getRightDiagonalIndex(row, col)];
    }

    private int getRightDiagonalIndex(int row, int col) {
        return BOARD_SIZE * 2 - 2 - (col + row);
    }

    private int getLeftDiagonalIndex(int row, int col) {
        return col - row + BOARD_SIZE - 1;
    }

    private void init() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        leftDiagonals = new boolean[BOARD_SIZE * 2 - 1];
        rightDiagonals = new boolean[BOARD_SIZE * 2 - 1];
        cols = new boolean[BOARD_SIZE];
        for (char[] row : board) {
            Arrays.fill(row, '-');
        }
    }

    private void printBoard() {
        for (char[] row : board) {
            for (char symbol : row) {
                System.out.printf("%s ", symbol);
            }
            System.out.println();
        }
        System.out.println();
    }
}
