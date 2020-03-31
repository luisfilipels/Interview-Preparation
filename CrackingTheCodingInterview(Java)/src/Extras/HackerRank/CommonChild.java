package Extras.HackerRank;

import java.util.Arrays;

public class CommonChild {

    /*
    Consider s1 = "SHINCHAN" and s2 = "NOHARNS"
    Let's do a bottom-up solution.
    Consider the following table:

            "" S H I N C H A N
          "" 0 0 0 0 0 0 0 0 0
          N  0 x y z h
          O  0
          H  0
          A  0
          R  0
          N  0
          S  0

    What does position x symbolize? It simbolises "What is the largest subsequence of the strings "N" and "S"?" Logically,
    it's zero. The same can be said for positions y through z. But what about position h? It means "What is the largest
    subsequence of the strings "N" and "SHIN"?" They have an N in common, so one. What is the recurrence relation when we
    find that two characters are the same, in the brute force solution? It is helper(..,...,i-1,j-1,...) + 1. We do the same
    here.


     */

    static int commonChild(String s1, String s2) {
        int [][] dp = new int[s1.length()+1][s2.length()+1];
        for (int l = 1; l < dp.length; l++) {
            for (int c = 1; c < dp[0].length; c++) {
                if (s1.charAt(l-1) == s2.charAt(c-1)) {
                    dp[l][c] = dp[l-1][c-1] + 1;
                } else {
                    dp[l][c] = Math.max(dp[l-1][c], dp[l][c-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];

    }

    // Results in Stack Overflow
    /*static int commonChild(String s1, String s2) {
        int [][] memo = new int[s1.length()+1][s2.length()+1];
        for (int [] line : memo) {
            Arrays.fill(line, -1);
        }
        helper(s1, s2, s1.length()-1, s2.length()-1, memo);
        return memo[s1.length()-1][s2.length()-1];
    }

    static int helper(String s1, String s2, int i, int j, int[][] memo) {

        if (-1 == i || -1 == j) return 0;

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + helper(s1, s2, i-1, j-1, memo);
            return memo[i][j];
        }

        int rS1 = helper(s1, s2, i-1, j, memo);
        int rS2 = helper(s1, s2, i, j-1, memo);

        memo[i][j] = Math.max(rS1, rS2);
        return memo[i][j];


    }*/

    public static void main(String[] args) {
        String s1 = "HARRY";
        String s2 = "SALLY";
        System.out.println(commonChild(s1, s2));

    }

}
