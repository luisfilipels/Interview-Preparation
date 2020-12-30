import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String wordFormed = null;
    }

    void addToTrie(String s, TrieNode root) {
        TrieNode runner = root;
        for (char c : s.toCharArray()) {
            if (!runner.children.containsKey(c)) {
                runner.children.put(c, new TrieNode());
            }
            runner = runner.children.get(c);
        }
        runner.wordFormed = s;
    }

    boolean isValid (char[][] board, int r, int c) {
        return (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] != '*');
    }

    void dfs(char [][] board, TrieNode runner, int r, int c, HashSet<String> set) {
        if (runner.wordFormed != null) {
            set.add(runner.wordFormed);
        }

        char bkp = board[r][c];
        board[r][c] = '*';

        if (isValid(board, r+1, c) && runner.children.containsKey(board[r+1][c])) {
            dfs(board, runner.children.get(board[r+1][c]), r+1, c, set);
            // This optimization saves 216ms of time!
            if (runner.children.get(board[r+1][c]).children.isEmpty()) runner.children.remove(board[r+1][c]);
        }
        if (isValid(board, r-1, c) && runner.children.containsKey(board[r-1][c])) {
            dfs(board, runner.children.get(board[r-1][c]), r-1, c, set);
            if (runner.children.get(board[r-1][c]).children.isEmpty()) runner.children.remove(board[r-1][c]);
        }
        if (isValid(board, r, c+1) && runner.children.containsKey(board[r][c+1])) {
            dfs(board, runner.children.get(board[r][c+1]), r, c+1, set);
            if (runner.children.get(board[r][c+1]).children.isEmpty()) runner.children.remove(board[r][c+1]);
        }
        if (isValid(board, r, c-1) && runner.children.containsKey(board[r][c-1])) {
            dfs(board, runner.children.get(board[r][c-1]), r, c-1, set);
            if (runner.children.get(board[r][c-1]).children.isEmpty()) runner.children.remove(board[r][c-1]);
        }

        board[r][c] = bkp;


    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            addToTrie(word, root);
        }

        HashSet<String> returnSet = new HashSet<>();

        int n = board.length;
        int m = board[0].length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (root.children.containsKey(board[r][c])) {
                    dfs(board, root.children.get(board[r][c]), r, c, returnSet);
                }
            }
        }

        return new ArrayList<String>(returnSet);
    }
}
