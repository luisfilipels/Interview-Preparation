import java.util.ArrayList;
import java.util.HashSet;

public class SudokuSolver {

    private static void solveSudoku(char [][] board) {

        boolean [][] rows = new boolean[9][10];
        boolean [][] cols = new boolean[9][10];
        boolean [][][] squares = new boolean[3][3][10];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '0';
                    rows[r][num] = true;
                    cols[c][num] = true;
                    squares[r/3][c/3][num] = true;
                }
            }
        }

        solveSudoku(board, rows, cols, squares, 0, 0, new boolean[1]);

    }

    private static void solveSudoku(char [][] board, boolean [][] rows, boolean [][] cols,
                                    boolean[][][] squares, int r, int c, boolean[] solutionFound) {
        if (r == 9) {
            solutionFound[0] = true;
            return;
        }
        if (solutionFound[0]) return;
        if (board[r][c] == '.') {
            for (int i = 1; i <= 9; i++) {
                if (!rows[r][i] && !cols[c][i] && !squares[r/3][c/3][i]) {
                    board[r][c] = (char) ('0' + i);
                    rows[r][i] = true;
                    cols[c][i] = true;
                    squares[r/3][c/3][i] = true;
                    solveSudoku(board, rows, cols, squares,  (c == 8 ? r+1 : r), (c == 8 ? 0 : c+1), solutionFound);
                    if (solutionFound[0]) return;
                    board[r][c] = '.';
                    rows[r][i] = false;
                    cols[c][i] = false;
                    squares[r/3][c/3][i] = false;
                }
            }
        } else {
            solveSudoku(board, rows, cols, squares, (c == 8 ? r+1 : r), (c == 8 ? 0 : c+1), solutionFound);
        }
    }

    public static void main(String[] args) {
        char [][] board = new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
    }

}
