package Extras.LeetCode;

public class DeleteOperationForTwoStrings {

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


    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";

        System.out.println(minDistance(s1,s2));
    }
}
