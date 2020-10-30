import java.util.Arrays;

public class GameOfLife {

    private static boolean isValid (int R, int C, int r, int c) {
        return r >=0 && r < R && c >= 0 && c < C;
    }

    private static int calcNewState (int [][] board, int row, int col) {
        int countNeighbors = 0;

        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (r == 0 && c == 0) continue;
                int newR = row + r;
                int newC = col + c;
                if (isValid(board.length, board[0].length, newR, newC)) {
                    if (board[newR][newC] == 1 || board[newR][newC] == -1) {
                        countNeighbors++;
                    }
                }
            }
        }
        if (board[row][col] == 1) {
            if (countNeighbors == 2 || countNeighbors == 3) {
                return 1;   // Rule 2
            } else {
                return -1;  // Rules 1 and 3
            }
        } else {
            if (countNeighbors == 3) {
                return 2;   // Rule 4
            } else {
                return 0;
            }
        }
    }

    /*
    To do all operations in-place, and in two passes, a code is used:
    -1: Living cell will die
     0: Dead cell will remain dead
     1: Living cell will remain alive
     2: Dead cell will become alive
     Thus, we use the same board that was passed into the function, check the amount of neighbors each cell has, and
     change each cell's state in a non-destructive manner. When this is done, we do another pass on the board, converting
     -1 to 0, and 2 to 1.
     */
    private static void gameOfLife(int [][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = calcNewState(board, r, c);
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == -1) {
                    board[r][c] = 0;
                } else if (board[r][c] == 2) {
                    board[r][c] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [][] board = new int[][] {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        gameOfLife(board);

        System.out.println(Arrays.deepToString(board));
    }

}
