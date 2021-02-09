public class GridUniquePaths {

    public int uniquePaths(int A, int B) {
        int[][] dp = new int[A][B];

        for (int r = 0; r < A; r++) {
            dp[r][0] = 1;
        }
        for (int c = 0; c < B; c++) {
            dp[0][c] = 1;
        }

        for (int r = 1; r < A; r++) {
            for (int c = 1; c < B; c++) {
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }

        return dp[A-1][B-1];
    }

}
