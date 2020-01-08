package Extras.LeetCode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class WordSearch {

    private static boolean isValid (char [][] board, int h, int w, char c) {
        return h >= 0 && w >= 0 && h < board.length && w < board[0].length && c == board[h][w];
    }

    private static boolean exist(char [][] board, String word) {
        for (int h = 0; h < board.length; h++) {
            for (int w = 0; w < board[0].length; w++) {
                if (board[h][w] == word.charAt(0)) {
                    if (dfs(board, h, w, 0, word)) return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs (char[][] board, int h, int w, int currentIndex, String wordArray) {
        if (currentIndex == wordArray.length()) return true;
        if (!(h >= 0 && w >= 0 && h < board.length && w < board[0].length && wordArray.charAt(currentIndex) == board[h][w])) return false;
        board[h][w] = '1';
        boolean values = dfs(board, h-1, w, currentIndex+1, wordArray)
        ||dfs(board, h, w+1, currentIndex+1, wordArray)
        ||dfs(board, h+1, w, currentIndex+1, wordArray)
        ||dfs(board, h, w-1, currentIndex+1, wordArray);
        board[h][w] = wordArray.charAt(currentIndex);
        return values;
    }

    public static void main(String[] args) {
        /*char[][] input = new char[][] {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'e', 's'},
                {'a', 'd', 'e', 'e'}
        };*/
        char [][] input = new char[][] {
                {'a'}
        };
        String word = "ab";
        System.out.println(exist(input, word));
    }

}
