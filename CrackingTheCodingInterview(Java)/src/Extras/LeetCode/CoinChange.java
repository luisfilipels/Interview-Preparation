package Extras.LeetCode;

import java.util.Arrays;

public class CoinChange {

    private static int coinChange (int [] coins, int amount) {
        Arrays.sort(coins);
        dp = new int[amount];
        int result = helper(coins, amount);
        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    private static int [] dp;

    private static int helper (int [] coins, int amountRemaining) {
        if (amountRemaining < 0) return -1;
        if (amountRemaining == 0) return 0;
        if (dp[amountRemaining - 1] != 0) {
            return dp[amountRemaining - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = coins.length-1; i >= 0; i--) {
            int currentCheck = Math.min(min, helper(coins, amountRemaining - coins[i]));
            if (currentCheck >= 0 && currentCheck < min) {
                min = currentCheck + 1;
            }
        }
        dp[amountRemaining - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amountRemaining - 1];
    }

    public static void main(String[] args) {
        int [] coins = new int[] {1, 2, 5};
        System.out.println(coinChange(coins, 4));
    }

}
