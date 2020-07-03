package Extras.LeetCode;

import java.util.Arrays;

public class CoinChange {

    // New DP solution. Bottom-up. Beats 97.95% of the other solutions, time-wise :D
    /*
    As this is a bottom-up solution, we consider smaller sub-problems. We create a dp array and consider each position i
    of it a representing the least amount of coins needed to reach i. Logically, to reach a value of 0, we need 0 coins.
    So, for all other positions of the array we consider what would happen if we tried to insert into our solution each
    of the coins we have. So, for the case in which we have coins = [1, 2, 5], and amount = 7:

    dp = [0, x, y, z, w, h, k, l]

    How can we calculate x (amount = 1)? If we add the first coin to our solution (1), we have 0 remaining, so, we return
    dp[0] + 1 (from the coin we added to our change). We will still consider the other 2 coins, but since 1 - 2 and 1 - 5
    are negative, we don't consider those.

    dp = [0, 1, y, z, w, h, k, l]

    Now, how can we calculate y (amount = 2)? We can consider adding coin (1), which will be the solution we had for
    amount = 1, plus 1. However, we can also consider adding coin (2), which will be the solution we had for amount = 0,
    plus 1, which will be 0 + 1 = 1. So, for amount = 2, we only need to select 1 coin.

    dp = [0, 1, 1, z, w, h, k, l]

    And for amount = 3? Well, we can add coin (1), in which case we will have an amount of 2 waiting to be filled. Or,
    we can add coin (2), in which case we will have 1 waiting to be filled. In both cases, we will have used the amount
    of coins used in amount = 2 or amount = 1, plus one, so, 2 coins.

    dp = [0, 1, 1, 2, w, h, k, l]

    Finally, for amount = 4. We can try using coin (1), in which case we wil have used the amount of coins used for
    amount = 3, plus 1, so, 3 coins. Or, we can use coin (2), which will result in us using the amount of coins used for
    amount = 2, plus 1, so, 2 coins. So, we end up using coin (2), and so on...

    dp = [0, 1, 1, 2, 2, h, k, l]

     */
    static int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = amount+1;
            for (int c = 0; c < coins.length; c++) {
                int complement = i - coins[c];
                if (complement < 0) {
                    continue;
                }
                min = Math.min(dp[complement] + 1, min);
            }
            dp[i] = min;
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

    // Old DP solution. Top-down. Don't fully understand it.
    /*
    private static int coinChange (int [] coins, int amount) {
        Arrays.sort(coins);
        dp = new int[amount+1];
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
        if (dp[amountRemaining] != 0) {
            return dp[amountRemaining];
        }
        int min = Integer.MAX_VALUE;
        for (int i = coins.length-1; i >= 0; i--) {
            int currentCheck = Math.min(min, helper(coins, amountRemaining - coins[i]));
            if (currentCheck >= 0 && currentCheck < min) {
                min = currentCheck + 1;
            }
        }
        dp[amountRemaining] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amountRemaining];
    }

    public static void main(String[] args) {
        int [] coins = new int[] {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }
    */

}
