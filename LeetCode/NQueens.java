import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NQueens {

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> returnList = new ArrayList<>();

        char [] template = new char[n];
        for (int i = 0; i < n; i++) {
            template[i] = '.';
        }

        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            System.arraycopy(template, 0, board[r], 0, n);
        }

        helper(0, n, board, new HashSet<>(), new HashSet<>(), new HashSet<>(), returnList);

        return returnList;
    }

    // My first solution. Passes, but is slow due to creating new copies of objects at each iteration.
    /*private static void helper (int currentRow, int n, char [][] board, HashSet<Integer> cols,
                                HashSet<Integer> mainDiags, HashSet<Integer> secDiags,
                                List<List<String>> result)
    {
        if (currentRow == n) {
            List<String> boardString = new ArrayList<>();
            for (char [] row : board) {
                boardString.add(String.valueOf(row));
            }
            result.add(boardString);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (!cols.contains(c)) {
                int mainDiag = c - currentRow;
                int secDiag = (n - c) - currentRow;
                if (!mainDiags.contains(mainDiag) && !secDiags.contains(secDiag)) {
                    HashSet<Integer> newCols = new HashSet<>(cols);
                    HashSet<Integer> newMainDiags = new HashSet<>(mainDiags);
                    HashSet<Integer> newSecDiags = new HashSet<>(secDiags);

                    char[][] newBoard = new char[n][n];
                    for (int r = 0; r < n; r++) {
                        System.arraycopy(board[r], 0, newBoard[r], 0, n);
                    }

                    newBoard[currentRow][c] = 'Q';

                    newCols.add(c);
                    newMainDiags.add(mainDiag);
                    newSecDiags.add(secDiag);

                    helper(currentRow+1, n, newBoard, newCols, newMainDiags, newSecDiags, result);
                }
            }
        }
    }*/

    // My second solution. Much faster than the previous, and actually uses backtracking.
    private static void helper (int currentRow, int n, char[][] board, HashSet<Integer> cols,
                                HashSet<Integer> mainDiags, HashSet<Integer> secDiags, List<List<String>> result) {
        if (currentRow == n) {
            List<String> boardString = new ArrayList<>();
            for (char [] row : board) {
                boardString.add(String.valueOf(row));
            }
            result.add(boardString);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (!cols.contains(c)) {
                int mainDiag = c - currentRow;
                int secDiag = (n - c) - currentRow;
                if (!mainDiags.contains(mainDiag) && !secDiags.contains(secDiag)) {
                    cols.add(c);
                    mainDiags.add(mainDiag);
                    secDiags.add(secDiag);
                    board[currentRow][c] = 'Q';
                    helper(currentRow+1, n, board, cols, mainDiags, secDiags, result);
                    cols.remove(c);
                    mainDiags.remove(mainDiag);
                    secDiags.remove(secDiag);
                    board[currentRow][c] = '.';
                }
            }
        }
    }



    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

}
