package Extras.LeetCode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class WordSearch {

    private static boolean exist(char [][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    boolean result = helper(word, 0, board, r, c);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(String word, int currentCharIdx, char[][] board, int r, int c){
        if (currentCharIdx == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || word.charAt(currentCharIdx) != board[r][c]) return false;

        board[r][c] = '*';
        boolean result = helper(word, currentCharIdx + 1, board, r+1, c) ||
                helper(word, currentCharIdx + 1, board, r-1, c) ||
                helper(word, currentCharIdx + 1, board, r, c-1) ||
                helper(word, currentCharIdx + 1, board, r, c+1);

        board[r][c] = word.charAt(currentCharIdx);

        return result;
    }

    public static void main(String[] args) {
        char[][] input = new char[][] {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'e', 's'},
                {'a', 'd', 'e', 'e'}
        };
        /*char [][] input = new char[][] {
                {'a'}
        };*/
        String word = "abfdz";
        System.out.println(exist(input, word));
    }

}
