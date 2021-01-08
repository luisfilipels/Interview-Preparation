package Extras.LeetCode;

import java.util.Arrays;

public class UniquePaths {

    static private int uniquePaths (int m, int n) {
        int [][] dp = new int[m][n];

        for (int c = 0; c < n; c++) {
            dp[0][c] = 1;
        }

        for (int r = 0; r < m; r++) {
            dp[r][0] = 1;
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }

}
