import java.util.HashSet;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[][] squares = new HashSet[3][3];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
        }

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                squares[r][c] = new HashSet<>();
            }
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    char current = board[r][c];

                    if (rows[r].contains(current)) return false;
                    else rows[r].add(current);

                    if (columns[c].contains(current)) return false;
                    else columns[c].add(current);

                    if (squares[r/3][c/3].contains(current)) return false;
                    else squares[r/3][c/3].add(current);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
