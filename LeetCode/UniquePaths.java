package Extras.LeetCode;

import java.util.Arrays;

public class UniquePaths {

    static private int uniquePaths (int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int [][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int l = 0; l < n; l++) {
            for (int c = 0; c < m; c++) {
                if (l-1 >= 0) {
                    dp[l][c] += dp[l-1][c];
                }
                if (c-1 >= 0) {
                    dp[l][c] += dp[l][c-1];
                }
            }
        }
        return dp[n-2][m-1] + dp[n-1][m-2];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }

}
