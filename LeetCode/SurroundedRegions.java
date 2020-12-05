import java.util.Arrays;

public class SurroundedRegions {

    private static boolean isValid(char[][] board, int n, int m, int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m && board[r][c] == 'O';
    }

    private static void dfs(char[][] board, int r, int c, char substitute) {
        if (!isValid(board, board.length, board[0].length, r, c)) return;

        board[r][c] = substitute;
        dfs(board, r+1, c, substitute);
        dfs(board, r-1, c, substitute);
        dfs(board, r, c+1, substitute);
        dfs(board, r, c-1, substitute);
    }

    private static void solve(char[][] board) {
        if (board.length == 0) return;

        int n = board.length;
        int m = board[0].length;

        for (int c = 0; c < m; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c, 'Y');
            }
            if (board[n-1][c] == 'O') {
                dfs(board, n-1, c, 'Y');
            }
        }
        for (int r = 0; r < n; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0, 'Y');
            }
            if (board[r][m-1] == 'O') {
                dfs(board, r, m-1, 'Y');
            }
        }
        for (int r = 1; r < n-1; r++) {
            for (int c = 1; c < m-1; c++) {
                if (board[r][c] == 'O') {
                    dfs(board, r, c, 'X');
                }
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == 'Y') {
                    board[r][c] = 'O';
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };

        solve(board);

        System.out.println(Arrays.deepToString(board));
    }

}
