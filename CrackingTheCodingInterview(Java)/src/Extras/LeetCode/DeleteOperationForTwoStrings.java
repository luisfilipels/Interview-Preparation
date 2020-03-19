package Extras.LeetCode;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {

    // My solution. 8ms.
    static int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] line : dp) {
            Arrays.fill(line, -1);
        }
        dp[0][0] = 0;
        return helper(word1, word2, word1.length()-1, word2.length()-1, dp);
    }

    static int helper (String str1, String str2, int i, int j, int[][] dp) {
        if (dp[i+1][j+1] != -1) {
            return dp[i+1][j+1];
        }
        if (i == -1 && j == -1) return 0;
        if (i == -1) {
            dp[i+1][j+1] = j + 1;
            return dp[i+1][j+1];
        }
        if (j == -1) {
            dp[i+1][j+1] = i + 1;
            return dp[i+1][j+1];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i+1][j+1] = helper(str1, str2, i-1, j-1, dp);
            return dp[i+1][j+1];
        }
        dp[i+1][j+1] = 1 + Math.min(helper(str1, str2, i-1, j, dp), helper(str1, str2, i, j-1, dp));
        return dp[i+1][j+1];
    }
    /*
    // Old answer that I found online. 58 ms.
    private static int minDistance (String word1, String word2) {

        int [][] dp = new int[word1.length()+1][word2.length()+1];
        return word1.length() + word2.length() - 2 * minDistance(word1, word2, word1.length(), word2.length(), dp);
    }

    private static int minDistance (String word1, String word2, int i, int j, int[][] dp) {

        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
            dp[i][j] = 1 + minDistance(word1, word2, i-1, j-1, dp);
            return dp[i][j];
        }

        dp[i][j] = Math.max(minDistance(word1, word2, i, j - 1, dp), minDistance(word1, word2, i-1, j, dp));
        return dp[i][j];
    }
    */

    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";

        System.out.println(minDistance(s1,s2));
    }
}
