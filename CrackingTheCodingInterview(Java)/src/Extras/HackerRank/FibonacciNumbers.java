package Extras.HackerRank;

import java.util.Arrays;

public class FibonacciNumbers {

    private static int fibonacci (int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        return fibonacci(n, dp);
    }

    private static int fibonacci (int n, int [] dp) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != -1) return dp[n];

        dp[n] = fibonacci(n-1, dp) + fibonacci(n-2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }

}
